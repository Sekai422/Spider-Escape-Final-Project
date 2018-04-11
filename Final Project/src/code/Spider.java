package code;

import gui_version.interfaces.Constants;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Spider extends Obstacle implements Constants {
	int damage = -1;


	public int getDamage(){
		return this.damage;
	}

	public Spider(){
		super();
		this.image = new ImageView(
				new Image("images/Spider.png",objectWidth, objectHeight, true, true ));
	}
}
