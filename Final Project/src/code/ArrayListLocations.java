package code;

import gui_version.interfaces.Constants;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListLocations implements Constants {
	ArrayList locations;

	public ArrayListLocations(){
		makeLocations();
	}

	public ArrayList getLocations() {
		return this.locations;
	}

	public void makeLocations(){
		this.locations = new ArrayList();
		for (double i = ((windowWidth/column) - objectWidth) / 2; i < windowWidth;i+=windowWidth/column){
			Location location = new Location(i, -objectWidth);
			this.locations.add(location);
		}
		/*for (int i = 0;i < this.locations.size();i++)
		System.out.println(((Location)this.locations.get(i)).getLocationX() + "," + ((Location)this.locations.get(i)).getLocationY());
	*/}

	public void shuffleLocations() {
		Collections.shuffle(this.locations);
	}
}
