import java.util.Random;

/**
 * This game is game of guessing a secret number on my mind.
 * @author Kunyaruk Katebunlu
 * @version 2018.01.12
 */
public class KunyarukGame extends NumberGame{
    /** upper bound for secret number */
    private int upperBound;
    /** the solution to the game */
    private int secret;
    /** count guesses */
    private int countRound = 0;

    /** Initialize a new default game. */
    public KunyarukGame() {
    		this(321);
    }
    
    /**
     * Initialize a new game.
     * @param upperbound is the max value for the secret number (>1).
     */
	public KunyarukGame(int upperbound) {
		final int lowerBound = 4;
		this.upperBound = upperbound;
		long seed = System.nanoTime();
		Random ran = new Random(seed);
		this.secret = ran.nextInt(this.upperBound)+1;
		super.setMessage("Can you guess a number between "+lowerBound+" and "+this.upperBound+" that I'm thinking of?");
	}
	
	/**
     * Evaluate a player's guess number. 
     * @param number is the player's guess
     * @return true if guess is correct, false otherwise
     */
	public boolean guess(int number) {
		if(number == secret) {
			setMessage("Wow! Correct!! I'm thinking of "+secret+".");
			countRound++;
			return true;
		}
		if(number < secret) {
			setMessage("Umm, I think that's too small.");
		}else {
			setMessage("Oh! I think your answer is too large.");
		}
		countRound++;
		return false;
	}
	
	/** Get an upper bound of the game */
	public int getUpperBound() {
		return this.upperBound;
	}
    
	/** Get number of round that player guess */
	public int getCount() {
		return this.countRound;
	}
	
    @Override
    public String toString() {
    		return "Guess a secret number on my mind.";
    }
}
