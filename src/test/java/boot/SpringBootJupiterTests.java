
package boot;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.condition.OS.MAC;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import demo.Cat;
import spring.EnabledOnMac;

@SpringBootTest
class SpringBootJupiterTests {

	private final Cat primaryCat;

	@Autowired
	SpringBootJupiterTests(Cat primaryCat) {
		this.primaryCat = primaryCat;
	}

	@Test
	@EnabledOnMac
	void primaryCat() {
		assertEquals("Catbert", this.primaryCat.getName());
	}

	@Test
	// @DisabledOnMac
	@DisabledOnOs(MAC)
	void qualifiedCat(@Qualifier("garfield") Cat cat) {
		assertEquals("Garfield", cat.getName());
	}

	@Test
	void cats(@Autowired List<Cat> cats) {
		assertEquals(asList("Catbert", "Garfield"), cats.stream().map(Cat::getName).collect(toList()));
	}

}
