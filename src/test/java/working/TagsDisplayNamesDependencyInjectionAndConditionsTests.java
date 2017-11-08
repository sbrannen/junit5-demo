
package working;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import playground.FastTest;
import spring.DisabledOnMac;

@DisplayName("Tags, Display Names, DI, and Conditions")
class TagsDisplayNamesDependencyInjectionAndConditionsTests {

	// @Test
	// @Tag("fast")
	@FastTest
	@DisplayName("Fast test! 😱")
	void fastTest(TestInfo testInfo) {
		System.err.println(testInfo);
	}

	// @Disabled
	@DisabledOnMac
	// @EnabledOnMac
	@Tag("normal")
	@Test
	void normalTest() {
	}

}
