package Master;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5056);
        while (true){
            Socket socket = null;
            try{
                socket = serverSocket.accept();
                System.out.println("A new Client is accepted");

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                System.out.println("Assigning new Thread");
                Thread thread = new ClientHandler(socket, dataInputStream,dataOutputStream);
                thread.start();


            }
            catch (Exception e){
                socket.close();
                System.out.println(e);
            }
        }

    }
}

class ClientHandler extends Thread{
    DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat fortime = new SimpleDateFormat("hh:mm:ss");
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;

    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos){
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run() {
        String recieved;
        String toreturn;
        //super.run();

        while(true){
            try {
                dos.writeUTF("What do you want?[Date | Time]..\n " + "Type Exit to terminate connection.");
                recieved = dis.readUTF();

                if (recieved.equals("Exit")){
                    System.out.println("Client " + this.s + " sends exit...");
                    System.out.println("Closing this connection.");
                    this.s.close();
                    System.out.println("Connection closed");
                    break;
                }
                Date date = new Date();

                // write on output stream based on the
                // answer from the client
                switch (recieved) {

                    case "Date" :
                        toreturn = fordate.format(date);
                        dos.writeUTF(toreturn);
                        break;

                    case "Time" :
                        toreturn = fortime.format(date);
                        dos.writeUTF(toreturn);
                        break;

                    default:
                        dos.writeUTF("Invalid input");
                        break;
                }


            }catch (Exception e){
                System.out.println(e);
            }
        }

        try{
            this.dis.close();
            this.dos.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
