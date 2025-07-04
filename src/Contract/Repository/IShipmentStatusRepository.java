package Contract.Repository;

import Entities.ShipmentStatus;

import java.util.List;
import java.util.Optional;

public interface IShipmentStatusRepository {
    Optional<ShipmentStatus> getById(int id);
    List<ShipmentStatus> getAll();
    void add(ShipmentStatus shipmentStatus);
    void update(ShipmentStatus shipmentStatus);
    void delete(int id);
    void deleteAll();
    Optional<ShipmentStatus> getShipmentStatusDetails(int id);
}
