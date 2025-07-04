package Implementation.Repository;

import Contract.Repository.IWishlistProductRepository;
import Entities.*;
import Helper.InMemoryDatabase;
import Helper.TableName;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class WishlistProductRepository implements IWishlistProductRepository {
    private final List<WishlistProduct> table;

    public WishlistProductRepository() {
        this.table = InMemoryDatabase.getInstance().getTable(TableName.WISHLIST_PRODUCTS);
    }

    @Override
    public Optional<WishlistProduct> getByWishlistAndProductId(UUID wishlistId, UUID productId) {
        for (WishlistProduct wp : table) {
            if (wp.getWishlistId().equals(wishlistId) && wp.getProductId().equals(productId)) {
                return Optional.of(wp);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<WishlistProduct> getWishlistProductDetails(UUID wishlistId, UUID productId) {
        WishlistProduct wp = getByWishlistAndProductId(wishlistId, productId).orElse(null);
        if (wp == null) return Optional.empty();

        wp.setWishlist(getWishlistProductWishlist(wishlistId));
        wp.setProduct(getWishlistProductProduct(productId));

        return Optional.of(wp);
    }

    @Override
    public List<WishlistProduct> getAll() {
        return new ArrayList<>(table);
    }

    @Override
    public void add(WishlistProduct wishlistProduct) {
        if (getByWishlistAndProductId(wishlistProduct.getWishlistId(), wishlistProduct.getProductId()).isEmpty()) {
            table.add(wishlistProduct);
        }
    }

    @Override
    public void update(WishlistProduct wishlistProduct) {
        for (int i = 0; i < table.size(); i++) {
            WishlistProduct wp = table.get(i);
            if (wp.getWishlist().equals(wishlistProduct.getWishlistId()) &&
                    wp.getProductId().equals(wishlistProduct.getProductId())) {
                table.set(i, wishlistProduct);
                return;
            }
        }
    }

    @Override
    public void delete(UUID wishlistId, UUID productId) {
        table.removeIf(wp -> wp.getWishlist().equals(wishlistId) && wp.getProductId().equals(productId));
    }

    @Override
    public void deleteAll() {
        table.clear();
    }

    private Wishlist getWishlistProductWishlist(UUID wishlistId) {
        List<Wishlist> wishlists = InMemoryDatabase.getInstance().getTable(TableName.WISHLISTS);
        for (Wishlist wishlist : wishlists) {
            if (wishlist.getId().equals(wishlistId)) return wishlist;
        }
        return null;
    }

    private Product getWishlistProductProduct(UUID productId) {
        List<Product> products = InMemoryDatabase.getInstance().getTable(TableName.PRODUCTS);
        for (Product product : products) {
            if (product.getId().equals(productId)) return product;
        }
        return null;
    }
}
