package Contract.Repository;

import Entities.OrderItem;

import java.util.Optional;
import java.util.UUID;

public interface IOrderItemRepository extends IGenericRepository<OrderItem>{
    Optional<OrderItem> getOrderItemDetails(UUID id);
}
