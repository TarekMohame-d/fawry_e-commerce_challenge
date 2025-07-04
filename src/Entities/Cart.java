package Entities;

import Entities.Common.IEntity;

import java.util.*;

public class Cart implements IEntity {
    private final UUID id;
    private final UUID customerId;

    public Cart(UUID customerId) {
        id = UUID.randomUUID();
        this.customerId = customerId;
    }

    @Override
    public UUID getId() {
        return id;
    }

    // Navigation properties
    private Customer customer;
    private List<CartProduct> cartProducts = new ArrayList<CartProduct>();

    // Getters
    public UUID getCustomerId() {
        return customerId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<CartProduct> getCartProducts() {
        return cartProducts;
    }

    // Setters
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCartProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }
}
