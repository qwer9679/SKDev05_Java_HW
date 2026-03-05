package P3_Bank;

public class SavingAccount extends Account {

    private double interestRate; // 예: 0.03

    public SavingAccount(String accountNumber, String ownerName,
                          double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = balance * interestRate;
        deposit(interest);
        System.out.println("이자 " + interest + "원이 적용되었습니다. 현재 잔액: " + balance + "원");
    }

    @Override
    public String toString() {
        return super.toString() +
               ", 이자율: " + (interestRate * 100) + "%";
    }
}