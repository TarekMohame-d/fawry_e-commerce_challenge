package Implementation.Repository;

import Contract.Repository.IReviewRepository;
import Entities.Customer;
import Entities.Product;
import Entities.Review;
import Entities.Wishlist;
import Helper.InMemoryDatabase;
import Helper.TableName;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ReviewRepository extends GenericRepository<Review> implements IReviewRepository {
    private final List<Review> table;

    public ReviewRepository() {
        super(TableName.REVIEWS);
        this.table = InMemoryDatabase.getInstance().getTable(TableName.REVIEWS);
    }

    @Override
    public Optional<Review> getReviewDetails(UUID id) {
        Review review = getById(id).orElse(null);
        if (review == null) return Optional.empty();

        review.setCustomer(getReviewCustomer(review.getCustomerId()));
        review.setProduct(getReviewProduct(review.getProductId()));

        return Optional.of(review);
    }

    private Customer getReviewCustomer(UUID customerId) {
        List<Customer> customers = InMemoryDatabase.getInstance().getTable(TableName.CUSTOMERS);
        for (Customer customer : customers) {
            if (customer.getId().equals(customerId)) return customer;
        }
        return null;
    }

    private Product getReviewProduct(UUID productId) {
        List<Product> products = InMemoryDatabase.getInstance().getTable(TableName.WISHLISTS);
        for (Product product : products) {
            if (product.getId().equals(productId)) return product;
        }
        return null;
    }
}
