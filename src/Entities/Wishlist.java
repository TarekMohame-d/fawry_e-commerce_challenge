package Entities;

import Entities.Common.IEntity;

import java.util.*;

public class Wishlist implements IEntity {
    private final UUID id;
    private final UUID customerId;

    public Wishlist(UUID customerId) {
        id = UUID.randomUUID();
        this.customerId = customerId;
    }

    @Override
    public UUID getId() {
        return id;
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

    // Setters
    public void setWishlistProducts(List<WishlistProduct> wishlistProducts) {
        this.wishlistProducts = wishlistProducts;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

