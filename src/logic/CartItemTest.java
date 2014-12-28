package logic;

import static org.junit.Assert.*;

import org.junit.*;

/**
 * 
 * @author Mohamed Said
 *
 */

public class CartItemTest {
	
	private CartItem item;
	
	@Before
	public void setUp() {
		item = new CartItem(1, 1, 1, 1.0);
	}
	
	@Test // test the normal quantity
	public void testSetQuantityNormal() {
		item.setQuantity(10);
		assertTrue(item.getQuantiy() == 10);
	}
	
	@Test // test negative quantity
	public void testQuantityNegative() {
		item.setQuantity(-10);
		assertTrue(item.getQuantiy() == 10);
	}
	
	@After
	public void tearDown() {
		item = null;
	}
}
