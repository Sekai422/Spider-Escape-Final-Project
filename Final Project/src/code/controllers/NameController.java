package code.controllers;

import code.Gui.GameScreen;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * This class is for getting the name of the person who played the game.
 */

public class NameController {

	/**
	 * This method will display a window where the user has to enter their name.
	 * If they don't want to it is entered as UNKNOWN as default
	 * @param screen
	 */
	public void display(GameScreen screen){
		Stage window = new Stage();
		window.setTitle("Name Input");

		TextField name = new TextField("UNKNOWN");

		Label label  =new Label("Enter name");

		HBox layout = new HBox();
		layout.getChildren().addAll(label, name);

		Scene scene = new Scene(layout);
		name.setOnKeyPressed(event -> {
			switch (event.getCode()){
				case ENTER:
					window.close();
					screen.getAvatar().setName(name.getText().toUpperCase());
					screen.getFileController().save(screen);
			}
		});

		window.setScene(scene);
		window.show();
	}
}
