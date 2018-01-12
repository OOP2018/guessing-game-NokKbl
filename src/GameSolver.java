/**
 * This class is for automatically guess the secret number for any NumberGame.
 * @author Kunyaruk Katebunlu
 */
public class GameSolver {

	/**
	 * Play a NumberGame and return the secret number.
	 * @param game is the NumberGame to solve
	 * @return the correct answer
	 */
	public int play(NumberGame game) {
		for (int guessNum = 0; guessNum <= game.getUpperBound(); guessNum++) {
			boolean correct = game.guess(guessNum);
			if (correct) return guessNum;
		}
		return 0;
	}
}
