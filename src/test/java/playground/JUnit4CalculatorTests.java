
package playground;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import demo.Calculator;

public class JUnit4CalculatorTests {

	private final Calculator calculator = new Calculator();

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Rule
	public Timeout globalTimeout = Timeout.millis(1000);

	@Test
	public void add() {
		assertEquals("2 + 3 = 5", 5, calculator.add(2, 3));
	}

	@Test
	public void subtract() {
		assertEquals(2, calculator.subtract(5, 3));
	}

	@Test
	public void multiply() {
		assertEquals(15, calculator.multiply(3, 5));
	}

	@Test
	public void divide() {
		assertEquals(2, calculator.divide(8, 4));
	}

	@Test
	// @Test(expected = ArithmeticException.class)
	// Division by zero should throw an ArithmeticException
	public void divideByZero() {
		exception.expect(ArithmeticException.class);
		exception.expectMessage("/ by zero");
		calculator.divide(1, 0);
	}

	@Test
	// @Test(timeout = 1000)
	// Ensure Fibonacci computation is 'fast enough'
	public void fibonacci() {
		// f(42) - f(45) will likely take longer than 1000 ms.
		calculator.fibonacci(30);
	}

}
