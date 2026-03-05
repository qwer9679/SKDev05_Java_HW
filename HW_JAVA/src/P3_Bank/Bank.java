package P3_Bank;

import java.util.ArrayList;
import java.util.List;

import P3_Bank.AccountNotFoundException;
import P3_Bank.InSufficientBalanceException;

public class Bank {

    private List<Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        accounts = new ArrayList<>();
        nextAccountNumber = 1001;
    }

    public String createSavingsAccount(String owner, double balance, double rate) {
        String accNo = "AC" + String.valueOf(nextAccountNumber++);
        accounts.add(new SavingAccount(accNo, owner, balance, rate));
        
        System.out.println("저축 계좌가 생성되었습니다: 계좌번호 : " + 
        		accNo + ", 소유자 : " + owner + ", 잔액 : " + balance + "원, 이자율 : " + (rate*100) + "%");
        return accNo;
    }

    public String createCheckingAccount(String owner, double balance, double limit) {
        String accNo = "AC" + String.valueOf(nextAccountNumber++);
        accounts.add(new CheckingAccount(accNo, owner, balance, limit));
        
        System.out.println("체킹 계좌가 생성되었습니다: 계좌번호 : "+
        accNo + ", 소유자 : " + owner + ", 잔액 : " + balance + "원, 출금 한도 : " + limit + "원");
        return accNo;
    }

    public Account findAccount(String accountNumber)
            throws AccountNotFoundException {

        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        throw new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
    }

    public void deposit(String accountNumber, double amount)
            throws AccountNotFoundException {

        Account acc = findAccount(accountNumber);
        acc.deposit(amount);
    }

    public void withdraw(String accountNumber, double amount)
            throws AccountNotFoundException, InSufficientBalanceException {

        Account acc = findAccount(accountNumber);
        acc.withdraw(amount);
    }

    public void transfer(String from, String to, double amount)
            throws AccountNotFoundException, InSufficientBalanceException {

        Account fromAcc = findAccount(from);
        Account toAcc = findAccount(to);

        fromAcc.withdraw(amount);
        toAcc.deposit(amount);
        
        System.out.println(amount + "원이 " + from + "에서 " + to + "로 송금되었습니다.");
    }

    public void printAllAccounts() {
        System.out.println("=== 모든 계좌 목록 ===");
        for (Account acc : accounts) {
            System.out.println(acc);
        }
        System.out.println("===================");
    }
}