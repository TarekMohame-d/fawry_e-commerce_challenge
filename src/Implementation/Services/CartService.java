package Implementation.Services;

import Contract.Repository.ICartProductRepository;
import Contract.Repository.ICartRepository;
import Contract.Repository.IProductRepository;
import Contract.Services.ICartServices;
import DTOs.Product.CartItemDto;
import Entities.Cart;
import Entities.CartProduct;
import Entities.Product;
import Implementation.Repository.CartProductRepository;
import Implementation.Repository.CartRepository;
import Implementation.Repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CartService implements ICartServices {
    private ICartRepository cartRepository;
    private ICartProductRepository cartProductRepository;
    private IProductRepository productRepository;

    public CartService() {
        this.cartRepository = new CartRepository();
        this.cartProductRepository = new CartProductRepository();
        this.productRepository = new ProductRepository();
    }

    @Override
    public void createCart(UUID customerId) {
        Cart cart = new Cart(customerId);
        cartRepository.add(cart);
    }

    @Override
    public void addToCart(UUID customerId, UUID productId, int quantity) {
        CartProduct cartProduct = new CartProduct(customerId, productId, quantity);
        cartProductRepository.add(cartProduct);
    }

    @Override
    public void updateProductQuantity(UUID customerId, UUID productId, int quantity) {
        UUID cartId = cartRepository.where(x -> x.getCustomerId().equals(customerId)).get().getId();
        cartProductRepository.update(new CartProduct(cartId, productId, quantity));
    }

    @Override
    public void removeFromCart(UUID customerId, UUID productId) {
        cartProductRepository.delete(customerId, productId);
    }

    @Override
    public List<CartItemDto> getCartProducts(UUID customerId) {
        List<CartProduct > cartProducts = cartProductRepository.getAll();
        List<CartItemDto> result = new ArrayList<CartItemDto>();
        for (CartProduct cartProduct : cartProducts) {
            Product product = productRepository.getById(cartProduct.getProductId()).get();
            CartItemDto dto = new CartItemDto(product.getId(), product.getName(), product.getPrice(), cartProduct.getQuantity(), product.getExpiredAt(), product.canBeShipped(), product.getWeight());
            result.add(dto);
        }
        return result;
    }
}
