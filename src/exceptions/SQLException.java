package exceptions;

/**
 * 
 * @author Mohamed Said
 * 
 */

@SuppressWarnings("serial")
/**
 * This class is implemented to handle errors concerning the SQL Files.
 */
public class SQLException extends PersistenceException {

	private String message;

	/**
	 * 
	 * @param message a message to print when this exception is thrown
	 */
	public SQLException(String message) {
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
