
package working;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import playground.FastTest;

class TagsDisplayNamesAndDependencyInjectionTests {

	// --include-tag fast
	// --exclude-tag fast

	// @Test
	// @Tag("fast")
	@FastTest
	@DisplayName("Fast test! 😱")
	void fastTest(TestInfo testInfo) {
		System.err.println(testInfo);
	}

	@Tag("normal")
	@Test
	void normalTest() {
	}

}
