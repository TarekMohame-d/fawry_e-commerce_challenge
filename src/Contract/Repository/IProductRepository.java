package Contract.Repository;

import Entities.Product;

import java.util.Optional;
import java.util.UUID;

public interface IProductRepository extends IGenericRepository<Product> {
    Optional<Product> getProductDetails(UUID id);
}
