
package working;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import demo.Cat;
import spring.DisabledOnMac;
import spring.EnabledOnMac;
import spring.TestConfig;

@SpringJUnitConfig(TestConfig.class)
class SpringJupiterTests {

	private final Cat primaryCat;

	@Autowired
	SpringJupiterTests(Cat primaryCat) {
		this.primaryCat = primaryCat;
	}

	@Test
	@EnabledOnMac
	void primaryCat() {
		assertEquals("Catbert", this.primaryCat.getName());
	}

	@Test
	@DisabledOnMac
	void qualifiedCat(@Qualifier("garfield") Cat cat) {
		assertEquals("Garfield", cat.getName());
	}

	@Test
	void cats(@Autowired List<Cat> cats) {
		assertEquals(asList("Catbert", "Garfield"), cats.stream().map(Cat::getName).collect(toList()));
	}

}
