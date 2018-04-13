package code.Gui;

import interfaces.Constants;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This runs the application of our game and displays the start menu
 */

public class GuiAnimationApp extends Application implements Constants {
	private Stage window;
	private StartMenu startMenu;
	private GameScreen gameScreen;

	/**
	 * Overridden method that starts the javafx application and displays the start menu window
	 * @param primaryStage
	 * @throws Exception
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.window = primaryStage;
		this.window.setTitle("Spider Escape v 1.0");
		this.window.setScene(this.startMenu.getScene());
		this.window.show();

		//closes start menu window and opens game window
		this.startMenu.getStartButton().setOnAction(e -> {
			window.close();
			this.init();
			this.gameScreen.display();
		});

	}

	/**
	 * Initializer for Gui Animation App
	 * Initializes the start menu and game screen
	 */
	public void init() {
		this.startMenu = new StartMenu();
		this.gameScreen = new GameScreen();
	}

	/**
	 * main method to launch javafx application
	 * @param args
	 */
	public static void main (String[] args) {
		launch(args);
	}

}
