import java.util.Scanner;

/** 
 *  Play guessing game on the console.
 *  @author Kunyaruk Katebunlu
 */
public class GameConsole {

	/**
	 * This play method use to play a game by getting input from a player.
	 * @param game is the NumberGame to play.
	 * @return a number that player guess
	 */
	public int play(NumberGame game) {
		Scanner console = new Scanner(System.in);
		
		// describe the game
		System.out.println( game.toString() );
		
		//play game and print message by using loop
		System.out.println(game.getMessage());
		while(true) {
			System.out.print("Your answer? ");
			int guess = console.nextInt();
			boolean correct = game.guess(guess);
			System.out.println(game.getMessage());
			if (correct) {
				return guess;
			}
		}
	}
	
}
