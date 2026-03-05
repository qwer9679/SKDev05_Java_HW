package P3_Bank;

public class InSufficientBalanceException extends Exception{
	public InSufficientBalanceException(String message) {
		super(message);
	}
}