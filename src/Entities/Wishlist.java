package Entities;

import java.util.*;

public class Wishlist {
    private final UUID id;
    private final UUID customerId;

    public Wishlist(UUID customerId) {
        id = UUID.randomUUID();
        this.customerId = customerId;
    }

    // Navigation Properties
    public List<WishlistProduct> wishlistProducts = new ArrayList<>();
    public Customer customer;

    // Getters
    public UUID getCustomerId() {
        return customerId;
    }

    public List<WishlistProduct> getWishlistProducts() {
        return wishlistProducts;
    }

    public Customer getCustomer() {
        return customer;
    }

    public UUID getId() {
        return id;
    }

    // Setters
    public void setWishlistProducts(List<WishlistProduct> wishlistProducts) {
        this.wishlistProducts = wishlistProducts;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

