package Entities;

import Entities.Common.IEntity;
import Entities.StaticData.ShipmentStatusType;

import java.util.*;

public class Shipment implements IEntity {
    private final UUID id;
    private UUID addressId;
    private final UUID customerId;
    private int statusId;
    private String carrierName;
    private String trackingNumber;
    private Date estimatedDeliveryDate;
    private Date shippedAt;
    private Date deliveredAt;
    private final Date createdAt;
    private Date updatedAt;

    public Shipment(UUID addressId,
                    UUID customerId,
                    int statusId,
                    String carrierName,
                    String trackingNumber,
                    Date createdAt,
                    Date updatedAt) {
        this.id = UUID.randomUUID();
        this.addressId = addressId;
        this.customerId = customerId;
        this.statusId = statusId;
        this.carrierName = carrierName;
        this.trackingNumber = trackingNumber;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @Override
    public UUID getId() {
        return id;
    }

    public ShipmentStatusType getShipmentStatusType() {
        return ShipmentStatusType.fromValue(statusId);
    }

    public void setShipmentStatusType(ShipmentStatusType shipmentStatusType) {
        this.statusId = shipmentStatusType.getValue();
    }

    // Navigation properties
    private Address address;
    private Customer customer;
    private ShipmentStatus shipmentStatus;
    private List<ShipmentItem> shipmentItems = new ArrayList<>();

    // Getters
    public UUID getAddressId() {
        return addressId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public int getStatusId() {
        return statusId;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public Date getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public Date getShippedAt() {
        return shippedAt;
    }

    public Date getDeliveredAt() {
        return deliveredAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Address getAddress() {
        return address;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ShipmentStatus getShipmentStatus() {
        return shipmentStatus;
    }

    public List<ShipmentItem> getShipmentItems() {
        return shipmentItems;
    }

    // Setters
    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public void setEstimatedDeliveryDate(Date estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public void setShippedAt(Date shippedAt) {
        this.shippedAt = shippedAt;
    }

    public void setDeliveredAt(Date deliveredAt) {
        this.deliveredAt = deliveredAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setShipmentStatus(ShipmentStatus shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    public void setShipmentItems(List<ShipmentItem> shipmentItems) {
        this.shipmentItems = shipmentItems;
    }

    public void setAddressId(UUID addressId) {
        this.addressId = addressId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

