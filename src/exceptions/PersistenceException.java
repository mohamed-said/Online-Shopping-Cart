package exceptions;

import java.lang.Exception;

/**
 * @author Mohamed Said
 */

@SuppressWarnings("serial")
/**
 * This class is implemented to handle errors concerning the persistence file .
 */
public class PersistenceException extends Exception {
	private String message;

	/**
	 * 
	 * @param message a message to print when this exception is thrown
	 */
	public PersistenceException(String message) {
		super(message);
	}

	/**
	 * @return message alerts the user with a message containing the wrong
	 *         action.
	 */
	public String getMessage() {
		return message;
	}
}