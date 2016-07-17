package sol_5pecia1.money_comma.exception;

public class NotMoneyException extends Exception{
	public NotMoneyException() {
		super("This string expression is not money.");
	}
}
