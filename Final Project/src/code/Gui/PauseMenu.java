package code.Gui;

import interfaces.Constants;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PauseMenu implements Constants {

	public void display (GameScreen gameScreen) {

		VBox layout = new VBox(10);

		Label label = new Label("Paused");
		label.setFont(new Font(23));

		Button continueButton = new Button("Continue");
		Button saveButton = new Button("Save");
		Button restartButton = new Button("Restart");
		Button exitButton = new Button("Exit");

		continueButton.setOnAction(e -> {
			gameScreen.getGameLayout().getChildren().remove(gameScreen.getGameLayout().getChildren().size()-1);
			gameScreen.getTimeController().startTime();
			gameScreen.getSoundController().playMusic();
		});

		saveButton.setOnAction(e -> {
			System.out.println("Saved file");
		});

		restartButton.setOnAction(event -> {
			gameScreen.getGameLayout().getChildren().remove(gameScreen.getGameLayout().getChildren().size()-1);
			gameScreen.restart();
		});

		exitButton.setOnAction(e -> {
			((Stage) gameScreen.getScene().getWindow()).close();
		});

		layout.getChildren().addAll(label, continueButton, saveButton, restartButton, exitButton);
		layout.setAlignment(Pos.CENTER);
		layout.setStyle("-fx-background-color: #2f4f4f");
		layout.setPrefHeight(windowHeight);
		layout.setPrefWidth(windowWidth);

		if(gameScreen.getGameLayout().getChildren().get(gameScreen.getGameLayout().getChildren().size()-1).getClass().getSimpleName().equals("VBox") ) {
			gameScreen.getGameLayout().getChildren().remove(gameScreen.getGameLayout().getChildren().size()-1);
		}

		gameScreen.getGameLayout().getChildren().add(layout);
	}
}
