package code.items;

/**
 * Class for storing location of x and y scale
 */

public class Location {
	double locationX;
	double locationY;

	/**
	 * Constructor for locations for storing object x and y scale
	 * @param x The x value or the horizontal scale
	 * @param y The y value or the vertical scale
	 */
	public Location(double x, double y){
		this.locationX = x;
		this.locationY = y;
	}

	/**
	 * Getter for location of x value
	 * @return  x value of location
	 */
	public double getLocationX(){
		return this.locationX;
	}

	/**
	 * Getter for location of y value
	 * @return y value of location
	 */
	public double getLocationY() {
		return this.locationY;
	}

}
