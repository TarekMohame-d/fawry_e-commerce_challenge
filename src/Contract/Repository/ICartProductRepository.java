package Contract.Repository;
import Entities.Address;
import Entities.CartProduct;

import java.util.*;

public interface ICartProductRepository {
    Optional<CartProduct> getByCartAndProductId(UUID cartId, UUID productId);
    List<CartProduct> getAll();
    void add(CartProduct cartProduct);
    void update(CartProduct cartProduct);
    void delete(UUID cartId, UUID productId);
    void deleteAll();
    Optional<CartProduct> getCartProductDetails(UUID cartId, UUID productId);
}
