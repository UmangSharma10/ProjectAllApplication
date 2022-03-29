package Bootstrap;


import interpreter.Interpreter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Bootstrap {
    public static Scanner scanner = new Scanner(System.in);
     public static void main(String[] args) throws IOException {
         //init
         ServerSocket serverSocket = new ServerSocket(5056);
         while (true){
             Socket socket = null;
             try{
                 socket = serverSocket.accept();
                 System.out.println("A new Client is accepted");

                 DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                 DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                 System.out.println("Assigning new Thread");
                 Thread thread = new ClientHandler1(socket, dataInputStream,dataOutputStream);
                 thread.start();


             }
             catch (Exception e){
                 socket.close();
                 System.out.println(e);
             }
         }


        Interpreter.start();
    }
}

class ClientHandler1{
    ClientHandler1(Socket socket, DataInputStream dataInputStream, DataOutputStream dataOutputStream) {

    }

}
