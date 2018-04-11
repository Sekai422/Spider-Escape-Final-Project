package code;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class NameController {

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
					screen.avatar.setName(name.getText().toUpperCase());
					screen.getFileController().save(screen);
			}
		});

		window.setScene(scene);
		window.show();
	}
}
