package Contract.Repository;

import Entities.Shipment;

import java.util.Optional;
import java.util.UUID;

public interface IShipmentRepository extends IGenericRepository<Shipment>{
    Optional<Shipment> getShipmentDetails(UUID id);
}
