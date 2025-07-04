package Program;

import Program.CustomerMenus.CustomerMenu;

import java.util.Scanner;

public class FirstMenu {
    public static void Run()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("============================== Welcome to the Shop ==============================");

        while (true) {
            System.out.println("1. Customer");
            System.out.println("2. Admin");
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
                    CustomerMenu.Run();
                    break;
                case 2:
                    System.out.println("Admin");
                    break;
                case 3:
                    System.out.println("Exiting Application...");
                    return;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
}
