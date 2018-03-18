import java.net.URL;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * A main class for the GuessingGame.
 * It is responsible for creating objects, 
 * connecting objects, and running the game UI.
 * 
 * @author Kunyaruk Katebunlu
 */
public class Main extends Application {
	public static final String UI_FILE = "GuessingGameUI.fxml";
	/**
	 * The start method is called after the init method has returned,
	 * and after the system is ready for the application to begin running.
	 * @param primaryStage is the stage for this application which the application scene can be set.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		NumberGame game = new KunyarukGame();
		
		try {
			URL url = getClass().getResource("GuessingGameUI.fxml");
			if (url == null) {
				System.out.println("Couldn't find file: GuessingGameUI.fxml");
				Platform.exit();
			}
			FXMLLoader loader = new FXMLLoader(url);
			Parent root = loader.load();
			GuessingGameController controller = loader.getController();
			
			// Dependency Injection:
			controller.init();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.setTitle("Guessing Game");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}
		
		GameConsole view = new GameConsole(game);
		game.addObserver(view);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
