package Entities.StaticData;

public enum ShipmentStatusType {
    Pending(1),
    Processing(2),
    Shipped(3),
    OutForDelivery(4),
    Delivered(5),
    Returned(6),
    Cancelled(7),
    Failed(8);

    private final int value;

    ShipmentStatusType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ShipmentStatusType fromValue(int value) {
        for (ShipmentStatusType status : values()) {
            if (status.getValue() == value) return status;
        }
        throw new IllegalArgumentException("Invalid ShipmentStatusType value: " + value);
    }
}
