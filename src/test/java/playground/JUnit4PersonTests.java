
package playground;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import demo.Person;

public class JUnit4PersonTests {

	@Test
	public void getterMethods() {
		Person bart = new Person("Bart", "Simpson");
		assertEquals("Bart Simpson", bart.getFullName());
		assertEquals("Bart ", bart.getFirstName());
		assertEquals("Simpson ", bart.getLastName());
	}

}
