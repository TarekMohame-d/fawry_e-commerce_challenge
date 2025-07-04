package Implementation.Repository;

import Contract.Repository.ICustomerRepository;
import Contract.Repository.IWishlistRepository;
import Entities.*;
import Helper.InMemoryDatabase;
import Helper.TableName;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class WishlistRepository extends GenericRepository<Wishlist> implements IWishlistRepository {
    private final List<Wishlist> table;

    public WishlistRepository() {
        super(TableName.WISHLISTS);
        this.table = InMemoryDatabase.getInstance().getTable(TableName.WISHLISTS);
    }

    @Override
    public Optional<Wishlist> getWishlistDetails(UUID id) {
        Wishlist wishlist = getById(id).orElse(null);
        if (wishlist == null) return Optional.empty();

        wishlist.setCustomer(getWishlistCustomer(wishlist.getCustomerId()));
        wishlist.setWishlistProducts(getWishlistWishlistProduct(wishlist.getId()));

        return Optional.of(wishlist);
    }

    private Customer getWishlistCustomer(UUID customerId) {
        List<Customer> customers = InMemoryDatabase.getInstance().getTable(TableName.CUSTOMERS);
        for (Customer customer : customers) {
            if (customer.getId().equals(customerId)) return customer;
        }
        return null;
    }

    private List<WishlistProduct> getWishlistWishlistProduct(UUID wishlistId) {
        List<WishlistProduct> wishlistProducts = InMemoryDatabase.getInstance().getTable(TableName.WISHLIST_PRODUCTS);
        List<WishlistProduct> result = new ArrayList<>();
        for (WishlistProduct wishlistProduct : wishlistProducts) {
            if (wishlistProduct.getWishlistId().equals(wishlistId)) {
                result.add(wishlistProduct);
            }
        }
        return result;
    }
}
