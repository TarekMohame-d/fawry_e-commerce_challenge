package Implementation.Repository;

import Contract.Repository.IShipmentRepository;

import Entities.*;
import Helper.InMemoryDatabase;
import Helper.TableName;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ShipmentRepository extends GenericRepository<Shipment> implements IShipmentRepository {
    private final List<Shipment> table;

    public ShipmentRepository() {
        super(TableName.SHIPMENTS);
        this.table = InMemoryDatabase.getInstance().getTable(TableName.SHIPMENTS);
    }

    @Override
    public Optional<Shipment> getShipmentDetails(UUID id) {
        Shipment shipment = getById(id).orElse(null);
        if (shipment == null) return Optional.empty();

        shipment.setShipmentItems(getShipmentShipmentItem(id));
        shipment.setAddress(getShipmentAddress(shipment.getAddressId()));
        shipment.setCustomer(getShipmentCustomer(shipment.getCustomerId()));
        shipment.setShipmentStatus(getShipmentShipmentStatus(shipment.getStatusId()));

        return Optional.of(shipment);
    }

    private List<ShipmentItem> getShipmentShipmentItem(UUID shipmentId) {
        List<ShipmentItem> shipmentItems = InMemoryDatabase.getInstance().getTable(TableName.SHIPMENT_ITEMS);
        List<ShipmentItem> result = new ArrayList<>();
        for (ShipmentItem shipmentItem : shipmentItems) {
            if (shipmentItem.getShipmentId().equals(shipmentId)) {
                result.add(shipmentItem);
            }
        }
        return result;
    }

    private Address getShipmentAddress(UUID addressId) {
        List<Address> addresses = InMemoryDatabase.getInstance().getTable(TableName.CARTS);
        for (Address address : addresses) {
            if (address.getCustomerId().equals(addressId)) return address;
        }
        return null;
    }

    private Customer getShipmentCustomer(UUID customerId) {
        List<Customer> customers = InMemoryDatabase.getInstance().getTable(TableName.CUSTOMERS);
        for (Customer customer : customers) {
            if (customer.getId().equals(customerId)) return customer;
        }
        return null;
    }

    private ShipmentStatus getShipmentShipmentStatus(int statusId) {
        List<ShipmentStatus> shipmentStatuses = InMemoryDatabase.getInstance().getTable(TableName.SHIPMENT_STATUS);
        for (ShipmentStatus shipmentStatus : shipmentStatuses) {
            if (shipmentStatus.getId() == statusId) return shipmentStatus;
        }
        return null;
    }
}
