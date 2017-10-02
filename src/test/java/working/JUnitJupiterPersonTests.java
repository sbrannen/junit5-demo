
package working;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import demo.Person;

class JUnitJupiterPersonTests {

	@Test
	void getterMethods() {
		Person bart = new Person("Bart", "Simpson");

		assertAll("Person getter methods", //
			() -> assertEquals("Bart Simpson", bart.getFullName()), //
			() -> assertEquals("Bart ", bart.getFirstName()), //
			() -> assertEquals("Simpson ", bart.getLastName())//
		);
	}

}
