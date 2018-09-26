
package working;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import demo.Calculator;

@DisplayName("Calculator Unit Tests")
class CalculatorTests {

	private final Calculator calculator = new Calculator();

	@Test
	@DisplayName("➕")
	void add() {
		assertEquals(5, calculator.add(2, 3), () -> "2 + 3 = " + (2 + 3));
	}

	@Test
	@DisplayName("n ➗ 0 → ArithmeticException")
	void divideByZero() {
		Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
		assertEquals("/ by zero", exception.getMessage());
	}

	@Test
	@DisplayName("Ensure Fibonacci computation is 'fast enough'")
	void fibonacci() {
		assertTimeoutPreemptively(ofMillis(1000), () -> calculator.fibonacci(30));
	}

}
