
package working;

import static demo.StringUtils.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class ParameterizedTests {

	@ParameterizedTest
	//	@ValueSource(strings = { //
	//			"mom", //
	//			"dad", //
	//			"radar", //
	//			"racecar", //
	//			"able was I ere I saw elba"//
	//	})
	@MethodSource("candidates")
	void palindromes(String candidate) {
		assertTrue(isPalindrome(candidate));
	}

	static Stream<String> candidates() {
		return Stream.of("mom", //
			"dad", //
			"radar", //
			"racecar", //
			"able was I ere I saw elba"//
		);
	}

}
