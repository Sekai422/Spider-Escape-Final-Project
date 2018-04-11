package code;

import gui_version.interfaces.Constants;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PauseMenu implements Constants {

	//Create variable



	public void display (GameScreen gameScreen) {
		Stage window = new Stage();
		window.setTitle("Pause Menu");

		VBox layout = new VBox(10);

		Label label = new Label("Paused");
		label.setFont(new Font(23));

		Button continueButton = new Button("Continue");
		Button saveButton = new Button("Save");
		Button restartButton = new Button("Restart");
		Button exitButton = new Button("Exit");

		continueButton.setOnAction(e -> {
			window.close();
			gameScreen.getTimeController().startTime();
		});

		saveButton.setOnAction(e -> {
			System.out.println("Saved file");
		});

		restartButton.setOnAction(event -> {
			window.close();
			gameScreen.restart();
		});

		exitButton.setOnAction(e -> {
			window.close();
			((Stage) gameScreen.getScene().getWindow()).close();
		});

		layout.getChildren().addAll(label, continueButton, saveButton, restartButton, exitButton);
		layout.setAlignment(Pos.CENTER);
		layout.setStyle("-fx-background-color: #2f4f4f");

		Scene scene = new Scene(layout);

		window.setScene(scene);
		window.show();
	}
}
