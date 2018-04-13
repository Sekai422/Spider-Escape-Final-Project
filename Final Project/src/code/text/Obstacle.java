package code.text;

import javafx.scene.shape.Rectangle;

public class Obstacle {

	int damage;
	Rectangle location;

	public boolean overlapsWith(Avatar avatar){
		if (avatar.location.getX() == this.location.getX() && avatar.location.getY() == this.location.getY()){
			return true;
		}
		else{
			return false;
		}
	}

	public Obstacle(){
		this.location = new Rectangle();
	}

}
