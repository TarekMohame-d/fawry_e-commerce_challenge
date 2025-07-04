package Contract.Repository;

import Entities.Cart;

import java.util.Optional;
import java.util.UUID;

public interface ICartRepository extends IGenericRepository<Cart>  {
    Optional<Cart> getCartDetails(UUID id);
}
