package code.text;

import javafx.scene.shape.Rectangle;

import java.util.Scanner;

public class Avatar {
	String name;
	int health;
	Rectangle location;
	int point;

	public int getHealth(){
		return this.health;
	}

	public int getPoint(){
		return this.point;
	}

	public String getName(){
		return this.name;
	}
	public void move( Scanner input){
		boolean valid = false;
		while (valid == false){
			System.out.print("Which way will you go? left, right or stay  ");
			String move = input.next();
			if (move.equals("right")){
				if (this.location.getX() != 2){
					this.location.setX(this.location.getX() + 1);
					valid = true;
				}
				else{
					System.out.println("out of bounds! Cannot move right");
				}
			}
			else if (move.equals("left")){
				if (this.location.getX() != 0){
					this.location.setX(this.location.getX() - 1);
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


	public void updateHealth(int change) {
		if (change == -1){
			System.out.println("You got hit by a Spider!");
		}
		else if (change == 1){
			System.out.println("You got a health up!");
		}
		this.health = this.health + change;
	}

	public void updatePoint (int change){
		System.out.println("You got a Token!");
		this.point = this.point + change;
	}

	public Avatar(){
		location = new Rectangle();
		this.location.setX(1);
		this.location.setY(0);
		this.health = 3;
		this.point = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = input.next();
		this.name = name;
	}
}
