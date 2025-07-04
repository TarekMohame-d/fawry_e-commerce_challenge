package Entities;

import java.util.*;

public class Review {
    private final UUID id;
    private final UUID customerId;
    private final UUID productId;
    private int rating;
    private String comment;
    private final Date createdAt;
    private Date updatedAt;

    public Review(UUID customerId,
                  UUID productId,
                  int rating,
                  String comment) {
        id = UUID.randomUUID();
        this.customerId = customerId;
        this.productId = productId;
        this.rating = rating;
        this.comment = comment;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    // Navigation properties
    private Customer customer;
    private Product product;

    // Getters
    public UUID getId() {
        return id;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public UUID getProductId() {
        return productId;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }

    // Setters
    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
