import Contract.Repository.ICustomerRepository;
import Contract.Services.ICartServices;
import Contract.Services.ICustomerServices;
import Contract.Services.IProductServices;
import DTOs.Customer.CustomerRegisterRequestDto;
import DTOs.Product.CartItemDto;
import Entities.Customer;
import Entities.Product;
import Helper.Preparation;
import Implementation.Repository.CustomerRepository;
import Implementation.Services.CartService;
import Implementation.Services.CustomerServices;
import Implementation.Services.ProductServices;
import Program.FirstMenu;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Preparation.prepare();
        // Preview before running
        ICustomerServices customerServices = new CustomerServices();
        IProductServices productServices = new ProductServices();
        ICartServices cartServices = new CartService();

        CustomerRegisterRequestDto dto = new CustomerRegisterRequestDto("Tarek", "Mohamed", "tarek@example.com", "123456", "0100000001");
        UUID customerId =customerServices.registerCustomer(dto);

        cartServices.createCart(customerId);


        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        Date futureDate = calendar.getTime();
        Product product1 = new Product("Laptop", "Laptop Description", 1000.0, 10, futureDate, 0.2, 2.5);
        Product product2 = new Product("Mobile", "Mobile Description", 500.0, 5, futureDate, 0.1, 0.5);

        productServices.addProduct(product1);
        productServices.addProduct(product2);

        cartServices.addToCart(customerId, product1.getId(), 2);
        cartServices.addToCart(customerId, product2.getId(), 1);

        List<CartItemDto> cartProducts = cartServices.getCartProducts(customerId);
        checkout(cartProducts, 3000.0);

        FirstMenu.Run();
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
            total += product.getPrice() * product.getQuantity();
            weight += product.getWeight() * product.getQuantity();
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