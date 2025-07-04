package Contract.Services;

import DTOs.Product.CartItemDto;
import Entities.Product;

import java.util.List;
import java.util.UUID;

public interface ICartServices {
    void createCart(UUID customerId);
    void addToCart(UUID customerId, UUID productId, int quantity);
    void updateProductQuantity(UUID customerId, UUID productId, int quantity);
    void removeFromCart(UUID customerId, UUID productId);
    List<CartItemDto> getCartProducts(UUID customerId);
}
