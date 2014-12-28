package logic;

import java.util.Date;

import exceptions.CartItemNotFoundException;
import exceptions.IllegalQuantityException;

   /**
    * @author Mohamed Said
    */

public interface IShoppingCart {
   
	/**
	 * @return get ID of the shopping cart
	 */
	public int getID();
   
	/**
	 * @return session ID this cart is working with 
	 */
	public int getSessionID();
   
	/**
	 * @return the customer id of this cart
    */
	public int getCustomerID();
   
	/**
    * this method is implemented to add a new item to the shopping cart
    * @param  item instance of ICartItem
    */
	public void addItem(ICartItem item);
	
	/**
	 * this method is implemented to update quantity of each item in the shopping cart
	 * @param cartItemID to specify which item to be updated 
	 * @param newQuantity to insert the new quantity of the item updated
	 * @throws CartItemNotFoundException if there is no product with the given ID
	 * @throws IllegalQuantityException if the quantity is illegal
	 */ 
	
	public void updateQuantity(int cartItemID, int newQuantity) throws IllegalQuantityException, CartItemNotFoundException;
	 /**
	  * this method is implemented to remove item from the shopping cart
	  * @param productID to specify which product to be removed from the shopping cart 
	  * @throws CartItemNotFoundException if there is no product with the given ID
	  */
	public void removeItem(int productID) throws CartItemNotFoundException; // error
	
	 /** 
	  * this method is implemented to get item from shopping cart by creating instance from ICartItem
	  * @param productID specify which product to get from ICartItem
	  * @return instance of the needed item, given it's id
	  * @throws CartItemNotFoundException if there's no product with the given ID
	  */
	public ICartItem getItem(int productID) throws CartItemNotFoundException;
	
	/**
	 * this method is implemented to get all items in the shopping cart
	 * @return an array containing all the items in this cart
	 */
	public ICartItem[] getItems();
	
	/**
	 * this method is implemented to count all items in the shopping cart
	 * @return a number represents all the items inside this cart
	 */
	public int countItems();
	
	/**
	 * this method is implemented to get last last accessed date
	 * @return the last date this cart was accessed
	 */
	public Date getLastAccessedDate();

}