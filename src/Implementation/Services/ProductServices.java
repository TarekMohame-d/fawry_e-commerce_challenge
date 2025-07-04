package Implementation.Services;

import Contract.Repository.IProductRepository;
import Contract.Services.IProductServices;
import Entities.Product;
import Implementation.Repository.ProductRepository;

import java.util.List;
import java.util.UUID;

public class ProductServices implements IProductServices {
    private IProductRepository productRepository;

    public ProductServices( ){
        this.productRepository = new ProductRepository();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.add(product);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.update(product);
    }

    @Override
    public void deleteProduct(UUID productId) {
        productRepository.delete(productId);
    }

    @Override
    public Product getProduct(UUID productId) {
       Product product = productRepository.getById(productId).get();

       return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.getAll();
        return products;
    }
}
