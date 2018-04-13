package code.controllers;

import code.items.Location;
import interfaces.Constants;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class stores all the possible locations where Obstacles and Collectibles can be in the first row
 */
public class LocationController implements Constants {
	ArrayList locations;

	/**
	 * This Constructor calls the makeLocations method and creates and fills the ArrayList locations.
	 */
	public LocationController(){
		makeLocations();
	}

	/**
	 * This method returns the ArrayList called locations
	 * @return locations an ArrayList
	 */
	public ArrayList getLocations() {
		return this.locations;
	}

	/**
	 * This method calculates all the possible locations of the first row where the Obstacles and Collectibles can be
	 * and stores it in an ArrayList called locations.
	 */
	public void makeLocations(){
		this.locations = new ArrayList();
		for (double i = ((windowWidth/column) - objectWidth) / 2; i < windowWidth;i+=windowWidth/column){
			Location location = new Location(i, -objectWidth);
			this.locations.add(location);
		}
		/*for (int i = 0;i < this.locations.size();i++)
		System.out.println(((Location)this.locations.get(i)).getLocationX() + "," + ((Location)this.locations.get(i)).getLocationY());
	*/}

	/**
	 * This method mixes the arrangement of the ArrayList inside
	 */
	public void shuffleLocations() {
		Collections.shuffle(this.locations);
	}
}
