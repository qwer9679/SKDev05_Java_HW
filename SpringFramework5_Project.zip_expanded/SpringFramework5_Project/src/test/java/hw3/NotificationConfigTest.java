package hw3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(NotificationConfig.class)
public class NotificationConfigTest {

    @Autowired
    private NotificationManager notificationManager;

    @Test
    void testNotificationManager() {

        System.out.println("=== NotificationManager DI 테스트 시작 ===");

        // NotificationManager Not Null 검증
        System.out.println("NotificationManager 객체 확인");
        assertNotNull(notificationManager);
        System.out.println("NotificationManager 주입 성공");

        // 이메일 서비스 검증
        System.out.println("\n=== 이메일 서비스 검증 ===");

        NotificationService emailService = notificationManager.getEmailService();
        assertNotNull(emailService);
        System.out.println("EmailService 객체 존재 확인");

        EmailNotificationService email =
                (EmailNotificationService) emailService;

        System.out.println("SMTP Server: " + email.getSmtpServer());
        System.out.println("Port: " + email.getPort());

        assertEquals("smtp.gmail.com", email.getSmtpServer());
        assertEquals(587, email.getPort());

        // SMS 서비스 검증
        System.out.println("\n=== SMS 서비스 검증 ===");

        NotificationService smsService = notificationManager.getSmsService();
        assertNotNull(smsService);
        System.out.println("SmsService 객체 존재 확인");

        SmsNotificationService sms =
                (SmsNotificationService) smsService;

        System.out.println("Provider: " + sms.getProvider());

        assertEquals("SKT", sms.getProvider());

        // 메서드 실행 테스트
        System.out.println("\n=== 알림 전송 테스트 ===");

        notificationManager.sendNotificationByEmail("테스트 이메일");
        notificationManager.sendNotificationBySms("테스트 SMS");

        System.out.println("=== 테스트 종료 ===");
    }
}