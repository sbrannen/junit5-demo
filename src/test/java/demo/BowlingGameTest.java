
package demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("A BowlingGame")
class BowlingGameTest {

	private BowlingGame game;

	@BeforeEach
	void setup() {
		game = new BowlingGame();
	}

	@Test
	@DisplayName("should be correctly initialized")
	void initBowlingGame() {
		assertTrue(game != null);
	}

	@Nested
	@DisplayName("when rolled")
	class Rolls {

		private void rollMany(int n, int pins) {
			for (int i = 0; i < n; i++) {
				game.roll(pins);
			}
		}

		private void rollSpare() {
			game.roll(5);
			game.roll(5);
		}

		private void rollStrike() {
			game.roll(10);
		}

		@Nested
		@DisplayName("and no pins knocked down")
		class NoPinsKnockedDown {

			@Test
			@DisplayName("the score should be 0")
			void testGutterGame() {
				rollMany(20, 0);

				assertEquals(0, game.score());
			}
		}

		@Nested
		@DisplayName("one pin each time")
		class OnlyOnesRolled {

			@Test
			@DisplayName("the score should be 20")
			void testAllOnes() {
				rollMany(20, 1);

				assertEquals(20, game.score());
			}
		}

		@Nested
		@DisplayName("a spare and 3 pins afterwards")
		class OneSpareRolled {

			@Test
			@DisplayName("the score should be 16")
			void testSpare() {
				rollSpare();
				game.roll(3);
				rollMany(17, 0);

				assertEquals(16, game.score());
			}
		}

		@Nested
		@DisplayName("a strike, 4 and 3 pins afterwards")
		class OneStrikeRolled {

			@Test
			@DisplayName("the score should be 24")
			void testStrike() {
				rollStrike();
				game.roll(4);
				game.roll(3);
				rollMany(16, 0);

				assertEquals(24, game.score());
			}
		}

		@Nested
		@DisplayName("a perfect game")
		class PerfectGame {
			@Test
			@DisplayName("the score should be 300")
			void testPerfectGame() {
				rollMany(12, 10);

				assertEquals(300, game.score());
			}
		}
	}
}
