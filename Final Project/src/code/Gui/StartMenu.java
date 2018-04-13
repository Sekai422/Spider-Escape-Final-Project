package code.Gui;

import interfaces.Constants;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class StartMenu implements Constants {
	Scene scene;
	Button startButton;
	Label title;
	BorderPane layout;

	public StartMenu(){
		this.initialize();
	}

	public BorderPane getLayout() {
		return this.layout;
	}

	public Scene getScene(){
		return this.scene;
	}

	public Button getStartButton() {
		return this.startButton;
	}

	public Label getTitle() {
		return this.title;
	}

	public void setScene(){
		this.scene = new Scene(this.getLayout(), windowWidth, windowHeight);
	}

	public void setStartButton(){
		this.startButton = new Button("Start");
		this.startButton.setPrefSize(200, 200);
	}

	public void setTitle(){
		this.title = new Label("SPIDER ESCAPE V 1.0");
		this.title.setFont(new Font("Helvetica Neut Bold", 30));
	}

	public void setLayout() {
		this.layout = new BorderPane();
		this.layout.setAlignment(this.startButton, Pos.CENTER);
		this.layout.setAlignment(this.title, Pos.TOP_CENTER);
		this.layout.setCenter(this.getStartButton());
		this.layout.setTop(this.getTitle());
	}

	public void initialize() {
		this.setTitle();
		this.setStartButton();
		this.setLayout();
		this.setScene();
	}


}
