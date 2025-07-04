package Implementation.Repository;

import Contract.Repository.IProductRepository;
import Entities.*;
import Helper.InMemoryDatabase;
import Helper.TableName;

import java.util.*;

public class ProductRepository extends GenericRepository<Product> implements IProductRepository {
    private final List<Product> table;
    public ProductRepository() {
        super(TableName.PRODUCTS);
        table = InMemoryDatabase.getInstance().getTable(TableName.PRODUCTS);
    }

    @Override
    public Optional<Product> getProductDetails(UUID id) {
        for (Product product : table) {
            if (product.getId().equals(id)) {
                product.setReviews(getProductReviews(id));
                product.setOrderItems(getProductOrderItem(id));
                product.setCartProducts(getProductCartProduct(id));
                product.setWishlistProducts(getProductWishlistProduct(id));
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    private List<Review> getProductReviews(UUID id) {
        List<Review> reviews = InMemoryDatabase.getInstance().getTable(TableName.REVIEWS);
        List<Review> productReviews = new ArrayList<>();
        for (Review review : reviews) {
            if (review.getProductId().equals(id)) productReviews.add(review);
        }
        return productReviews;
    }

    private List<OrderItem> getProductOrderItem(UUID id) {
        List<OrderItem> orderItems = InMemoryDatabase.getInstance().getTable(TableName.ORDER_ITEMS);
        List<OrderItem> productOrderItems = new ArrayList<>();
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getProductId().equals(id)) productOrderItems.add(orderItem);
        }
        return productOrderItems;
    }

    private List<CartProduct> getProductCartProduct(UUID id) {
        List<CartProduct> cartProducts = InMemoryDatabase.getInstance().getTable(TableName.CART_PRODUCTS);
        List<CartProduct> productCartProducts = new ArrayList<>();
        for (CartProduct cartProduct : cartProducts) {
            if (cartProduct.getProductId().equals(id)) productCartProducts.add(cartProduct);
        }
        return productCartProducts;
    }

    private List<WishlistProduct> getProductWishlistProduct(UUID id) {
        List<WishlistProduct> wishlistProducts = InMemoryDatabase.getInstance().getTable(TableName.WISHLIST_PRODUCTS);
        List<WishlistProduct> productWishlistProducts = new ArrayList<>();
        for (WishlistProduct wishlistProduct : wishlistProducts) {
            if (wishlistProduct.getProductId().equals(id)) productWishlistProducts.add(wishlistProduct);
        }
        return productWishlistProducts;
    }
}
