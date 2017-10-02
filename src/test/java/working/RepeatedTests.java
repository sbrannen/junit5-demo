
package working;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

class RepeatedTests {

	@RepeatedTest(5)
	void repeatedTest(RepetitionInfo repetitionInfo) {
		assertEquals(5, repetitionInfo.getTotalRepetitions());
	}

	@RepeatedTest(value = 5, name = "Wiederholung {currentRepetition} von {totalRepetitions}")
	void repeatedTestInGerman() {
		// ...
	}

}
