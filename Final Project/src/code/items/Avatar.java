package code.items;

import interfaces.Constants;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;

import java.util.Scanner;

/**
 * Class for avatar which has variables:
 * health, score, image, location and name
 *
 */
public class Avatar implements Constants {
//Instance Variable
	private int health;
	private int score;
	private Location location;
	private ImageView image = new ImageView(
			new Image("images/walk.gif", objectWidth, objectHeight, true, true ));
	private String name;

//Constructors

	/**
	 * Constructor for initializing avatar
	 */
	public Avatar() {
		this.init();
	}

	/**
	 * Initializer for avatar:
	 * health,score, and location
	 */
	public void init(){
		this.health = avatarInitialHealth;
		this.score = avatarInitialScore;
		double avatarInitialLocationX = ((windowWidth - objectWidth) / 2);
		double avatarInitialLocationY = (windowHeight - objectWidth);
		this.location = new Location(avatarInitialLocationX, avatarInitialLocationY);
	}

//Methods

	/**
	 * Getter for avatar health
	 * @return  avatar health
	 */
	public int getHealth(){
		return this.health;
	}

	/**
	 * Getter for avatar score
	 * @return  avatar score
	 */
	public int getScore(){
		return this.score;
	}

	/**
	 * Getter for avatar location
	 * @see Location
	 * @return  avatar location
	 */
	public Location getLocation(){
		return this.location;
	}

	/**
	 * Method for updating avatar's health
	 * @param change    the amount of health being affected (eg. can be 1, or -1)
	 */
	public void updateHealth(int change){
		this.health = this.health + change;
	}

	/**
	 * Method for updating avatar's score
	 * @param change    the amount of score being affected
	 */
	public void updateScore(int change){
		this.score = this.score + change;
	}

	/**
	 * Getter for avatar image
	 * @return  avatar image
	 */
	public ImageView getImage() {

		return this.image;
	}

	/**
	 * Setter for avatar name
	 * @param s user's name
	 */
	public void setName(String s) {
		this.name = s;
	}

	/**
	 * Getter for avatar name
	 * @return  Users name
	 */
	public String getName() {
		return this.name;
	}
}
