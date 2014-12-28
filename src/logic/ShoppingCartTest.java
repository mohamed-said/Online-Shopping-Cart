package logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.CartItemNotFoundException;

/**
 * 
 * @author Mohamed Said
 *
 */

public class ShoppingCartTest {

	ShoppingCart cart = null;
		
	@Before
	public void setUp() {
		cart = new ShoppingCart(1, 1, 1);
	}
	
	@Test
	public void testAddItem() {
		cart.addItem(new CartItem(1, 1, 1, 1));
		cart.addItem(new CartItem(2, 2, 2, 2));
		assertTrue(cart.countItems() == 2);
	}
	
	@Test
	public void testCountItems() {
		assertEquals(2, cart.countItems());
	}
	
	@Test(expected = CartItemNotFoundException.class)
	public void testCartItemNotFoundExceptionIsThrown() throws CartItemNotFoundException {
		cart.removeItem(3);
	}
	
	@Test
	public void testRemoveItemNormal() throws CartItemNotFoundException {
		cart.removeItem(1);
		assertEquals(1, cart.countItems());
	}
}

