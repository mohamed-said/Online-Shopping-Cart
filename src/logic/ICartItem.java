package logic;

/**
 * @author Mohamed Said
 */

public interface ICartItem {
  
	/**
    * this method is implemented to get ID of the shopping cart
    * @return ID of the shopping cart
    */
	public int getID();
    
	/**
     * this method is implemented to get ProductID in the shopping cart
     * @return ProductID of the shopping cart
     */
	public int getProductID();
   
	/**
    * this method is implemented to get Quantity of each product in the shopping cart
    * @return Quantity of the product
    */
	public int getQuantiy();

	/**
    * this method is implemented to get UnitPrice of each item in the shopping cart
    * @return UnitPrice of each item in the shopping cart
    */
	public double getUnitPrice();
   
	/**
    * this method is implemented to get TotalCost of items in the shopping cart
    * @return TotalCost of items in the shopping cart
    */
	public double getTotalCost();
    
	/**
     * this method is implemented to set ID of the shopping cart
     * @param id is set equal to ID
     */
	public void setID(int id);
	
	/**
	 * this method is implemented to set ProductID of product in the shopping cart
	 * @param productId is set equal to ProductID
	 */
	public void setProductID(int productId);
	
	/**
	 * this method is implemented to set Quantity of each product in the shopping cart
	 * @param quantity is set equal to Quantity
	 */
	public void setQuantity(int quantity);
	
	/**
	 * this method is implemented to set UnitPrice each of product in the shopping cart
	 * @param price is set equal to Unit price
	 */
	public void setUnitPrice(double price);

}