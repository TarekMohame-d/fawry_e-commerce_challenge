package Implementation.Repository;

import Contract.Repository.IShipmentStatusRepository;
import Entities.Order;
import Entities.OrderStatus;
import Entities.Shipment;
import Entities.ShipmentStatus;
import Helper.InMemoryDatabase;
import Helper.TableName;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ShipmentStatusRepository implements IShipmentStatusRepository {
    private final List<ShipmentStatus> table;

    public ShipmentStatusRepository() {
        this.table = InMemoryDatabase.getInstance().getTable(TableName.SHIPMENT_STATUS);
    }

    @Override
    public Optional<ShipmentStatus> getById(int id) {
        for (ShipmentStatus shipmentStatus : table) {
            if (shipmentStatus.getId() == id) {
                return Optional.of(shipmentStatus);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<ShipmentStatus> getShipmentStatusDetails(int id) {
        ShipmentStatus shipmentStatus = getById(id).orElse(null);
        if (shipmentStatus == null) return Optional.empty();

        shipmentStatus.setShipments(getShipmentStatusShipment(id));

        return Optional.of(shipmentStatus);
    }

    @Override
    public List<ShipmentStatus> getAll() {
        return new ArrayList<>(table);
    }

    @Override
    public void add(ShipmentStatus shipmentStatus) {
        if (getById(shipmentStatus.getId()).isEmpty()) {
            table.add(shipmentStatus);
        }
    }

    @Override
    public void update(ShipmentStatus shipmentStatus) {
        for (int i = 0; i < table.size(); i++) {
            ShipmentStatus ss = table.get(i);
            if (ss.getId() == shipmentStatus.getId()) {
                table.set(i, shipmentStatus);
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        table.removeIf(ss -> ss.getId() == id);
    }

    @Override
    public void deleteAll() {
        table.clear();
    }

    private List<Shipment> getShipmentStatusShipment(int statusId) {
        List<Shipment> shipments = InMemoryDatabase.getInstance().getTable(TableName.SHIPMENTS);
        List<Shipment> result = new ArrayList<>();
        for (Shipment shipment : shipments) {
            if (shipment.getStatusId() == statusId) {
                result.add(shipment);
            }
        }
        return result;
    }
}
