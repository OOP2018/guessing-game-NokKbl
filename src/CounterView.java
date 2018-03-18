import java.util.Observable;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * A Controller for a window that shows the value of a Counter.
 * @author Kunyaruk Katebunlu
 */
public class CounterView extends Stage implements java.util.Observer {
	/** the stage (top-level window) for showing scene */
	private Stage stage;
	/** a counter to show value of */
	private NumberGame game;
	/** the label that shows the counter value. */
	private Label label;
	
	/**
	 * Initialize a CounterView, which shows value of a counter.
	 * @param counter the Counter to show.
	 */
	public CounterView(NumberGame game) {
		this.game = game;
		initComponents();
	}
	
	/**
	 * Initialize a CounterView.
	 */
	private void initComponents() {
		stage = this;
		HBox root = new HBox();
		root.setPadding(new Insets(10));
		root.setAlignment(Pos.CENTER);
		label = new Label("");
		label.setPrefWidth(400);
		label.setFont(new Font("Comic Sans MS", 30.0));
		label.setAlignment(Pos.CENTER);
		root.getChildren().add(label);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Count");
		stage.sizeToScene();
	}
	
	/** Show the window and update the counter value. */
	public void run() {
		stage.show();
		displayCount();
	}
	
	/**
	 * Display the value of round counter.
	 */
	public void displayCount() {
		label.setText( String.format("Guess count: %2d", game.getCount()) );
	}
	
	/**
	 * This method is called whenever the observed object is changed.
	 * @param o the observable object.
	 * @param arg an argument passed to the notifyObservers method.
	 */
	@Override
	public void update(Observable o, Object arg) {
		displayCount();
	}	
}
