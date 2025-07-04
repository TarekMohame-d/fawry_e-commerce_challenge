package Entities;

import Entities.Common.ICanBeShipped;
import Entities.Common.IEntity;

import java.util.*;

public class Product implements IEntity, ICanBeShipped {
    private final UUID id;
    private String name;
    private String description;
    private double price;
    private int stockQuantity;
    private double discount;
    private Date expiredAt;
    private boolean canBeShipped;
    private double weight;
    private final Date createdAt;
    private Date updatedAt;

    public Product(String name,
                   String description,
                   double price,
                   int stockQuantity,
                   Date expiredAt,
                   double discount,
                   double weight) {
        id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.price = price;
        this.canBeShipped = true;
        this.stockQuantity = stockQuantity;
        this.expiredAt = expiredAt;
        this.discount = discount;
        this.weight = weight;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @Override
    public UUID getId() {
        return id;
    }

    // Navigation Properties
    public List<CartProduct> cartProducts = new ArrayList<CartProduct>();
    public List<Review> reviews = new ArrayList<Review>();
    public List<OrderItem> orderItems = new ArrayList<OrderItem>();
    public List<WishlistProduct> wishlistProducts = new ArrayList<WishlistProduct>();

    // Getters
    @Override
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public Date getExpiredAt() {
        return expiredAt;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public List<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public List<WishlistProduct> getWishlistProducts() {
        return wishlistProducts;
    }

    public boolean canBeShipped() {
        return canBeShipped;
    }

    // Setters
    public void setCanBeShipped(boolean canBeShipped) {
        this.canBeShipped = canBeShipped;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public void setExpiredAt(Date expiredAt) {
        this.expiredAt = expiredAt;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCartProducts(List<CartProduct> cartProducts) {
        cartProducts = cartProducts;
    }

    public void setReviews(List<Review> reviews) {
        reviews = reviews;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        orderItems = orderItems;
    }

    public void setWishlistProducts(List<WishlistProduct> wishlistProducts) {
        wishlistProducts = wishlistProducts;
    }
}
