package Entities;

import Entities.Common.IEntity;

import java.util.*;

public class Address implements IEntity {
    private final UUID id;
    private final UUID customerId;
    private String city;
    private String street;
    private String description;
    private boolean isDeleted;
    private final Date createdAt;
    private Date updatedAt;

    public Address(UUID customerId,
                   String city,
                   String street,
                   String description) {
        id = UUID.randomUUID();
        this.customerId = customerId;
        this.city = city;
        this.street = street;
        this.description = description;
        this.isDeleted = false;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @Override
    public UUID getId() {
        return id;
    }

    // Navigation Properties
    private Customer customer;
    private List<Shipment> shipments = new ArrayList<Shipment>();

    // Getters
    public UUID getCustomerId() {
        return customerId;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getDescription() {
        return description;
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

    public Customer getCustomer() {
        return customer;
    }

    public List<Shipment> getShipments() {
        return shipments;
    }

    // Setters
    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setShipments(List<Shipment> shipments) {
        this.shipments = shipments;
    }
}

