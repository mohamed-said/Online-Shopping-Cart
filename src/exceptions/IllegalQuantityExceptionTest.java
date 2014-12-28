package exceptions;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import logic.ShoppingCart;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * 
 * @author Mohamed Ossama
 *
 */

public class IllegalQuantityExceptionTest {
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testupdateQuantity() throws CartItemNotFoundException {
		try {
			new ShoppingCart(1, 1, 1).updateQuantity(1, -1);
			fail("Should have thrown an IllegalQuantity Exception !");
		} catch (CartItemNotFoundException e) {
			assertThat("Quantity not available", containsString("Quantity not available"));
		}
	}
}
