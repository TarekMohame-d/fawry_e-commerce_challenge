package Entities;

import Entities.Common.IEntity;
import Entities.StaticData.OrderStatusType;

import java.util.*;

public class Order implements IEntity {
    private final UUID id;
    private final UUID customerId;
    private int statusId;
    private double totalPrice;
    private final Date createdAt;
    private Date updatedAt;

    public Order(UUID customerId,
                 int statusId,
                 double totalPrice) {
        id = UUID.randomUUID();
        this.customerId = customerId;
        this.statusId = statusId;
        this.totalPrice = totalPrice;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @Override
    public UUID getId() {
        return id;
    }

    public OrderStatusType getOrderStatusType() {
        return OrderStatusType.fromValue(statusId);
    }

    public void setOrderStatusType(OrderStatusType orderStatusType) {
        this.statusId = orderStatusType.getValue();
    }

    // Navigation Properties
    private Customer customer;
    private OrderStatus orderStatus;
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

    // Getters
    public UUID getCustomerId() {
        return customerId;
    }

    public int getStatusId() {
        return statusId;
    }

    public double getTotalPrice() {
        return totalPrice;
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

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    // Setters
    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}

