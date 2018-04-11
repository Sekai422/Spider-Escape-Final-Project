package code;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Heart extends Collectible {
	int healthUp = 1;

	public Heart() {
		this.image = new ImageView(new Image("images/heart.png", 50, 50, true, true));
	}

	public int getHealthUp(){
		return this.healthUp;
	}

	public ImageView getImage() {
		return this.image;
	}
}
