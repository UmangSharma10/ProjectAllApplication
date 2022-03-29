package interpreter;

import Bootstrap.Bootstrap;
import Master.Register;
import Repository.DAO;

import java.util.Scanner;

public class Interpreter {
    public static void start() {
        int switchChoice=0;

        while (!(switchChoice == 6)) {

        System.out.println("+++++++++++++++++Welcome to Shipment and Logistics++++++++++++++++");
        System.out.println("1 : Login");
        System.out.println("2 : Register");
        System.out.println("3 : Add Driver");
        System.out.println("4 : Add Package");
        System.out.println("5 : Show Database");
        System.out.println("6 : Exit");
        System.out.println("Enter from the choice");
            switchChoice = Bootstrap.scanner.nextInt();

            switch (switchChoice) {
                case 1:
                    System.out.println("Under Construction");
                    break;

                case 2:

                    var r1 = new Register();
                    r1.addDescription();


                    break;
                case 5:

                    break;

                case 6:
                    System.exit(0);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + switchChoice);
            }
        }
    }
}
