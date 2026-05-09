package organicfoodbackend.firstproject;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping("/{productId}")
    public OrderDetails placeOrder(@PathVariable Long productId) {

        OrderDetails order = new OrderDetails();
        order.setProductId(productId);
        order.setStatus("ORDER_PLACED");

        return orderRepository.save(order);
    }
}
