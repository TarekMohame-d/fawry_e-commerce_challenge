package Implementation.Repository;

import Contract.Repository.IOrderRepository;
import Entities.*;
import Helper.InMemoryDatabase;
import Helper.TableName;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrderRepository extends GenericRepository<Order> implements IOrderRepository {
    private final List<Order> table;

    public OrderRepository() {
        super(TableName.ORDERS);
        this.table = InMemoryDatabase.getInstance().getTable(TableName.ORDERS);
    }

    @Override
    public Optional<Order> getOrderDetails(UUID id) {
        Order order = getById(id).orElse(null);
        if (order == null) return Optional.empty();

        order.setCustomer(getOrderCustomer(order.getCustomerId()));
        order.setOrderStatus(getOrderOrderStatus(order.getStatusId()));
        order.setOrderItems(getOrderOrderItems(order.getId()));

        return Optional.of(order);
    }

    private Customer getOrderCustomer(UUID customerId) {
        List<Customer> customers = InMemoryDatabase.getInstance().getTable(TableName.CUSTOMERS);
        for (Customer customer : customers) {
            if (customer.getId().equals(customerId)) return customer;
        }
        return null;
    }

    private OrderStatus getOrderOrderStatus(int statusId) {
        List<OrderStatus> orderStatuses = InMemoryDatabase.getInstance().getTable(TableName.ORDER_STATUS);
        for (OrderStatus orderStatus : orderStatuses) {
            if (orderStatus.getId() == statusId) return orderStatus;
        }
        return null;
    }

    private List<OrderItem> getOrderOrderItems(UUID orderId) {
        List<OrderItem> orderItems = InMemoryDatabase.getInstance().getTable(TableName.ORDER_ITEMS);
        List<OrderItem> result = new ArrayList<>();
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getOrderId().equals(orderId)) {
                result.add(orderItem);
            }
        }
        return result;
    }
}
