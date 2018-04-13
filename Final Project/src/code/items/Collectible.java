package code.items;

import javafx.scene.image.ImageView;

public class Collectible {
	Location location;
	ImageView image;

	//Method
	public Location getLocation() {
		return this.location;
	}

	public void updateLocation(){

	}

	public ImageView getImage() {
		return this.image;
	}
	//public boolean isOverLap(){

	//}

	public boolean overlapsWith(Avatar avatar) {
		if (avatar.location.getLocationX() == this.location.getLocationX() && avatar.location.getLocationY() == this.location.getLocationY()) {
			return true;
		} else {
			return false;
		}
	}

}
