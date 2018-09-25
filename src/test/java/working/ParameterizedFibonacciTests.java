
package working;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import demo.Calculator;

@ExtendWith(LoggingExtension.class)
class ParameterizedFibonacciTests {

	private final Calculator calculator = new Calculator();

	@ParameterizedTest(name = "fib({0}) → {1}")
	@CsvSource({ //
			"0,  0", //
			"1,  1", //
			"2,  1", //
			"3,  2", //
			"4,  3", //
			"5,  5", //
			"40, 102334155", //
			"41, 165580141", //
			"42, 267914296", //
			"43, 433494437", //
			"44, 701408733", //
			// "45, 1134903170" //
	})
	void fibonacci(int n, int expected) {
		assertEquals(expected, calculator.fibonacci(n));
	}

}
