package P3_Bank;

import P3_Bank.*;

public class BankDemo {

    public static void main(String[] args) {

        Bank bank = new Bank();

        try {
            System.out.println("=== 계좌 생성 ===");
            String acc1 = bank.createSavingsAccount("홍길동", 10000, 0.03);
            String acc2 = bank.createCheckingAccount("김철수", 20000, 5000);
            String acc3 = bank.createSavingsAccount("이영희", 30000, 0.02);

            bank.printAllAccounts();

            System.out.println("\n=== 입금/출금 테스트 ===");
            bank.findAccount(acc1).deposit(5000);
            bank.findAccount(acc2).withdraw(3000);

            System.out.println("\n=== 이자 적용 테스트 ===");
            ((SavingAccount) bank.findAccount(acc1)).applyInterest();

            System.out.println("\n=== 계좌 이체 테스트 ===");
            bank.transfer(acc3, acc2, 5000);

            bank.printAllAccounts();

         // 예외 테스트
            bank.findAccount(acc2).withdraw(6000);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.findAccount("AC9999");
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}