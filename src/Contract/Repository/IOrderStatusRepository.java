package Contract.Repository;

import Entities.OrderStatus;

import java.util.List;
import java.util.Optional;

public interface IOrderStatusRepository {
    Optional<OrderStatus> getById(int id);
    List<OrderStatus> getAll();
    void add(OrderStatus orderStatus);
    void update(OrderStatus orderStatus);
    void delete(int id);
    void deleteAll();
    Optional<OrderStatus> getOrderStatusDetails(int id);
}
