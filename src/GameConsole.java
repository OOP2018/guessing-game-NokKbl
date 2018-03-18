import java.util.Observable;

/**
 * Print the counter value on the console whenever it changes.
 * @author Kunyaruk Katebunlu
 */
public class GameConsole implements java.util.Observer {
	NumberGame game;

		/**
		 * A ConsoleView with reference to a counter (the subject).
		 * @param counter the counter to display.
		 */
		public GameConsole(NumberGame game) {
			this.game = game;
		}
		
		/**
		 * This method is called whenever the observed object is changed.
		 * @param subject the observable object.
		 * @param info an argument passed to the notifyObservers method.
		 */
		@Override
		public void update(Observable subject, Object info) {
			if(info != null) System.out.println(info);
		}
}
