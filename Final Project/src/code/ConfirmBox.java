package code;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ConfirmBox {

	//Create variable
	boolean answer;

	public VBox display(String message) {
		//Stage window = new Stage();
		//window.initModality(Modality.APPLICATION_MODAL);
		//window.setTitle(title);
		//window.setMinWidth(250);
		Label label = new Label();
		label.setText(message);

		//Create two buttons
		Button yesButton = new Button("Yes");
		Button noButton = new Button("No");

		//Clicking will set answer and close window
		yesButton.setOnAction(e -> {
			this.answer = true;
			System.out.println(this.isAnswer());
			//window.close();
		});
		noButton.setOnAction(e -> {
			this.answer = false;
			System.out.println(this.isAnswer());
			//window.close();
		});

		VBox layout = new VBox(10);

		//Add buttons
		layout.getChildren().addAll(label, yesButton, noButton);
		layout.setAlignment(Pos.CENTER);
		return layout;
		//Scene scene = new Scene(layout);
		//window.showAndWait();

		//Make sure to return answer
		//return answer;
	}

	public boolean isAnswer() {
		return this.answer;
	}
}