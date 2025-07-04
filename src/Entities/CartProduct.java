package Entities;

import java.util.*;

public class CartProduct {
    private final UUID cartId;
    private final  UUID productId;
    private int quantity;
    private final Date createdAt;
    private Date updatedAt;

    public CartProduct(UUID cartId, UUID productId, int quantity) {
        this.quantity = quantity;
        this.cartId = cartId;
        this.productId = productId;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    // Navigation Properties
    private Cart cart;
    private Product product;

    // Getters
    public UUID getCartId() {
        return cartId;
    }

    public UUID getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Cart getCart() {
        return cart;
    }

    public Product getProduct() {
        return product;
    }

    // Setters
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
