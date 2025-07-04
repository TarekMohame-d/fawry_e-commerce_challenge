package Program.CustomerMenus;

import Contract.Repository.ICustomerRepository;
import Contract.Services.ICustomerServices;
import DTOs.Customer.BaseAuthRequestDto;
import Implementation.Repository.CustomerRepository;
import Implementation.Services.CustomerServices;

import java.util.Scanner;
import java.util.UUID;

public class CustomerLoginMenu {
    private static ICustomerServices customerServices;

    public static void Run() {
        customerServices = new CustomerServices();

        Scanner sc = new Scanner(System.in);
        System.out.println("============================== Login ==============================");
        boolean exit = false;
        while (!exit) {
            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Password: ");
            String password = sc.nextLine();

            BaseAuthRequestDto dto = new BaseAuthRequestDto();
            dto.email = email;
            dto.password = password;

            UUID id = customerServices.loginCustomer(dto);

            if (id != null) {
                System.out.println("Login successful.");
                AddToCartMenu.Run(id);
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
