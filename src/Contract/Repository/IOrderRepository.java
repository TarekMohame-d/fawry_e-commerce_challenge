package Contract.Repository;

import Entities.Order;

import java.util.Optional;
import java.util.UUID;

public interface IOrderRepository extends IGenericRepository<Order>{
    Optional<Order> getOrderDetails(UUID id);
}
