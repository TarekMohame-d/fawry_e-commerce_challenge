package Helper;

import Entities.*;

import java.util.*;

public class InMemoryDatabase {
    private static final InMemoryDatabase instance = new InMemoryDatabase();
    private final Map<TableName, List<?>> tables = new HashMap<>();

    private InMemoryDatabase() {
        tables.put(TableName.CUSTOMERS, new ArrayList<Customer>());
        tables.put(TableName.PRODUCTS, new ArrayList<Product>());
        tables.put(TableName.ORDERS, new ArrayList<Order>());
        tables.put(TableName.ORDER_ITEMS, new ArrayList<OrderItem>());
        tables.put(TableName.ORDER_STATUS, new ArrayList<OrderStatus>());
        tables.put(TableName.ADDRESSES, new ArrayList<Address>());
        tables.put(TableName.SHIPMENTS, new ArrayList<Shipment>());
        tables.put(TableName.SHIPMENT_ITEMS, new ArrayList<ShipmentItem>());
        tables.put(TableName.SHIPMENT_STATUS, new ArrayList<ShipmentStatus>());
        tables.put(TableName.REVIEWS, new ArrayList<Review>());
        tables.put(TableName.WISHLISTS, new ArrayList<Wishlist>());
        tables.put(TableName.WISHLIST_PRODUCTS, new ArrayList<WishlistProduct>());
        tables.put(TableName.CARTS, new ArrayList<Cart>());
        tables.put(TableName.CART_PRODUCTS, new ArrayList<CartProduct>());
    }

    public static InMemoryDatabase getInstance() {
        return instance;
    }

    public <T> void add(TableName table, T entity) {
        List<T> list = (List<T>) tables.get(table);
        list.add(entity);
    }

    public <T> List<T> getTable(TableName table) {
        return (List<T>) tables.get(table);
    }

    public void reset() {
        for (TableName table : TableName.values()) {
            tables.get(table).clear();
        }
    }
}
