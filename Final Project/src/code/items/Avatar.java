package code.items;

import gui_version.interfaces.Constants;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;

import java.util.Scanner;

public class Avatar implements Constants {
//Instance Variable
	int health;
	int score;
	Location location;
	ImageView image = new ImageView(
			new Image("images/Avatar.png", objectWidth, objectHeight, true, true ));
	String name;

	//Constructors
	public Avatar() {
		this.init();
	}

	public void init(){
		this.health = avatarInitialHealth;
		this.score = avatarInitialScore;
		double avatarInitialLocationX = ((windowWidth - objectWidth) / 2);
		double avatarInitialLocationY = (windowHeight - objectWidth);
		this.location = new Location(avatarInitialLocationX, avatarInitialLocationY);
	}

//Methods
	public int getHealth(){
		return this.health;
	}

	public int getScore(){
		return this.score;
	}

	public Location getLocation(){
		return this.location;
	}

	public void updateHealth(int change){
		this.health = this.health + change;
	}

	public void updateScore(int change){
		this.score = this.score + change;
	}

	public void setLocation(){

	}

	public ImageView getImage() {

		return this.image;
	}
	
	public void move( Scanner input){
		boolean valid = false;
		while (valid == false){
			System.out.print("Which way will you go? left, right or stay  ");
			String move = input.next();
			if (move.equals("right")){
				if (this.location.getLocationX() != 2){
					this.location.setLocationX(this.location.getLocationX() + 1);
					valid = true;
				}
				else{
					System.out.println("out of bounds! Cannot move right");
				}
			}
			else if (move.equals("left")){
				if (this.location.getLocationX() != 0){
					this.location.setLocationX(this.location.getLocationX() - 1);
					valid = true;
				}
				else{
					System.out.println("out of bounds! Cannot move left");
				}
			}

			else if (move.equals("stay")){
				valid = true;
			}

			else{
				System.out.println("Not the commands instructed. Please enter right, left or stay");
			}
		}
	}


	public void setName(String s) {
		this.name = s;
	}

	public String getName() {
		return this.name;
	}
}
