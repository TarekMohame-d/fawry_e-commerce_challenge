package Contract.Repository;

import Entities.CartProduct;
import Entities.ShipmentItem;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IShipmentItemRepository {
    Optional<ShipmentItem> getByOrderItemAndShipmentId(UUID orderItemId, UUID shipmentId);
    List<ShipmentItem> getAll();
    void add(ShipmentItem shipmentItem);
    void update(ShipmentItem shipmentItem);
    void delete(UUID orderItemId, UUID shipmentId);
    void deleteAll();
    Optional<ShipmentItem> getShipmentItemDetails(UUID orderItemId, UUID shipmentId);
}
