package Program.CustomerMenus;

import Contract.Repository.ICustomerRepository;
import Contract.Services.ICartServices;
import Contract.Services.ICustomerServices;
import Contract.Services.IProductServices;
import DTOs.Product.CartItemDto;
import Entities.Customer;
import Entities.Product;
import Implementation.Repository.CustomerRepository;
import Implementation.Services.CartService;
import Implementation.Services.CustomerServices;
import Implementation.Services.ProductServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class CheckOutMenu {
    private static ICustomerServices customerServices;
    private static ICustomerRepository customerRepository;
    private static IProductServices productServices;
    private static ICartServices cartServices;

    public static void Run(UUID id) {
        customerServices = new CustomerServices();
        productServices = new ProductServices();
        cartServices = new CartService();
        customerRepository = new CustomerRepository();

        Scanner sc = new Scanner(System.in);
        System.out.println("============================== Checkout ==============================");
        List<CartItemDto> products = cartServices.getCartProducts(id);
        Customer customer = customerRepository.getById(id).orElse(null);

        System.out.println("Products in cart:");
        for (CartItemDto product : products) {
            System.out.println(product.getProductId() + " - " + product.getProductName() + " - " + product.getPrice() + "€");
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("1) Checkout: ");
            System.out.println("2) Cancel: ");

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    checkout(products, customer.getBalance());
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }

    private static void checkout(List<CartItemDto> products, double balance) {
        double total = 0.0;
        double weight = 0.0;
        boolean isExpired = false;
        List<CartItemDto> shippedProducts = new ArrayList<>();
        if(products.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        for (CartItemDto product : products) {
            total += product.getPrice();
            weight += product.getWeight();
            if (product.getExpiredAt() != null && product.getExpiredAt().before(new java.util.Date())) {
                isExpired = true;
            }
            if(product.isCanBeShipped())
            {
                shippedProducts.add(product);
            }
        }
        double shippingFees = 10;
        if (weight >= 15.0) {
            shippingFees = 20;
        }
        double totalPaid = total + shippingFees;
        balance -= totalPaid;
        if (balance < 0) {
            System.out.println("Not enough balance.");
        }
        else if (isExpired) {
            System.out.println("There is a product in your cart that is expired.");
        }
        else {
            System.out.println("Shipment notes: ");
            for (CartItemDto product : shippedProducts) {
                System.out.println(product.getQuantity() + "x " + product.getProductName() + " - " + product.getWeight() + "kg");
            }
            System.out.println("Total package weight: " + weight + "kg");

            System.out.println("Checkout receipt: ");
            for (CartItemDto product : shippedProducts) {
                System.out.println(product.getQuantity() + "x " + product.getProductName() + " - " + product.getPrice() + "€");
            }
            System.out.println("Total: " + total + "€");
            System.out.println("Shipping Fees: " + shippingFees + "€");
            System.out.println("Paid Amount: " + totalPaid + "€");
            System.out.println("Balance: " + balance + "€");
        }

        if(!shippedProducts.isEmpty())
        {
            // Call Shipping API
        }
    }
}
