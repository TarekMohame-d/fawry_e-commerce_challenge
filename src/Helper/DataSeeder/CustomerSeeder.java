package Helper.DataSeeder;

import Contract.Services.ICartServices;
import Entities.Customer;
import Helper.InMemoryDatabase;
import Helper.TableName;
import Implementation.Services.CartService;

import java.util.List;

public class CustomerSeeder {
    private static ICartServices cartService;
    public static void seed() {
        cartService = new CartService();
        List<Customer> customers = InMemoryDatabase.getInstance().getTable(TableName.CUSTOMERS);

        if (!customers.isEmpty()) return;

        Customer c = new Customer("Mostafa", "Mohamed", "tarek@example.com", "123456", "0100000000");
        cartService.createCart(c.getId());
        customers.add(c);
        c = new Customer("Ali", "Ibrahim", "ali@example.com", "123456", "0100000002");
        cartService.createCart(c.getId());
        customers.add(c);
        c = new Customer("Sara", "Mostafa", "sara@example.com", "123456", "0100000003");
        cartService.createCart(c.getId());
        customers.add(c);
        c = new Customer("Mona", "Nabil", "mona@example.com", "123456", "0100000004");
        cartService.createCart(c.getId());
        customers.add(c);
        c = new Customer("Youssef", "Hassan", "youssef@example.com", "123456", "0100000005");
        cartService.createCart(c.getId());
        customers.add(c);
    }
}
