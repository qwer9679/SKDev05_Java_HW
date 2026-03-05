package hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@ContextConfiguration(locations = "classpath:hw1.xml")
public class orderSpringTest {

    @Autowired
    ShoppingCart shoppingCart;

    @Autowired
    OrderService orderService;

    @Test
    public void testShoppingCart() {

        System.out.println("=== ShoppingCart Bean 테스트 시작 ===");

        System.out.println("shoppingCart 객체 확인");
        assertNotNull(shoppingCart);
        System.out.println("shoppingCart 객체 정상 생성");

        System.out.println("상품 개수 확인");
        int size = shoppingCart.getProducts().size();
        System.out.println("상품 개수: " + size);
        assertEquals(2, size);

        String product1 = shoppingCart.getProducts().get(0).getName();
        System.out.println("첫 번째 상품 이름: " + product1);
        assertEquals("노트북", product1);

        String product2 = shoppingCart.getProducts().get(1).getName();
        System.out.println("두 번째 상품 이름: " + product2);
        assertEquals("스마트폰", product2);

        System.out.println("=== ShoppingCart Bean 테스트 완료 ===");
    }

    @Test
    public void testOrderService() {

        System.out.println("=== OrderService Bean 테스트 시작 ===");

        System.out.println("orderService 객체 확인");
        assertNotNull(orderService);
        System.out.println("orderService 객체 정상 생성");

        double total = orderService.calculateOrderTotal();
        System.out.println("총 주문 금액 계산 결과: " + total);

        assertEquals(950000, total);

        System.out.println("=== OrderService Bean 테스트 완료 ===");
    }
}