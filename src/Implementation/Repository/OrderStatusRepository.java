package Implementation.Repository;

import Contract.Repository.IOrderStatusRepository;
import Entities.*;
import Helper.InMemoryDatabase;
import Helper.TableName;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrderStatusRepository implements IOrderStatusRepository {
    private final List<OrderStatus> table;

    public OrderStatusRepository() {
        this.table = InMemoryDatabase.getInstance().getTable(TableName.ORDER_STATUS);
    }

    @Override
    public Optional<OrderStatus> getById(int id) {
        for (OrderStatus orderStatus : table) {
            if (orderStatus.getId() == id) {
                return Optional.of(orderStatus);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<OrderStatus> getOrderStatusDetails(int id) {
        OrderStatus orderStatus = getById(id).orElse(null);
        if (orderStatus == null) return Optional.empty();

        orderStatus.setOrders(getOrderStatusOrders(id));

        return Optional.of(orderStatus);
    }

    @Override
    public List<OrderStatus> getAll() {
        return new ArrayList<>(table);
    }

    @Override
    public void add(OrderStatus orderStatus) {
        if (getById(orderStatus.getId()).isEmpty()) {
            table.add(orderStatus);
        }
    }

    @Override
    public void update(OrderStatus orderStatus) {
        for (int i = 0; i < table.size(); i++) {
            OrderStatus os = table.get(i);
            if (os.getId() == orderStatus.getId()) {
                table.set(i, orderStatus);
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        table.removeIf(os -> os.getId() == id);
    }

    @Override
    public void deleteAll() {
        table.clear();
    }

    private List<Order> getOrderStatusOrders(int statusId) {
        List<Order> orders = InMemoryDatabase.getInstance().getTable(TableName.ORDERS);
        List<Order> result = new ArrayList<>();
        for (Order order : orders) {
            if (order.getStatusId() == statusId) {
                result.add(order);
            }
        }
        return result;
    }
}
