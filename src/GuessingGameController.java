import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GuessingGameController {
	private KunyarukGame game;
	private CounterView view2;
	private LastGuessView view3;
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
	
	/**
	 * Create a new GuessingGameController.
	 */
	public GuessingGameController() {
		game = new KunyarukGame();
		view2 = new CounterView(game);
		view3 = new LastGuessView(game);
	}
	
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
	 * Play the guessing game and show status message.
	 */
	public void enterPress(ActionEvent event) {
		game.guess(lastGuess());
		game.addObserver(view2);
		view2.run();
		game.addObserver(view3);
		view3.run(lastGuess());
		inputField.clear();
		statusMessage.setText(game.getMessage());
	}
	
	/**
	 * Get text from TextField and return the value in int.
	 * @return last guessed value
	 */
	public int lastGuess() {
		return Integer.parseInt(inputField.getText());
	}
}