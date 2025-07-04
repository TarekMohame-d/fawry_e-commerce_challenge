package Contract.Repository;

import Entities.Wishlist;

import java.util.Optional;
import java.util.UUID;

public interface IWishlistRepository extends IGenericRepository<Wishlist>  {
    Optional<Wishlist> getWishlistDetails(UUID id);
}
