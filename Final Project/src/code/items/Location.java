package code.items;

public class Location {
	double locationX;
	double locationY;

	public Location(double x, double y){
		this.locationX = x;
		this.locationY = y;
	}

	public double getLocationX(){
		return this.locationX;
	}

	public double getLocationY() {
		return this.locationY;
	}

	public void setLocationX(double locationX) {
		this.locationX = locationX;
	}

	public void setLocationY(double locationY) {
		this.locationY = locationY;
	}

}
