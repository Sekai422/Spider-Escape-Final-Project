package code.items;

import interfaces.Constants;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Token extends Collectible implements Constants {
	int score = 1;

	public Token (){
		this.image = new ImageView(
				new Image("images/TokenImage1.png",objectWidth, objectHeight, true, true ));
	}

	public int getScore(){
		return this.score;
	}

}
