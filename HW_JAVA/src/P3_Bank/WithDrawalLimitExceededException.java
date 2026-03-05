package P3_Bank;

public class WithDrawalLimitExceededException extends InSufficientBalanceException{
	public WithDrawalLimitExceededException(String message) {
		super(message);
	}
}
