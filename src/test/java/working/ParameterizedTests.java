
package working;

import static demo.StringUtils.isPalindrome;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@TestInstance(Lifecycle.PER_CLASS)
class ParameterizedTests {

	@ParameterizedTest
	//	@ValueSource(strings = { //
	//			"mom", //
	//			"dad", //
	//			"radar", //
	//			"racecar", //
	//			"able was I ere I saw elba"//
	//	})
	@MethodSource // ("palindromes")
	void palindromes(String candidate) {
		assertTrue(isPalindrome(candidate));
	}

	Stream<String> palindromes() {
		return Stream.of("mom", //
			"dad", //
			"radar", //
			"racecar", //
			"able was I ere I saw elba"//
		);
	}

}
