package exceptions;


/**
 * @author Mohamed Said
 */

@SuppressWarnings("serial")

/**
 * This class is implemented to catch errors concerning with entering illegal quantity of any item as may be the stock has less number of items from that ordered by the customer.
 */
public class IllegalQuantityException extends RuntimeException{

	private String message;
	
	public IllegalQuantityException(String message) {
		super(message);
	}

	/**
	 * @return message alerts the user with a message containing the wrong action.
	 */
	public String getMessage() {
		return message;
	}

}