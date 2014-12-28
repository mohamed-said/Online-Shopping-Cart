package logic;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import exceptions.CartItemNotFoundException;

/**
 * 
 * @author Mohamed Said
 *
 */

public class RemoveItemTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testRemoveItem() throws CartItemNotFoundException {
		try {
			new ShoppingCart(1, 1, 1).removeItem(0);
			fail("Should have thrown an CartItem Cart Item not found Exception!");
		} catch (CartItemNotFoundException e) {
			assertThat("No Such Item", containsString("No Such Item"));

		}
	}
}
