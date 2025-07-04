package Implementation.Repository;

import Contract.Repository.ICartProductRepository;
import Entities.Cart;
import Entities.CartProduct;
import Entities.Product;
import Helper.InMemoryDatabase;
import Helper.TableName;

import java.util.*;

public class CartProductRepository implements ICartProductRepository {
    private final List<CartProduct> table;

    public CartProductRepository() {
        this.table = InMemoryDatabase.getInstance().getTable(TableName.CART_PRODUCTS);
    }

    @Override
    public Optional<CartProduct> getByCartAndProductId(UUID cartId, UUID productId) {
        for (CartProduct cp : table) {
            if (cp.getCartId().equals(cartId) && cp.getProductId().equals(productId)) {
                return Optional.of(cp);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<CartProduct> getCartProductDetails(UUID cartId, UUID productId) {
        CartProduct cp = getByCartAndProductId(cartId, productId).orElse(null);
        if (cp == null) return Optional.empty();

        cp.setCart(getCartProductCart(cartId));
        cp.setProduct(getCartProductProduct(productId));

        return Optional.of(cp);
    }

    @Override
    public List<CartProduct> getAll() {
        return new ArrayList<>(table);
    }

    @Override
    public void add(CartProduct cartProduct) {
        if (getByCartAndProductId(cartProduct.getCartId(), cartProduct.getProductId()).isEmpty()) {
            table.add(cartProduct);
        }
    }

    @Override
    public void update(CartProduct cartProduct) {
        for (int i = 0; i < table.size(); i++) {
            CartProduct cp = table.get(i);
            if (cp.getCartId().equals(cartProduct.getCartId()) &&
                    cp.getProductId().equals(cartProduct.getProductId())) {
                table.set(i, cartProduct);
                return;
            }
        }
    }

    @Override
    public void delete(UUID cartId, UUID productId) {
        table.removeIf(cp -> cp.getCartId().equals(cartId) && cp.getProductId().equals(productId));
    }

    @Override
    public void deleteAll() {
        table.clear();
    }

    private Cart getCartProductCart(UUID cartId) {
        List<Cart> carts = InMemoryDatabase.getInstance().getTable(TableName.CARTS);
        for (Cart cart : carts) {
            if (cart.getId().equals(cartId)) return cart;
        }
        return null;
    }

    private Product getCartProductProduct(UUID productId) {
        List<Product> products = InMemoryDatabase.getInstance().getTable(TableName.PRODUCTS);
        for (Product product : products) {
            if (product.getId().equals(productId)) return product;
        }
        return null;
    }
}

