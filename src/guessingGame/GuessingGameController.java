package guessingGame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GuessingGameController {
	private NumberGame game;
	
	@FXML
	Label topMessage;
	@FXML
	Label promptMessage;
	@FXML
	Label statusMessage;
	@FXML
	Label boundMessage;
	@FXML
	TextField inputField;
	@FXML
	Button guess;
	@FXML
	Button clear;
	@FXML
	Button newGame;
	@FXML
	Button exitGame;
	
	/**
	 * Initialize the text that the label will show.
	 */
	@FXML
	public void init() {
		topMessage.setText("Guess the Secret Number");
		promptMessage.setText("Your guess?");
		inputField.setText("");
		boundMessage.setText("Can you guess a number between 1 and " + game.getUpperBound() + " that I'm thinking of?");
		statusMessage.setText(game.toString());
	}
	
	/**
	 * Set KunyarukGame.
	 * @param game is KunyarukGame.
	 */
	public void setGuessingGame(KunyarukGame game) {
		this.game = game;
	}
	
	/**
	 * Play the guessing game and show status message.
	 */
	public void enterPress(ActionEvent event) {
		game.guess(lastGuess());
		inputField.clear();
		statusMessage.setText(game.getMessage());
	}
	/**
	 * Clear inputField.
	 */
	public void clearInput(ActionEvent event) {
		inputField.clear();
	}
	
	/**
	 * Get text from TextField and return the value in int.
	 * @return last guessed value
	 */
	public int lastGuess() {
		return Integer.parseInt(inputField.getText());
	}
	
	/**
	 * Play new game.
	 */
	public void newGuessingGame(ActionEvent event) {
		game.deleteObservers();
		Main.view2.close();
		
		game = new KunyarukGame();
		inputField.clear();
		boundMessage.setText("Can you guess a number between 1 and " + game.getUpperBound() + " that I'm thinking of?");
		statusMessage.setText(game.toString());
		
		Main.view = new GameConsole(game);
		game.addObserver(Main.view);
		
		Main.view2 = new CounterView(game);
		game.addObserver(Main.view2);
		Main.view2.run();
		
		game.addObserver(Main.view3);
		Main.view3.run();
	}
	
	/**
	 * Exit game.
	 */
	public void exit(ActionEvent event) {
		System.exit(-1);
	}
}