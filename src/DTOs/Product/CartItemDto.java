package DTOs.Product;

import java.util.Date;
import java.util.UUID;

public class CartItemDto {
    public UUID ProductId;
    public String ProductName;
    public double Price;
    public double weight;
    public int Quantity;
    private Date expiredAt;
    private boolean canBeShipped;

    public CartItemDto(UUID ProductId,
                       String ProductName,
                       double Price,
                       int Quantity,
                       Date expiredAt,
                       boolean canBeShipped,
                       double weight) {
        this.ProductId = ProductId;
        this.ProductName = ProductName;
        this.Price = Price;
        this.Quantity = Quantity;
        this.expiredAt = expiredAt;
        this.canBeShipped = canBeShipped;
        this.weight = weight;
    }

    public Date getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(Date expiredAt) {
        this.expiredAt = expiredAt;
    }

    public boolean isCanBeShipped() {
        return canBeShipped;
    }

    public void setCanBeShipped(boolean canBeShipped) {
        this.canBeShipped = canBeShipped;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public UUID getProductId() {
        return ProductId;
    }

    public void setProductId(UUID productId) {
        ProductId = productId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }
}
