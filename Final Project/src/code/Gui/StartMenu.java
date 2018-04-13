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


	/**
	 * method initializes the StartMenu attributes, size button and controller for a gamescreen object.
	 */
	public StartMenu(){
		this.initialize();
	}


	/**
	 * method returns the layout of the BorderPane that holds the labels and button.
	 * @return the BorderPane layout object holding gui objects..
	 */
	public BorderPane getLayout() {
		return this.layout;
	}

	/**
	 * method returns the Scene object of the Start Menu that has been created.
	 * @return the Scene for start menu.
	 */
	public Scene getScene(){
		return this.scene;
	}

	/**
	 * returns the Buttom object that starts the game screen for playthrough.
	 * @return Button object to be used in start menu.
	 *
	 */
	public Button getStartButton() {
		return this.startButton;
	}

	/**
	 * returns the Label object that starts the game screen for playthrough.
	 * @return  Label object to be used in start menu  for title.
	 */
	public Label getTitle() {
		return this.title;
	}

	/**
	 * Method sets the scene based on the borderpane layour and interface constants for height and width.
	 */
	public void setScene(){
		this.scene = new Scene(this.getLayout(), windowWidth, windowHeight);
	}

	/**
	 * Sets the attributes of the Button object in start menu.
	 */
	public void setStartButton(){
		this.startButton = new Button("Start");
		this.startButton.setPrefSize(200, 200);
	}

	/**
	 * Method sets string value for Label object which is the title in the startmenu.
	 */
	public void setTitle(){
		this.title = new Label("SPIDER ESCAPE V 1.0");
		this.title.setFont(new Font("Helvetica Neut Bold", 30));
	}

	/**
	 * Sets all the layout positions of the objects used in the start menu.
	 * Aligns objects to center and starts with title at top following with start button at bottom
	 */
	public void setLayout() {
		this.layout = new BorderPane();
		this.layout.setAlignment(this.startButton, Pos.CENTER);
		this.layout.setAlignment(this.title, Pos.TOP_CENTER);
		this.layout.setCenter(this.getStartButton());
		this.layout.setTop(this.getTitle());
	}

	/**
	 *  Method sets all the Objects used in startmenu and gives them attributes.
	 *  Sets the attributes when the StartMenu object is used.
	 */
	public void initialize() {
		this.setTitle();
		this.setStartButton();
		this.setLayout();
		this.setScene();
	}


}
