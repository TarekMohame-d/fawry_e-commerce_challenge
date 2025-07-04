package Entities;

import java.util.*;

public class WishlistProduct {
    private final UUID wishlistId;
    private final UUID productId;

    public WishlistProduct(UUID wishlistId, UUID productId) {
        this.wishlistId = wishlistId;
        this.productId = productId;
    }

    // Navigation Properties
    private Wishlist wishlist;
    private Product product;

    // Getters
    public UUID getProductId() {
        return productId;
    }

    public UUID getWishlistId() {
        return wishlistId;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public Product getProduct() {
        return product;
    }

    // Setters
    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

