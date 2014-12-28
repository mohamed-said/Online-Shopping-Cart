package dataPersistence;

import java.io.File;

import logic.IShoppingCart;
import logic.ShoppingCart;

/**
 * 
 * @author Mohamed Said
 *
 */

public class FilePersistence implements IPersistenceMechanism {

	
	private static FilePersistence instance = null;
	@SuppressWarnings("unused")
	private static File infilePersistence = null;
	private final String fileName = "datafile";
	
	private FilePersistence() {
		infilePersistence = new File(fileName);
	}
	
	/**
	 * saves a shopping cart to be used later
	 * @param cart instance of class IShoppingCart
	 */
	public void save(IShoppingCart cart) {
		
	}
	
	
	/**
	 * this method is implemented for loading a customer's shopping cart
	 * @param cartID ID of the cart that needs to be loaded
	 * @return Cart instance of IshoppingCart
	*/
	public IShoppingCart loadCart(int cartID) {
		int dummy_sessionID = 1;
		int dummy_customerID = 1;
		return new ShoppingCart(cartID, dummy_sessionID, dummy_customerID);
	}
	
	/**
	 * creates a cart for a customer
	 * @param sessionID a generated ID for every system login
	 * @param customerID an ID identifies every user
	 * @return a new object from shopping cart
	 */
	public IShoppingCart createCart(int sessionID, int customerID) {
		int dummy_id = 1;
		return new ShoppingCart(dummy_id, sessionID, customerID);
	}
		
	/**
	 * @param cartID the ID of some cart to be removed from persistence
	 */
	public void removeCart(int cartID) {
		
	}
	
	/**
	 * @return an instance of the current mechanism
	 * applies singleton pattern
	*/
	public static IPersistenceMechanism getInstance() {
		if (instance == null) {
			instance = new FilePersistence();
			return instance;
		}
		return instance;
	}
}
