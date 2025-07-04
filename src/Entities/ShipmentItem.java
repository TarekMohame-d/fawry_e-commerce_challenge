package Entities;

import java.util.*;

public class ShipmentItem {
    private final UUID orderItemId;
    private final UUID shipmentId;

    public ShipmentItem(UUID orderItemId, UUID shipmentId) {
        this.orderItemId = orderItemId;
        this.shipmentId = shipmentId;
    }

    // Navigation Properties
    private Shipment shipment;
    private OrderItem orderItem;

    // Getters
    public UUID getOrderItemId() {
        return orderItemId;
    }

    public UUID getShipmentId() {
        return shipmentId;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    // Setters
    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }
}
