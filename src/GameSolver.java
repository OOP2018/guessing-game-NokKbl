/**
 * This class is for automatically guess the secret number for any NumberGame.
 * @author Kunyaruk Katebunlu
 */
public class GameSolver {

	/**
	 * Play a NumberGame and return the secret number.
	 * The NumberGame object must provide message (getMessage)
	 * containing the phrase "too small" if a guess is smaller than
	 * the secret number and "too large" if a guess is larger than
	 * the secret number, for efficient solution.
	 * 
	 * @param game is the NumberGame to solve
	 * @return the correct answer
	 */
	public int play (NumberGame game) {
		int newBound = 0;
		int guessLowerBound = 1;
		int guessUpperBound = game.getUpperBound();
		boolean correct = false;
		
		while(!correct) {
			newBound = guessLowerBound + (guessUpperBound - guessLowerBound)/2;
			correct = game.guess(newBound);
			
			if (game.getMessage().contains("too small")) guessLowerBound = newBound + 1;
			else if (game.getMessage().contains("too large")) guessUpperBound = newBound - 1;
			else break;
		}
		return newBound;
	}
}
