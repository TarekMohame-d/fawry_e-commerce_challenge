package Implementation.Repository;

import Contract.Repository.ICustomerRepository;
import Contract.Repository.IOrderItemRepository;
import Entities.*;
import Helper.InMemoryDatabase;
import Helper.TableName;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrderItemRepository extends GenericRepository<OrderItem> implements IOrderItemRepository {
    private final List<OrderItem> table;

    public OrderItemRepository() {
        super(TableName.ORDER_ITEMS);
        this.table = InMemoryDatabase.getInstance().getTable(TableName.ORDER_ITEMS);
    }

    @Override
    public Optional<OrderItem> getOrderItemDetails(UUID id) {
        OrderItem orderItem = getById(id).orElse(null);
        if (orderItem == null) return Optional.empty();

        orderItem.setProduct(getOrderItemProduct(orderItem.getProductId()));
        orderItem.setOrder(getOrderItemOrder(orderItem.getOrderId()));
        orderItem.setShipmentItems(getCustomerOrders(orderItem.getId()));

        return Optional.of(orderItem);
    }

    private List<ShipmentItem> getCustomerOrders(UUID orderItemId) {
        List<ShipmentItem> shipmentItems = InMemoryDatabase.getInstance().getTable(TableName.ORDERS);
        List<ShipmentItem> result = new ArrayList<>();
        for (ShipmentItem shipmentItem : shipmentItems) {
            if (shipmentItem.getOrderItemId().equals(orderItemId)) {
                result.add(shipmentItem);
            }
        }
        return result;
    }

    private Product getOrderItemProduct(UUID productId) {
        List<Product> products = InMemoryDatabase.getInstance().getTable(TableName.PRODUCTS);
        for (Product product : products) {
            if (product.getId().equals(productId)) return product;
        }
        return null;
    }

    private Order getOrderItemOrder(UUID orderId) {
        List<Order> orders = InMemoryDatabase.getInstance().getTable(TableName.ORDERS);
        for (Order order : orders) {
            if (order.getId().equals(orderId)) return order;
        }
        return null;
    }
}
