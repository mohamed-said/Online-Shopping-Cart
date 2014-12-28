package logic;

/**
 * @author Mohamed Said
 */

public class CartItem implements ICartItem {
	
	/*
	 * 
	 * local variables
	 */
	private int ID;
	private int productID;
	private int quantity;
	private double price;

	
	/*
	 * 
	 * Cart Item Setters
	 */
	
	public CartItem(int _id, int _productID, int _quantity, double _price) {
		ID = _id;
		productID = _productID;
		quantity = _quantity;
		price = _price;
	}
	
	public void setID(int _id) {
		ID = _id;
	}
	
	public void setProductID(int _productID) {
		productID = _productID;
	}
	
	public void setQuantity(int _quantity) {
		quantity = _quantity;
	}
	
	public void setUnitPrice(double _price) {
		price = _price;
	}

	
	
	/*
	 * Cart Item getters 
	 *
	 */
	
	public int getID() {
		return ID;
	}
	
	public int getProductID() {
		return productID;
	}
	
	public int getQuantiy() {
		return quantity;
	}
	
	public double getUnitPrice() {
		return price;
	}
	
	public double getTotalCost() {
		return price * quantity;
	}	
}
