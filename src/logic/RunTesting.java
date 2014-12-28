package logic;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import exceptions.CartItemNotFoundExceptionTest;

/**
 * 
 * @author Mohamed Ossama
 *
 */

public class RunTesting {

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(CartItemNotFoundExceptionTest.class);
		System.out.println(result.getRunCount());
	}
}
