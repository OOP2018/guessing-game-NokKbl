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
		int HALF_DIVISOR = 2;
		int newBound = 0;
		int guessLowerBound = 1;
		int guessUpperBound = game.getUpperBound()+1;
		
		while(true) {
			newBound = (guessLowerBound + guessUpperBound)/HALF_DIVISOR;
			game.guess(newBound);
			if (game.getMessage().contains("too small")) {
				guessLowerBound = newBound;
			}else if (game.getMessage().contains("too large")) {
				guessUpperBound = newBound;
			}else {
				return newBound;
			}
		}
	}
}
