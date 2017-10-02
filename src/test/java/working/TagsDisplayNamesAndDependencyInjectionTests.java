
package working;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import playground.FastTest;

class TagsDisplayNamesAndDependencyInjectionTests {

	// --include-tag fast
	// --exclude-tag fast
	// @Test
	// @Tag("fast")
	@FastTest
	@DisplayName("Fast test with a cool name! 😱")
	void fastTest(TestInfo testInfo) {
		System.out.println(testInfo);
	}

	@Test
	void normalTest(TestInfo testInfo) {
		System.out.println(testInfo);
	}

}
