package code.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * This Class is for running the Text based version of the game
 *
 * Since it is a text based game it will be a turn based game
 */
public class AnimationApp {

	private Avatar avatar;
	private ArrayList<Collectible> collectibles;
	private ArrayList<Obstacle> obstacles;

	/**
	 * Initializer for the AnimationApp
	 */
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
		Collectible healthUp = new HealthUp();
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
				spider1.location.setX(locations.get(i).getLocationX());
				spider1.location.setY(locations.get(i).getLocationY());
				this.obstacles.add(spider1);
			}
		}

		for (int i = maxObjects-1; i > maxObjects - numberOfCollectibles; i--) {
			int typeCollectibles = rand.nextInt(typeOfCollectibles);
			if (listOfCollectibleTypes[typeCollectibles] instanceof HealthUp) {
				Collectible healthUp1 = new HealthUp();
				healthUp1.location.setX(locations.get(i).getLocationX());
				healthUp1.location.setY(locations.get(i).getLocationY());
				this.collectibles.add(healthUp1);
			}
			else if (listOfCollectibleTypes[typeCollectibles] instanceof Token) {
				Collectible token1 = new Token();
				token1.location.setX(locations.get(i).getLocationX());
				token1.location.setY(locations.get(i).getLocationY());
				this.collectibles.add(token1);
			}

		}
	}

	/**
	 * Generates new Obstacles and Collectibles
	 */
	public void update(){
		int maxX = 3;
		int y = 4;
		int typeOfObstacles = 1;
		int typeOfCollectibles = 2;
		Obstacle spider = new Spider();
		Collectible healthUp = new HealthUp();
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
			obstacles.get(i).location.setY(obstacles.get(i).location.getY()-1);
			if (obstacles.get(i).location.getY() == -1){
				obstacles.remove(i);
			}
		}
		for (int i = collectibles.size()-1; i >= 0; i--){
			collectibles.get(i).location.setY(collectibles.get(i).location.getY()-1);
			if (collectibles.get(i).location.getY() == -1) {
				collectibles.remove(i);
			}
		}

		for (int i = 0; i < numberOfObstacles;i++) {
			int typeObstacles = rand.nextInt(typeOfObstacles);
			if (listOfObstacleTypes[typeObstacles] instanceof Spider) {
				Obstacle spider1 = new Spider();
				spider1.location.setX(locations.get(i).getLocationX());
				spider1.location.setY(locations.get(i).getLocationY());
				this.obstacles.add(spider1);
			}
		}

		for (int i = maxX-1;i > maxX - numberOfCollectibles; i--) {
			int typeCollectibles = rand.nextInt(typeOfCollectibles);
			if (listOfCollectibleTypes[typeCollectibles] instanceof HealthUp) {
				Collectible healthUp1 = new HealthUp();
				healthUp1.location.setX(locations.get(i).getLocationX());
				healthUp1.location.setY(locations.get(i).getLocationY());
				this.collectibles.add(healthUp1);
			}
			else if (listOfCollectibleTypes[typeCollectibles] instanceof Token) {
				Collectible token1 = new Token();
				token1.location.setX(locations.get(i).getLocationX());
				token1.location.setY(locations.get(i).getLocationY());
				this.collectibles.add(token1);
			}
		}

	}


	/**
	 * Start method which starts the text version of the game
	 */
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
			System.out.println("Point: " + this.avatar.getPoint() + "\n");
			/*for (int j = 0; j < this.obstacles.size(); j++) {
				System.out.println(this.obstacles.get(j).location.getX() +"\t"+ this.obstacles.get(j).location.getY());
			}

			System.out.println("obstacle size " + this.obstacles.size());

			for (int j = 0; j < this.collectibles.size(); j++) {
				System.out.println(this.collectibles.get(j).location.getX() +"\t"+ this.collectibles.get(j).location.getY());
			}

			System.out.println("collectible size " + this.collectibles.size());*/

			for (int i = 0; i < obstacles.size();i++){
				if (this.obstacles.get(i).location.getY() == this.avatar.location.getY() + 1) {
					if (this.obstacles.get(i).location.getX() == this.avatar.location.getX() - 1) {
						System.out.println("In the left there is a Spider");
					} else if (this.obstacles.get(i).location.getX() == this.avatar.location.getX()) {
						System.out.println("In the front there is a Spider ");
					} else if (this.obstacles.get(i).location.getX() == this.avatar.location.getX() + 1) {
						System.out.println("In the right there is a Spider ");
					}
				}
			}
			for (int i = 0; i < this.collectibles.size();i++){
				if (this.collectibles.get(i).location.getY() == this.avatar.location.getY() + 1) {
					if (this.collectibles.get(i).location.getX() == this.avatar.location.getX() - 1) {
						System.out.println("In the left there is a  " + this.collectibles.get(i).getClass().getName());
					} else if (this.collectibles.get(i).location.getX() == this.avatar.location.getX()) {
						System.out.println("In the front there is a " + this.collectibles.get(i).getClass().getName());
					} else if (this.collectibles.get(i).location.getX() == this.avatar.location.getX() + 1) {
						System.out.println("In the right there is a " + this.collectibles.get(i).getClass().getName());
					}
				}
			}
			Scanner input = new Scanner(System.in);
			this.avatar.move(input);
			this.update();
			for (int i = 0; i < obstacles.size();i++){
				if (obstacles.get(i).overlapsWith(this.avatar) == true){
					this.avatar.updateHealth(obstacles.get(i).damage);
				}
			}
			for (int i = 0; i < collectibles.size();i++){
				if (collectibles.get(i).overlapsWith(this.avatar) == true){
					if (collectibles.get(i) instanceof HealthUp) {
						this.avatar.updateHealth(((HealthUp) collectibles.get(i)).healthUp);
					}
					else if (collectibles.get(i) instanceof Token) {
						this.avatar.updatePoint(((Token) collectibles.get(i)).point);
					}
				}
			}
			if (this.avatar.getHealth() == 0) {
				System.out.println("GAME OVER");
				System.out.println("YOUR SCORE");
				System.out.println("----------" + "\n");
				System.out.println("Name" + " " + "Score");
				System.out.println(this.avatar.getName() + "\t\t" + this.avatar.getPoint()+ "\n");
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

}
