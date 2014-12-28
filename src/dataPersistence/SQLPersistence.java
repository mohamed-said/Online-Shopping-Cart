package dataPersistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logic.IShoppingCart;
import logic.ShoppingCart;

/**
 * 
 * @author Mohamed Ossama
 *
 */

public class SQLPersistence implements IPersistenceMechanism {

	/**
	 * Connection holder
	 */
	Connection DataSource;
	
	/**
	 * instance from the SQLPersistence class
	 * to implement the singleton pattern
	 */
	private static SQLPersistence instance = null;

	/**
	 * Constructor ,, opens connection to the MYSQL Database
	 * @throws SQLException if an error occured when connecting to the database
	 */
	private SQLPersistence() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.getConnection("jdbc:mysql://localhost:3306/ShoppingCart", "kogo", "kogo12345");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Saves the shopping cart in the database
	 * @param cart a shopping cart object holding some items to be saved
	 * @throws SQLException
	 */
	public void save(IShoppingCart cart) throws SQLException {
		DataSource = DriverManager.getConnection("jdbc:mysql://localhost/ShoppingCart", "kogo", "kogo12345");
		PreparedStatement sqlStat = null;
		try {
			sqlStat = DataSource.prepareStatement("insert into ShoppingCarts values ("
					+ cart.getID() + ","
					+ cart.getSessionID() + ","
					+ cart.getCustomerID() + ","
					+ cart.getLastAccessedDate() + ")");
			sqlStat.execute();
		} catch (SQLException ex) {
			ex.getErrorCode();
		}
	}

	/**
	 * Loads a card from the database including all the items
	 * @param customer_id every customer has a unique ID to log in to the system
	 * @param session_id every customer has a session ID when logs in to the system
	 * @return IShoppingCart a shopping cart object loaded from the Database
	 * @throws SQLException if and error occured while accessing the database
	 */
	public IShoppingCart loadCart(int customer_id, int session_id)
			throws SQLException {

		IShoppingCart sc = null;
		DataSource = DriverManager.getConnection("jdbc:mysql://localhost/ShoppingCart", "kogo", "kogo12345");
		PreparedStatement sqlState = DataSource.prepareStatement("Select * from ShoppingCarts where customer_id "
						+ customer_id
						+ "AND session_id =" + session_id);

		ResultSet rows = sqlState.executeQuery();
		while (rows.next()) {
			sc = new ShoppingCart(rows.getInt("ID"),
					rows.getInt("session_id"),
					rows.getInt("customer_id"));
		}
		return sc;
	}

	/**
	 * 
	 * @param cartID the id of the 
	 * @return an object containing the loaded cart
	 * @throws SQLException if some errors occured while accessing the database 
	 */
	public IShoppingCart loadCart(int cartID) throws SQLException {
		IShoppingCart sc = null;
		DataSource = DriverManager.getConnection("jdbc:mysql://localhost/ShoppingCart","kogo", "kogo12345");
		PreparedStatement sqlState = DataSource.prepareStatement("Select * from ShoppingCarts where ID = " + cartID);
		ResultSet rows = sqlState.executeQuery();
		while (rows.next()) {
			sc = new ShoppingCart(rows.getInt("ID"), rows.getInt("session_id"),rows.getInt("customer_id"));
		}
		return sc;
	}

	/**
	 * @param sessionID the generated session id when this cart was created
	 * @param customerID the id of the customer who wants to create this cart
	 * @return a new object of shopping cart
	 * @throws SQLException if some error occured while accessing the database
	 */
	public IShoppingCart createCart(int sessionID, int customerID) throws SQLException {
		IShoppingCart sc = null;
		try {
			DataSource = DriverManager.getConnection("jdbc:mysql://localhost/ShoppingCart", "kogo", "kogo12345");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement sqlState = null;
		try {
			sqlState = DataSource.prepareStatement("insert into ShoppingCarts (session_id,customer_id) values"
							+ "(" + sessionID + "," + customerID + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			sqlState.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sc;
	}

	/**
	 * @param cartID the id of the cart needs to be removed
	 * @throws SQLException if failed to connect to database
	 */
	public void removeCart(int cartID) throws SQLException {
		try {
			DataSource = DriverManager.getConnection("jdbc:mysql://localhost/ShoppingCart", "kogo", "kogo12345");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement sqlState = null;
		try {
			sqlState = DataSource.prepareStatement("delete from ShoppingCarts where ID = " + cartID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			sqlState.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return IPersistenceMechanism an instance of this mechanism, applying the singleton pattern
	 * @throws SQLException if an error occured
	 */
	public static IPersistenceMechanism getInstance() throws SQLException {
		if (instance == null) {
			try {
				instance = new SQLPersistence();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return instance;
		}
		return instance;
	}
}
