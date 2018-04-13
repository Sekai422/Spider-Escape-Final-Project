package code.Gui;

import interfaces.Constants;
import javafx.application.Application;
import javafx.stage.Stage;

public class GuiAnimationApp extends Application implements Constants {
	Stage window;
	StartMenu startMenu;
	GameScreen gameScreen;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.window = primaryStage;
		this.window.setTitle("Spider Escape v 1.0");
		this.window.setScene(this.startMenu.getScene());
		this.window.show();

		//method to change screen to game scene
		this.startMenu.getStartButton().setOnAction(e -> {
			window.close();
			this.init();
			this.gameScreen.display();
		});

	}

	public void init() {
		this.startMenu = new StartMenu();
		this.gameScreen = new GameScreen();
	}

}
