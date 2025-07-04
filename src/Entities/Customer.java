package Entities;

import Entities.Common.IEntity;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Customer implements IEntity {
    private final UUID id;
    private String firstName;
    private String lastName;
    private double balance;
    private String email;
    private String password;
    private String phone;
    private boolean isActive;
    private boolean isDeleted;
    private final Date createdAt;
    private Date updatedAt;

    public Customer(String firstName,
                    String lastName,
                    String email,
                    String password,
                    String phone) {
        id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.balance = ThreadLocalRandom.current().nextDouble(1000.0, 5000.01);
        this.isActive = true;
        this.isDeleted = false;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @Override
    public UUID getId() {
        return id;
    }

    // Navigation Properties
    private List<Address> addresses = new ArrayList<Address>();
    private List<Review> reviews = new ArrayList<Review>();
    private List<Order> orders = new ArrayList<Order>();
    private Cart cart;
    private Wishlist wishlist;

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getBalance() {
        return balance;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Cart getCart() {
        return cart;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }
}

