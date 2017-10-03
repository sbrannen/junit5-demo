
package working;

import static java.time.Duration.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import demo.Calculator;

// @EnableRuleMigrationSupport
class JUnitJupiterCalculatorTests {

	private final Calculator calculator = new Calculator();

	// @Rule
	// public final ExpectedException exception = ExpectedException.none();

	@Test
	void add() {
		assertEquals(5, calculator.add(2, 3), () -> "2 + 3 = " + (2 + 3));
	}

	@Test
	void subtract() {
		assertEquals(2, calculator.subtract(5, 3));
	}

	@Test
	void multiply() {
		assertEquals(15, calculator.multiply(3, 5));
	}

	@Test
	void divide() {
		assertEquals(2, calculator.divide(8, 4));
	}

	@Test
	@DisplayName("Division by zero should throw an ArithmeticException")
	void divideByZero() {
		Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
		assertEquals("/ by zero", exception.getMessage());
	}

	@Test
	@DisplayName("Ensure Fibonacci computation is 'fast enough'")
	void fibonacci() {
		// f(42) - f(45) will likely take longer than 1000 ms.
		// assertTimeout(ofMillis(1000), () -> calculator.fibonacci(30));
		assertTimeoutPreemptively(ofMillis(1000), () -> calculator.fibonacci(30));
	}

}
