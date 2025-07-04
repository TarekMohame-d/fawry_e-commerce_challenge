package Entities;

import java.util.*;

public class OrderStatus {
    private final int id;
    private String name;

    public OrderStatus(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Navigation Properties
    private List<Order> orders = new ArrayList<Order>();

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    // Setters
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setName(String name) {
        this.name = name;
    }
}

