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

	/**
	 * Returns the image to use through javaFx for the heart and token/coins
	 * @return returns the ImageView object from the heart/token depending on Collectible type.
	 */
	public ImageView getImage() {
		return this.image;
	}
	//public boolean isOverLap(){

	//}

	/**
	 * Checks if collectible image pixels overlaps avatar image.
	 * @param avatar used to find the location of the avatar.
	 * @return the value if objects overlap.
	 */
	public boolean overlapsWith(Avatar avatar) {
		if (avatar.location.getLocationX() == this.location.getLocationX() && avatar.location.getLocationY() == this.location.getLocationY()) {
			return true;
		} else {
			return false;
		}
	}

}
