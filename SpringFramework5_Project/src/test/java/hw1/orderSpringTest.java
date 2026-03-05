package hw1;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class orderSpringTest {

    @Autowired
    ShoppingCart shoppingCart;

    @Autowired
    OrderService orderService;

    @Test
    public void testShoppingCart() {

        assertNotNull(shoppingCart);

        assertEquals(2, shoppingCart.getProducts().size());

        assertEquals("노트북",
                shoppingCart.getProducts().get(0).getName());

        assertEquals("스마트폰",
                shoppingCart.getProducts().get(1).getName());
    }

    @Test
    public void testOrderService() {

        assertNotNull(orderService);

        double total = orderService.calculateOrderTotal();

        assertEquals(950000, total);
    }
}