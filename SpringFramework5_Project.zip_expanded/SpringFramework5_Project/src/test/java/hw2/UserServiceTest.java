package hw2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:hw2.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testUserService() {

        System.out.println("===== 테스트 시작 =====");

        // UserService 검증
        System.out.println("UserService 객체 확인");
        assertNotNull(userService);
        System.out.println("UserService 주입 성공");

        // UserRepository 검증
        System.out.println("UserRepository 객체 확인");
        assertNotNull(userService.getUserRepository());
        System.out.println("UserRepository 주입 성공");

        // dbType 검증
        System.out.println("DB 타입 확인: " + userService.getUserRepository().getDbType());
        assertEquals("MySQL", userService.getUserRepository().getDbType());
        System.out.println("DB 타입 검증 성공");

        // SecurityService 검증
        System.out.println("SecurityService 객체 확인");
        assertNotNull(userService.getSecurityService());
        System.out.println("SecurityService 주입 성공");

        // 기능 테스트
        System.out.println("사용자 등록 기능 테스트 실행");
        boolean result = userService.registerUser("hong", "홍길동", "1234");
        System.out.println("registerUser 결과: " + result);

        assertTrue(result);
        System.out.println("사용자 등록 기능 검증 성공");

        System.out.println("===== 테스트 종료 =====");
    }
}