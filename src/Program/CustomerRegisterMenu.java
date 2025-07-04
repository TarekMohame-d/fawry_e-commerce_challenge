package Program;

import Contract.Repository.ICustomerRepository;
import Contract.Services.ICustomerServices;
import DTOs.Customer.CustomerRegisterRequestDto;
import Implementation.Repository.CustomerRepository;
import Implementation.Services.CustomerServices;
import Program.CustomerMenus.CustomerLoginMenu;

import java.util.Scanner;
import java.util.UUID;

public class CustomerRegisterMenu {
    private static ICustomerServices customerServices;

    public static void Run() {
        customerServices = new CustomerServices();

        Scanner sc = new Scanner(System.in);
        System.out.println("============================== Register ==============================");
        boolean exit = false;
        while (!exit) {
            System.out.print("First Name: ");
            String firstName = sc.nextLine();

            System.out.print("Last Name: ");
            String lastName = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Password: ");
            String password = sc.nextLine();

            System.out.print("Phone: ");
            String phone = sc.nextLine();

            CustomerRegisterRequestDto dto = new CustomerRegisterRequestDto();
            dto.firstName = firstName;
            dto.lastName = lastName;
            dto.email = email;
            dto.password = password;
            dto.phone = phone;

            UUID id = customerServices.registerCustomer(dto);

            if (id != null) {
                System.out.println("Registration successful, Please login to continue.");
                CustomerLoginMenu.Run();
                exit = true;
                break;
            }

            System.out.println("Registration failed. Do you want to try again ? (y/n)");
            String choice = sc.nextLine();
            switch (choice) {
                case "y":
                case "Y":
                    break;
                case "n":
                case "N":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
}
