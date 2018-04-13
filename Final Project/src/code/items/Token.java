package code.items;

import interfaces.Constants;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * SubClass of Collectibles
 * When avatar collects the token each time it will gain 1 score
 */
public class Token extends Collectible implements Constants {
	int score = 1;

	/**
	 * Constructor for Token
	 * It sets the token image to it
	 */
	public Token (){
		this.image = new ImageView(
				new Image("images/TokenImage1.png",objectWidth, objectHeight, true, true ));
	}

	/**
	 * Getter for token score
	 * @return  amount score of token
	 */
	public int getScore(){
		return this.score;
	}

}
