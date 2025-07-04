package Implementation.Repository;

import Contract.Repository.IShipmentItemRepository;
import Entities.*;
import Helper.InMemoryDatabase;
import Helper.TableName;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ShipmentItemRepository implements IShipmentItemRepository {
    private final List<ShipmentItem> table;

    public ShipmentItemRepository() {
        this.table = InMemoryDatabase.getInstance().getTable(TableName.SHIPMENT_ITEMS);
    }

    @Override
    public Optional<ShipmentItem> getByOrderItemAndShipmentId(UUID orderItemId, UUID shipmentId) {
        for (ShipmentItem shipmentItem : table) {
            if (shipmentItem.getOrderItemId().equals(orderItemId) &&
                    shipmentItem.getShipmentId().equals(shipmentId)) {
                return Optional.of(shipmentItem);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<ShipmentItem> getShipmentItemDetails(UUID orderItemId, UUID shipmentId) {
        ShipmentItem shipmentItem = getByOrderItemAndShipmentId(orderItemId, shipmentId).orElse(null);
        if (shipmentItem == null) return Optional.empty();

        shipmentItem.setShipment(getShipmentItemShipment(shipmentId));
        shipmentItem.setOrderItem(getShipmentItemOrderItem(orderItemId));

        return Optional.of(shipmentItem);
    }

    @Override
    public List<ShipmentItem> getAll() {
        return new ArrayList<>(table);
    }

    @Override
    public void add(ShipmentItem shipmentItem) {
        if (getByOrderItemAndShipmentId(shipmentItem.getOrderItemId(), shipmentItem.getShipmentId()).isEmpty()) {
            table.add(shipmentItem);
        }
    }

    @Override
    public void update(ShipmentItem shipmentItem) {
        for (int i = 0; i < table.size(); i++) {
            ShipmentItem si = table.get(i);
            if (si.getOrderItemId().equals(shipmentItem.getOrderItemId()) &&
                    si.getShipmentId().equals(shipmentItem.getShipmentId())) {
                table.set(i, shipmentItem);
                return;
            }
        }
    }

    @Override
    public void delete(UUID orderItemId, UUID shipmentId) {
        table.removeIf(si -> si.getOrderItemId().equals(orderItemId) && si.getShipmentId().equals(shipmentId));
    }

    @Override
    public void deleteAll() {
        table.clear();
    }

    private Shipment getShipmentItemShipment(UUID shipmentId) {
        List<Shipment> shipments = InMemoryDatabase.getInstance().getTable(TableName.SHIPMENTS);
        for (Shipment shipment : shipments) {
            if (shipment.getId().equals(shipmentId)) return shipment;
        }
        return null;
    }

    private OrderItem getShipmentItemOrderItem(UUID orderItemId) {
        List<OrderItem> orderItems = InMemoryDatabase.getInstance().getTable(TableName.ORDER_ITEMS);
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getId().equals(orderItemId)) return orderItem;
        }
        return null;
    }
}
