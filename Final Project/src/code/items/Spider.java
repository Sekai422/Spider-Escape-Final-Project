package code.items;

import interfaces.Constants;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Subclass of Obstacles
 * Which is a spider that has -1 damage
 */
public class Spider extends Obstacle implements Constants {
	int damage = -1;


	/**
	 * Getter for Spider damage
	 * @return  Spider damage
	 */
	public int getDamage(){
		return this.damage;
	}

	/**
	 * Constructor for Spider
	 * It sets the spider images
	 */
	public Spider(){
		super();
		super.setImage(new ImageView(
				new Image("images/Spider.png",objectWidth, objectHeight, true, true )));
	}
}
