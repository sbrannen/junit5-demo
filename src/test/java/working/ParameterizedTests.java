
package working;

import static demo.StringUtils.isPalindrome;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParameterizedTests {

	@ParameterizedTest
	@ValueSource(strings = { //
			"mom", //
			"dad", //
			"radar", //
			"racecar", //
			"able was I ere I saw elba"//
	})
	void palindromes(String candidate) {
		assertTrue(isPalindrome(candidate));
	}

}
