
package working;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import demo.Cat;
import spring.DisabledOnMac;
import spring.EnabledOnMac;
import spring.TestConfig;

@SpringJUnitConfig(TestConfig.class)
class SpringJupiterTests {

	@Test
	@EnabledOnMac
	void primaryCat(@Autowired Cat cat) throws Exception {
		assertEquals("Catbert", cat.getName());
	}

	@Test
	@DisabledOnMac
	void cats(@Autowired List<Cat> cats) throws Exception {
		assertEquals(asList("Catbert", "Garfield"), cats.stream().map(Cat::getName).collect(toList()));
	}

}
