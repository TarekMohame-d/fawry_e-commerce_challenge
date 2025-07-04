package Implementation.Repository;

import Contract.Repository.ICustomerRepository;
import Entities.*;
import Helper.InMemoryDatabase;
import Helper.TableName;

import java.util.*;

public class CustomerRepository extends GenericRepository<Customer> implements ICustomerRepository {
    private final List<Customer> table;

    public CustomerRepository() {
        super(TableName.CUSTOMERS);
        this.table = InMemoryDatabase.getInstance().getTable(TableName.CUSTOMERS);
    }

    @Override
    public Optional<Customer> getCustomerDetails(UUID id) {
        Customer customer = getById(id).orElse(null);
        if (customer == null) return Optional.empty();

        customer.setAddresses(getCustomerAddresses(id));
        customer.setReviews(getCustomerReviews(id));
        customer.setOrders(getCustomerOrders(id));
        customer.setCart(getCustomerCart(id));
        customer.setWishlist(getCustomerWishlist(id));

        return Optional.of(customer);
    }

    private List<Address> getCustomerAddresses(UUID customerId) {
        List<Address> all = InMemoryDatabase.getInstance().getTable(TableName.ADDRESSES);
        List<Address> result = new ArrayList<>();
        for (Address address : all) {
            if (address.getCustomerId().equals(customerId)) {
                result.add(address);
            }
        }
        return result;
    }

    private List<Review> getCustomerReviews(UUID customerId) {
        List<Review> all = InMemoryDatabase.getInstance().getTable(TableName.REVIEWS);
        List<Review> result = new ArrayList<>();
        for (Review review : all) {
            if (review.getCustomerId().equals(customerId)) {
                result.add(review);
            }
        }
        return result;
    }

    private List<Order> getCustomerOrders(UUID customerId) {
        List<Order> all = InMemoryDatabase.getInstance().getTable(TableName.ORDERS);
        List<Order> result = new ArrayList<>();
        for (Order order : all) {
            if (order.getCustomerId().equals(customerId)) {
                result.add(order);
            }
        }
        return result;
    }

    private Cart getCustomerCart(UUID customerId) {
        List<Cart> carts = InMemoryDatabase.getInstance().getTable(TableName.CARTS);
        for (Cart cart : carts) {
            if (cart.getCustomerId().equals(customerId)) return cart;
        }
        return null;
    }

    private Wishlist getCustomerWishlist(UUID customerId) {
        List<Wishlist> wishlists = InMemoryDatabase.getInstance().getTable(TableName.WISHLISTS);
        for (Wishlist wishlist : wishlists) {
            if (wishlist.getCustomerId().equals(customerId)) return wishlist;
        }
        return null;
    }
}
