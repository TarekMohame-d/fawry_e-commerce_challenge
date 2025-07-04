package Entities;

import java.util.*;

public class OrderItem {
    private final UUID id;
    private final UUID orderId;
    private final UUID productId;
    private int quantity;
    private double unitPrice;
    private final Date createdAt;
    private Date updatedAt;

    public OrderItem(UUID orderId,
                     UUID productId,
                     int quantity,
                     double unitPrice) {
        id = UUID.randomUUID();
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    // Navigation Properties
    private List<ShipmentItem> shipmentItems = new ArrayList<>();
    private Product product;
    private Order order;

    // Getters
    public UUID getId() {
        return id;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public UUID getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public List<ShipmentItem> getShipmentItems() {
        return shipmentItems;
    }

    public Product getProduct() {
        return product;
    }

    public Order getOrder() {
        return order;
    }

    // Setters
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setShipmentItems(List<ShipmentItem> shipmentItems) {
        this.shipmentItems = shipmentItems;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

