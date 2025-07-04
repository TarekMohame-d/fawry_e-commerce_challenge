package Entities.StaticData;

public enum OrderStatusType {
    Pending(1),
    Confirmed(2),
    Processing(3),
    Shipped(4),
    PartiallyShipped(5),
    Delivered(6),
    Cancelled(7),
    Refunded(8),
    Failed(9);

    private final int value;

    OrderStatusType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static OrderStatusType fromValue(int value) {
        for (OrderStatusType status : values()) {
            if (status.getValue() == value) return status;
        }
        throw new IllegalArgumentException("Invalid OrderStatusType value: " + value);
    }
}
