package code.items;

import javafx.scene.image.ImageView;

/**
 * Class for Obstacles for the game
 * Essentially when the avatar gets in contact with any Obstacles it will lose health
 */
public class Obstacle {
	private Location location;
	private ImageView image;

	/**
	 * Getter for image of Obstacle
	 * @return Obstacle image
	 */
	public ImageView getImage() {
		return this.image;
	}

	/**
	 * Setter for setting the image for Obstacle subclasses
	 * @param image The image that is set
	 */
	public void setImage(ImageView image){
		this.image = image;
	}


	/**
	 * Getter for location of Obstacle
	 * @return  location of Obstacle
	 */
	public Location getLocation() {
		return this.location;
	}

}

