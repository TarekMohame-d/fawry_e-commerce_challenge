package Program.CustomerMenus;

import Implementation.Services.CustomerServices;
import Program.CustomerRegisterMenu;

import java.util.Scanner;

public class CustomerMenu {
    public static void Run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("============================== Customer Menu ==============================");

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
                continue;
            }

            int option = sc.nextInt();
            switch (option) {
                case 1:
                    CustomerRegisterMenu.Run();
                    break;
                case 2:
                    CustomerLoginMenu.Run();
                    break;
                case 3:
                    System.out.println("Exiting Customer Menu...");
                    return;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
}
