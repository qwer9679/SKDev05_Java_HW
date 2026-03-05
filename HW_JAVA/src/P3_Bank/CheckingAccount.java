package P3_Bank;
import P3_Bank.InSufficientBalanceException;
import P3_Bank.WithDrawalLimitExceededException;

public class CheckingAccount extends Account{
	private double withdrawalLimit;
	
	public CheckingAccount(String accountNumber, String ownerName, 
						   double balance, double withdrawalLimit) {
		super(accountNumber, ownerName, balance);
		this.withdrawalLimit = withdrawalLimit;
	}
	
	public double getWithdrawalLimit() {
		return withdrawalLimit;
	}
	
	@Override
	public void withdraw(double amount) throws InSufficientBalanceException, WithDrawalLimitExceededException{
		if(amount > withdrawalLimit) {
			throw new InSufficientBalanceException("출금 한도를 초과했습니다. 한도: " + withdrawalLimit + "원");
		}
		super.withdraw(amount);
	}
	
	@Override
	public String toString() {
		return super.toString() + ", 출금 한도: " + withdrawalLimit + "원";
	}
}
