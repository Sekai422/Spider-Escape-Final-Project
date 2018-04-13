package code.items;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * SubClass of Collectible which is a item in the game
 * where the avatar will gain one health when the avatar gets it
 */
public class Heart extends Collectible {
	int healthUp = 1;

	/**
	 * sets the image view
	 */
	public Heart() {
		this.image = new ImageView(new Image("images/heart.png", 50, 50, true, true));
	}

	/**
	 * Getter for healthUp
	 * @return healthUp
	 */
	public int getHealthUp(){
		return this.healthUp;
	}

	/**
	 * Getter for image view of heart
	 * @return  ImageView of heart
	 */
	public ImageView getImage() {
		return this.image;
	}
}
