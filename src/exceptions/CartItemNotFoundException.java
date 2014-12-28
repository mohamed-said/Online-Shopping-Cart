package exceptions;

/**
 * 
 * @author Mohamed Said
 * 
 */

@SuppressWarnings("serial")
/**
 * This class is implemented for catching errors concerning with the absence of of such a cart item with a specific ID.
 */
public class CartItemNotFoundException extends Exception {

	private String message;

	/**
	 * @param message a message to print when this exception is thrown
	 */
	public CartItemNotFoundException(String message) {
		super(message);
	}

	/**
	 * @return message that alerts the user that there exists an error as there
	 *         is no such item in such cart.
	 */
	public String getMessage() {
		return message;
	}
}