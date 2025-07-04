package Contract.Services;

import Entities.Product;

import java.util.List;
import java.util.UUID;

public interface IProductServices {
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(UUID productId);
    Product getProduct(UUID productId);
    List<Product> getAllProducts();
}
