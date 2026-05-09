package organicfoodbackend.firstproject;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {

    private final CartRepository cartRepository;

    public CartController(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @PostMapping("/{productId}")
    public Cart addToCart(@PathVariable Long productId) {
        Cart cart = new Cart();
        cart.setProductId(productId);
        cart.setQuantity(1);
        return cartRepository.save(cart);
    }
}
