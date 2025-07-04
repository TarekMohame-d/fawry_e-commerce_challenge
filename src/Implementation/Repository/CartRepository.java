package Implementation.Repository;

import Contract.Repository.ICartRepository;
import Entities.*;
import Helper.InMemoryDatabase;
import Helper.TableName;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CartRepository extends GenericRepository<Cart> implements ICartRepository {
    private final List<Cart> table;

    public CartRepository() {
        super(TableName.CARTS);
        this.table = InMemoryDatabase.getInstance().getTable(TableName.CARTS);
    }

    @Override
    public Optional<Cart> getCartDetails(UUID id) {
        Cart cart = getById(id).orElse(null);
        if (cart == null) return Optional.empty();

        cart.setCustomer(getCartCustomer(cart.getCustomerId()));
        cart.setCartProducts(getCartCartProduct(cart.getId()));

        return Optional.of(cart);
    }

    private Customer getCartCustomer(UUID customerId) {
        List<Customer> customers = InMemoryDatabase.getInstance().getTable(TableName.CUSTOMERS);
        for (Customer customer : customers) {
            if (customer.getId().equals(customerId)) return customer;
        }
        return null;
    }

    private List<CartProduct> getCartCartProduct(UUID cartId) {
        List<CartProduct> cartProducts = InMemoryDatabase.getInstance().getTable(TableName.CART_PRODUCTS);
        List<CartProduct> result = new ArrayList<>();
        for (CartProduct cartProduct : cartProducts) {
            if (cartProduct.getCartId().equals(cartId)) {
                result.add(cartProduct);
            }
        }
        return result;
    }
}
