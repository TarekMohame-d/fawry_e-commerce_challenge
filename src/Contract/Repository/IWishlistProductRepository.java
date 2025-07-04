package Contract.Repository;

import Entities.CartProduct;
import Entities.WishlistProduct;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IWishlistProductRepository {
    Optional<WishlistProduct> getByWishlistAndProductId(UUID wishlistId, UUID productId);
    List<WishlistProduct> getAll();
    void add(WishlistProduct wishlistProduct);
    void update(WishlistProduct wishlistProduct);
    void delete(UUID wishlistId, UUID productId);
    void deleteAll();
    Optional<WishlistProduct> getWishlistProductDetails(UUID wishlistId, UUID productId);
}
