package Program.CustomerMenus;

import Contract.Services.ICartServices;
import Contract.Services.ICustomerServices;
import Contract.Services.IProductServices;
import DTOs.Customer.BaseAuthRequestDto;
import Entities.Product;
import Implementation.Services.CartService;
import Implementation.Services.CustomerServices;
import Implementation.Services.ProductServices;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class AddToCartMenu {
    private static ICustomerServices customerServices;
    private static IProductServices productServices;
    private static ICartServices cartServices;
    public static void Run(UUID id) {
        customerServices = new CustomerServices();
        productServices = new ProductServices();
        cartServices = new CartService();

        Scanner sc = new Scanner(System.in);
        System.out.println("============================== Shop ==============================");
        List<Product> products = productServices.getAllProducts();
        for(Product product : products) {
            System.out.println(product.getId() + " - " + product.getName() + " - " + product.getPrice() + "€");
        }
        boolean exit = false;
        while (!exit) {
            System.out.print("Choose a product: ");
            String productId = sc.nextLine();

            System.out.println("Quantity: ");
            int quantity = sc.nextInt();

            cartServices.addToCart(id, UUID.fromString(productId), quantity);

            System.out.println("Add another product? (y/n)");
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
