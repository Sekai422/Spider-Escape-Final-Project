package code;

import javafx.scene.image.ImageView;

public class Obstacle {
	Location location;
	ImageView image;

	public Obstacle(){

	}

	public ImageView getImage() {
		return this.image;
	}

	//Method
	public Location getLocation() {
		return this.location;
	}

	public void setLocation(double x, double y){
		this.location = new Location(x, y);
	}

	public void updateLocation(){

	}

	//public boolean isOverLap(){

	//}

}

