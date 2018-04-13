package code.items;

import javafx.scene.image.ImageView;

/**
 * Class for Obstacles for the game
 * Essentially when the avatar gets in contact with any Obstacles it will lose health
 */
public class Obstacle {
	Location location;
	ImageView image;

	/**
	 * Getter for image of Obstacle
	 * @return Obstacle image
	 */
	public ImageView getImage() {
		return this.image;
	}


	/**
	 * Getter for location of Obstacle
	 * @return  location of Obstacle
	 */
	public Location getLocation() {
		return this.location;
	}
	
}

