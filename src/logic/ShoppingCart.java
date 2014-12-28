package logic;

import java.util.Date;
import java.util.ArrayList;

import exceptions.CartItemNotFoundException;
import exceptions.IllegalQuantityException;

/**
 * @author Mohamed Said
 * 
 */

public class ShoppingCart implements IShoppingCart {
		
	
	private int ID;
	private int sessionID;
	private int customerID;
	private Date lastAccessedDate;
	private ArrayList<ICartItem> itemsArray;
	
	/**
	 * Constructor initializes the member variables and sets the initial values
	 * @param p_ID new shopping cart ID
	 * @param p_sessionID the generated session ID for this cart
	 * @param p_customerID the cart's customer ID
	 */
	public ShoppingCart(int p_ID, int p_sessionID, int p_customerID) {
		itemsArray = new ArrayList<ICartItem>();
		lastAccessedDate = new Date();
		ID = p_ID;
		sessionID = p_sessionID;
		customerID = p_customerID;
	}
	
	
	/**
	 * @return shopping cart ID
	 */
	public int getID() {
		return ID;
	}
	
	/**
	 * @return session ID
	 */
	public int getSessionID() {
		return sessionID;
	}
	
	/**
	 * @return customer ID
	 */
	public int getCustomerID() {
		return customerID;
	}
	
	/**
	 * @param item the item that needs to be added to the cart
	 */	
	public void addItem(ICartItem item) {
		itemsArray.add(item);
	}
	
	
	/**
	 * Updates the quantity of a specific item inside the cart
	 * @param productID the product's ID that needs to get updated
	 * @param newQuantity the new quantity that needs to be set
	 * @throws IllegalQuantityException  if quantity is illegal
	 * @throws CartItemNotFoundException if there's no product with the given ID
	 */
	public void updateQuantity(int productID, int newQuantity) throws IllegalQuantityException, CartItemNotFoundException{
		boolean found = false;
		int i;
		for (i = 0; i < itemsArray.size(); ++i) {
			if (itemsArray.get(i).getProductID() == productID) {
				found = true;
				break;
			}
		}
		if (!found)
			throw new CartItemNotFoundException("No Such Item");
		if (newQuantity < 0 || newQuantity > itemsArray.get(i).getQuantiy())
			throw new IllegalQuantityException("Quantity not available");
		itemsArray.get(i).setQuantity(newQuantity);		
	}
	
	/**
	 * removes a specific item from the cart
	 * @param productID the id of the product that needs to be removed
	 * @throws CartItemNotFoundExceptions if there's no item with such ID
	 */
	public void removeItem(int productID) throws CartItemNotFoundException {
		boolean found = false;
		for (int i = 0; i < itemsArray.size(); ++i) {
			if (itemsArray.get(i).getProductID() == productID) {
				itemsArray.remove(i);
				found = true;
				break;
			}
		}
		if (!found)
			throw new CartItemNotFoundException("No Such Item");
	}
	
	/**
	 * returns a specific item from the cart
	 * @param productID the ID of the item that needs to get information about
	 * @return ICartItem an instance of the needed item
	 * @throws CartItemNotFoundException of there's no item with such ID
	 */
	public ICartItem getItem(int productID) throws CartItemNotFoundException {
		ICartItem temp = null;
		boolean found = false;
		for (int i = 0; i < itemsArray.size(); ++i) {
			if (itemsArray.get(i).getProductID() == productID) {
				temp = itemsArray.get(i);
				found = true;
				break;
			}
		}
		if (!found)
			throw new CartItemNotFoundException("No Such Item");
		return temp;
	}
	
	/* 
	 * A new array is created so that I don't return the array with its
	 * reference, for sake of security.
	 * I'm not sure whether being 'private' is enough 
	 * to be secure or not
	*/

	/**
	 * @return an array containing all the items in the current cart
	 */
	public ICartItem[] getItems() {
		ICartItem []array = new CartItem[itemsArray.size()];
		for (int i = 0; i < itemsArray.size(); ++i) {
			array[i] = itemsArray.get(i);
		}
		return array;
	}
	
	/**
	 * Counts the number of items in the current cart
	 * @return totalItems the total number of items in the cart  
	 */
	public int countItems() {
		int totalItems = 0;
		for (int i = 0; i < itemsArray.size(); ++i) {
			totalItems += itemsArray.get(i).getQuantiy();
		}
		return totalItems;
	}
	
	/**
	 * Keeps track of the last date this cart was accessed
	 * @return lastAccessedDate the date of the user's last access to his shopping cart
	 */
	public Date getLastAccessedDate() {
		return lastAccessedDate;
	}
}
