package Entities;

import java.util.ArrayList;
import java.util.List;

public class ShipmentStatus {
    private final int id;
    private String name;

    public ShipmentStatus(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Navigation Properties
    private List<Shipment> shipments = new ArrayList<Shipment>();

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Shipment> getShipments() {
        return shipments;
    }

    // Setters
    public void setShipments(List<Shipment> shipments) {
        this.shipments = shipments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addShipment(Shipment shipment) {
        if (shipment != null && !shipments.contains(shipment)) {
            shipments.add(shipment);
        }
    }

    public void removeShipment(Shipment shipment) {
        shipments.remove(shipment);
    }
}

