package dataPersistence;

import java.sql.SQLException;

import logic.IShoppingCart;

/**
 * @author Mohamed Said
 */
	 
	 
public interface IPersistenceMechanism {

	/**
	 * this method is implemented for saving the shopping cart itself
	 * @param cart instance of IShoppingCart
	 * @throws SQLException if an error occured when accessing the database
	 */
	public void save(IShoppingCart cart) throws SQLException;
	
	/**
	 *  this method is implemented for loading a user's shopping cart
	 * @param cartID the cart's ID
	 * @throws SQLException if an error occured while accessing the database
	 * @return IShoppingCart a loaded object from the database using the given ID
	 */
	public IShoppingCart loadCart(int cartID) throws SQLException;
	
	/** 
	 * this method is implemented for creating a shopping cart for user
	 * @param sessionID the generated session ID for this cart
	 * @param customerID the cart's customer
	 * @return IShoppingCart object representing the created cart
	 * @throws SQLException if an error occured when accessing the database
	 */
	public IShoppingCart createCart(int sessionID, int customerID) throws SQLException;
	
	/**
	 * this method is implemented for removing a specific cart
	 * @param cartID the cart's ID
	 * @throws SQLException  if an error happened when accessing the database
	 */
	public void removeCart(int cartID) throws SQLException;
	
	/**
	 * Has a self relation applying the Singleton Pattern
	 * @return an instance if the IPersistenceMechanism class
	 * 
	 */
//	public static IPersistenceMechanism getInstance() throws SQLException;
	
}









