package Master;

import Bootstrap.Bootstrap;
import Repository.DAO;

import java.util.InputMismatchException;

public class Register {
    String name;
     int age;
    String address;
    int pincode;
    String id;

   // Scanner scanner = new Scanner(System.in);

    public void addDescription(){
        try {
            System.out.println("Enter your Name");
            name = Bootstrap.scanner.next();
            Bootstrap.scanner.nextLine();
            System.out.println("Enter your Age");
            age = Bootstrap.scanner.nextInt();
            System.out.println("Enter your Address");
            address = Bootstrap.scanner.next();
            Bootstrap.scanner.nextLine();
            System.out.println("Enter your Pincode");
            pincode = Bootstrap.scanner.nextInt();
            System.out.println("Enter username id");
            id = Bootstrap.scanner.next();



        }

        catch (InputMismatchException E){
            E.printStackTrace();
        }
        DAO.Insert(id, this);








    }
}
