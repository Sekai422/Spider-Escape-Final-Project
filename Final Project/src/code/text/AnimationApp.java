package code.text;

import code.items.*;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class AnimationApp extends Application{

	private Avatar avatar;
	private ArrayList<Collectible> collectibles;
	private ArrayList<Obstacle> obstacles;

	@Override
	public void start(Stage primaryStage) throws Exception {

	}

	public void initialize() {
		this.avatar = new Avatar();
		this.obstacles = new ArrayList<>();
		this.collectibles = new ArrayList<>();
		int maxX = 3;
		int maxY = 5;
		int typeOfObstacles = 1;
		int typeOfCollectibles = 2;
		int maxObjects = maxX * maxY;
		Obstacle spider = new Spider();
		Collectible healthUp = new Heart();
		Collectible token = new Token();
		Random rand = new Random();
		int numberOfObstacles = rand.nextInt(maxObjects);
		int numberOfCollectibles = rand.nextInt(maxObjects - numberOfObstacles);
		Obstacle[] listOfObstacleTypes = new Obstacle[typeOfObstacles];
		listOfObstacleTypes[0] = spider;
		Collectible[] listOfCollectibleTypes = new Collectible[typeOfCollectibles];
		listOfCollectibleTypes[0] = healthUp;
		listOfCollectibleTypes[1] = token;

		ArrayList<Location> locations = new ArrayList<>();
		for (int i = 0; i < maxX; i++) {
			for (int j = 0; j < maxY; j++) {
				Location location = new Location(i, j);
				locations.add(location);
			}
		}

		Collections.shuffle(locations);

		for (int i = 0; i <= numberOfObstacles; i++) {
			int typeObstacles = rand.nextInt(typeOfObstacles);
			if (listOfObstacleTypes[typeObstacles] instanceof Spider) {
				Obstacle spider1 = new Spider();
				spider1.getLocation().setLocationX(locations.get(i).getLocationX());
				spider1.getLocation().setLocationY(locations.get(i).getLocationY());
				this.obstacles.add(spider1);
			}
		}

		for (int i = maxObjects-1; i > maxObjects - numberOfCollectibles; i--) {
			int typeCollectibles = rand.nextInt(typeOfCollectibles);
			if (listOfCollectibleTypes[typeCollectibles] instanceof Heart) {
				Collectible healthUp1 = new Heart();
				healthUp1.getLocation().setLocationX(locations.get(i).getLocationX());
				healthUp1.getLocation().setLocationY(locations.get(i).getLocationY());
				this.collectibles.add(healthUp1);
			}
			else if (listOfCollectibleTypes[typeCollectibles] instanceof Token) {
				Collectible token1 = new Token();
				token1.getLocation().setLocationX(locations.get(i).getLocationX());
				token1.getLocation().setLocationY(locations.get(i).getLocationY());
				this.collectibles.add(token1);
			}

		}
	}

	public void update(){
		int maxX = 3;
		int y = 4;
		int typeOfObstacles = 1;
		int typeOfCollectibles = 2;
		Obstacle spider = new Spider();
		Collectible healthUp = new Heart();
		Collectible token = new Token();
		Random rand = new Random();
		int numberOfObstacles = rand.nextInt(maxX+1);
		int numberOfCollectibles = rand.nextInt(maxX+1 - numberOfObstacles);
		Obstacle[] listOfObstacleTypes = new Obstacle[typeOfObstacles];
		listOfObstacleTypes[0] = spider;
		Collectible[] listOfCollectibleTypes = new Collectible[typeOfCollectibles];
		listOfCollectibleTypes[0] = healthUp;
		listOfCollectibleTypes[1] = token;

		ArrayList<Location> locations = new ArrayList<>();
		for (int i = 0; i < maxX; i++){
			Location location = new Location(i, y);
			locations.add(location);
		}

		Collections.shuffle(locations);

		for (int i = obstacles.size()-1; i >= 0 ;i--){
			obstacles.get(i).getLocation().setLocationY(obstacles.get(i).getLocation().getLocationY()-1);
			if (obstacles.get(i).getLocation().getLocationY() == -1){
				obstacles.remove(i);
			}
		}
		for (int i = collectibles.size()-1; i >= 0; i--){
			collectibles.get(i).getLocation().setLocationY(collectibles.get(i).getLocation().getLocationY()-1);
			if (collectibles.get(i).getLocation().getLocationY() == -1) {
				collectibles.remove(i);
			}
		}

		for (int i = 0; i < numberOfObstacles;i++) {
			int typeObstacles = rand.nextInt(typeOfObstacles);
			if (listOfObstacleTypes[typeObstacles] instanceof Spider) {
				Obstacle spider1 = new Spider();
				spider1.getLocation().setLocationX(locations.get(i).getLocationX());
				spider1.getLocation().setLocationY(locations.get(i).getLocationY());
				this.obstacles.add(spider1);
			}
		}

		for (int i = maxX-1;i > maxX - numberOfCollectibles; i--) {
			int typeCollectibles = rand.nextInt(typeOfCollectibles);
			if (listOfCollectibleTypes[typeCollectibles] instanceof Heart) {
				Collectible healthUp1 = new Heart();
				healthUp1.getLocation().setLocationX(locations.get(i).getLocationX());
				healthUp1.getLocation().setLocationY(locations.get(i).getLocationY());
				this.collectibles.add(healthUp1);
			}
			else if (listOfCollectibleTypes[typeCollectibles] instanceof Token) {
				Collectible token1 = new Token();
				token1.getLocation().setLocationX(locations.get(i).getLocationX());
				token1.getLocation().setLocationY(locations.get(i).getLocationY());
				this.collectibles.add(token1);
			}
		}

	}



		public void start(){
		initialize();

		System.out.println("Welcome to Spider-Escape!");
		System.out.println("The main goal of this game is to escape from the massive invasions of spiders");
		System.out.println("To avoid being attacked by the spiders. You need to maneuver left, right or stay");

		boolean play = true;
		while (play == true) {
			System.out.println("STATUS");
			System.out.println("-------" + "\n");
			System.out.println("Health: " + this.avatar.getHealth());
			System.out.println("Point: " + this.avatar.getScore() + "\n");
			/*for (int j = 0; j < this.obstacles.size(); j++) {
				System.out.println(this.obstacles.get(j).location.getX() +"\t"+ this.obstacles.get(j).location.getY());
			}

			System.out.println("obstacle size " + this.obstacles.size());

			for (int j = 0; j < this.collectibles.size(); j++) {
				System.out.println(this.collectibles.get(j).location.getX() +"\t"+ this.collectibles.get(j).location.getY());
			}

			System.out.println("collectible size " + this.collectibles.size());*/

			for (int i = 0; i < obstacles.size();i++){
				if (this.obstacles.get(i).getLocation().getLocationY() == this.avatar.getLocation().getLocationY() + 1) {
					if (this.obstacles.get(i).getLocation().getLocationX() == this.avatar.getLocation().getLocationX() - 1) {
						System.out.println("In the left there is a Spider");
					} else if (this.obstacles.get(i).getLocation().getLocationX() == this.avatar.getLocation().getLocationX()) {
						System.out.println("In the " + "front there is a Spider ");
					} else if (this.obstacles.get(i).getLocation().getLocationX() == this.avatar.getLocation().getLocationX() + 1) {
						System.out.println("In the right there is a Spider ");
					}
				}
			}
			for (int i = 0; i < this.collectibles.size();i++){
				if (this.collectibles.get(i).getLocation().getLocationY() == this.avatar.getLocation().getLocationY() + 1) {
					if (this.collectibles.get(i).getLocation().getLocationX() == this.avatar.getLocation().getLocationX() - 1) {
						System.out.println("In the left there is a  " + this.collectibles.get(i).getClass().getName());
					} else if (this.collectibles.get(i).getLocation().getLocationX() == this.avatar.getLocation().getLocationX()) {
						System.out.println("In the front there is a " + this.collectibles.get(i).getClass().getName());
					} else if (this.collectibles.get(i).getLocation().getLocationX() == this.avatar.getLocation().getLocationX() + 1) {
						System.out.println("In the right there is a " + this.collectibles.get(i).getClass().getName());
					}
				}
			}
			Scanner input = new Scanner(System.in);
			this.avatar.move(input);
			this.update();
			for (int i = 0; i < obstacles.size();i++){
				if (obstacles.get(i).overlapsWith(this.avatar) == true){
					this.avatar.updateHealth(((Spider) obstacles.get(i)).getDamage());
				}
			}
			for (int i = 0; i < collectibles.size();i++){
				if (collectibles.get(i).overlapsWith(this.avatar) == true){
					if (collectibles.get(i) instanceof Heart) {
						this.avatar.updateHealth(((Heart) collectibles.get(i)).getHealthUp());
					}
					else if
				(collectibles.get(i) instanceof Token) {
						this.avatar.updateScore(((Token) collectibles.get(i)).getScore());
					}
				}
			}
			if (this.avatar.getHealth() == 0) {
				System.out.println("GAME OVER");
				System.out.println("YOUR SCORE");
				System.out.println("----------" + "\n");
				System.out.println("Name" + " " + "Score");
				System.out.println(this.avatar.getName() + "\t\t" + this.avatar.getScore()+ "\n");
				boolean valid = false;
				while(valid == false) {
					System.out.print("Play Again? y/n ");
					String playAgain = input.next();
					if (playAgain.equals("y") ) {
						valid = true;
						start();
					}
					else if (playAgain.equals("n") ) {
						valid = true;
						play = false;
					} else {
						System.out.println("not the command instructed");
					}
				}
			}

		}
	}


	public AnimationApp(){

	}


	public static void main(String[] args){
		AnimationApp animationApp = new AnimationApp();
		animationApp.start();
	}
}
