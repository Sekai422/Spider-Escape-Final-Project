package code.Gui;

import code.controllers.*;
import code.items.Location;
import code.items.*;
import interfaces.Constants;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class sets up the game screen when it is created
 * and it will be displayed when the display method is called
 *
 * Once displayed the game starts
 */

public class GameScreen implements Constants {
	//Instance Variable

	//Set up for the game screen layout
	private Label health;
	private Label score;
	private Label gameOver;
	private VBox healthLayout;
	private VBox scoreLayout;
	private Pane gameLayout;
	private BorderPane baseLayout;
	private Scene scene;

	//Controllers
	private SoundController soundController = new SoundController();
	private LocationController locationController = new LocationController();
	private ArrayList locations = locationController.getLocations();
	private TimeController timeController = new TimeController(this, this.avatar);
	private KeyController keyController = new KeyController();
	private FileController fileController = new FileController();
	private NameController nameController = new NameController();

	//creates avatar object
	private Avatar avatar = new Avatar();

	//Used for generating random amounts of Obstacles and Collectibles
	private Random rand = new Random();

	//To store Obstacle amount so that there would be no overlap for Collectible amount
	private int maxObstacleAmount;

	//Used for storing Obstacles and Collectibles created
	private ArrayList typeClass = new ArrayList();

	//Used to generate the pause menu
	private PauseMenu pauseMenu = new PauseMenu();

	//Used for background image of game
	private  BackgroundImage myBI= new BackgroundImage(
			new Image("images/background.gif",
					600,
					700,
					false,
					true),
            BackgroundRepeat.REPEAT,
			BackgroundRepeat.NO_REPEAT,
			BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT);

	/**
	 * This Constructor calls the initialize method
	 */
	public GameScreen(){
		this.init();
	}

	/**
	 * This method initializes the Game Screen Layout and all settings
	 */
	public void init(){
		this.initHealth();
		this.initHealthLayout();
		this.initScore();
		this.initScoreLayout();
		this.initGameOver();
		this.initGameLayout();
		this.setAvatarImage();
		this.getLocationController().shuffleLocations();
		this.initBaseLayout();
	}

//Health Layout

	/**
	 * Initializer for health label
	 */
	public void initHealth() {
		this.health = new Label("Health: " + avatar.getHealth());
		this.health.setFont(new Font("Helvetica Neut Bold", 15));
	}

	/**
	 * Getter for health label
	 * @return  Label for health
	 */
	public Label getHealth() {
		return this.health;
	}

	/**
	 * Initializer for health layout
	 */
	public void initHealthLayout() {
		this.healthLayout = new VBox();
		this.healthLayout.getChildren().add(this.getHealth());
	}

	/**
	 * Getter for health layout
	 * @return  VBox of health layout
	 */
	public VBox getHealthLayout() {
		return this.healthLayout;
	}

//Score Layout

	/**
	 * Initializer for score label
	 */
	public void initScore() {
		this.score = new Label("Score: " + avatar.getScore());
		this.score.setFont(new Font("Helvetica Neut Bold", 15));
	}

	/**
	 * Getter for score label
	 * @return label for score
	 */
	public Label getScore() {
		return this.score;
	}

	/**
	 * Initializer for score layout
	 */
	public void initScoreLayout(){
		this.scoreLayout = new VBox();
		this.scoreLayout.getChildren().add(this.getScore());
	}

	/**
	 * Getter for score layout
	 * @return  VBox of score layout
	 */
	public VBox getScoreLayout() {
		return this.scoreLayout;
	}

//Game Over Layout

	/**
	 * Getter for game over label
	 * @return  Label of game over
	 */
	public Label getGameOver() {
		return this.gameOver;
	}

	/**
	 *Initializer for game over label
	 */
	public void initGameOver(){
		this.gameOver = new Label("Game Over");
		this.gameOver.setFont((new Font("Helvetica Neut Bold", 50)));
	}

//Game Layout

	/**
	 * Initializer for game layout which is the screen where the game takes place
	 */
	public void initGameLayout() {
		this.gameLayout = new Pane();
		this.gameLayout.setBackground(new Background(myBI));
		this.gameLayout.setPrefWidth(windowWidth);
		this.gameLayout.setPrefHeight(windowHeight);
	}

	/**
	 * Getter for game layout screen
	 * @return  Pane of game layout
	 */
	public Pane getGameLayout() {
		return this.gameLayout;
	}

//Base Layout

	/**
	 * Initializer for the base layout which is the entire screen of the game window
	 */
	public void initBaseLayout(){
		this.baseLayout = new BorderPane();
		this.baseLayout.setRight(this.getHealthLayout());
		this.baseLayout.setLeft(this.getScoreLayout());
		this.baseLayout.setCenter(this.getGameLayout());
	}

	/**
	 * Getter for base layout
	 * @return  BorderPane of base layout
	 */
	public BorderPane getBaseLayout() {
		return this.baseLayout;
	}

//Scene

	/**
	 * Initializer for the scene of the game screen
	 */
	public void initScene() {
		this.scene = new Scene(this.getBaseLayout());
		this.keyController.keyEventHandler(avatar, this);
		this.timeController.init(this, this.avatar);
	}

	/**
	 * Getter for scene of game screen
	 * @return  Scene of game screen
	 */
	public Scene getScene() {
		return this.scene;
	}

//Images

	/**
	 * This method sets the avatar image into the game layout screen
	 * to the center bottom of the screen
	 */
	public void setAvatarImage(){
		avatar.getImage().setX(avatar.getLocation().getLocationX());
		avatar.getImage().setY(avatar.getLocation().getLocationY());
		this.getGameLayout().getChildren().add(avatar.getImage());
	}

	/**
	 * This method creates and sets the Obstacle images of random numbers for one row.
	 * It is generated offscreen of top of the game screen
	 * And also stores object created to ArrayList typeClass
	 * Also it will generate at least one Obstacle every time it is called
	 */
	public void setObstaclesImage(){
		 this.maxObstacleAmount = rand.nextInt(column - 1) + 1;
		 for (int i = 0; i < this.maxObstacleAmount;i++){
		 	int type = rand.nextInt(1);
		 	if (type == 0){
		 		Obstacle spider = new Spider();
		 		spider.getImage().setX(((Location)this.locations.get(i)).getLocationX());
			    spider.getImage().setY(((Location)this.locations.get(i)).getLocationY());
			    spider.getImage().setCache(true);
			    this.getGameLayout().getChildren().add(spider.getImage());
			    this.getTypeClass().add(spider);
		    }
		 }
	}

	/**
	 *This method creates and sets the Collectibles images of random numbers for one row.
	 * It is generated offscreen of top of the game screen
	 * And also stores object created to ArrayList typeClass
	 * It is made sure that the number of Collectibles generated will not result in overlapping between Obstacles
	 *
	 */
	public void setCollectiblesImage(){
		int bound = column - this.maxObstacleAmount;
		int maxCollectibleAmount = rand.nextInt(bound);
		for (int i = column - 1; i > column - 1 - maxCollectibleAmount; i--){
			int type = rand.nextInt(2);
			if (type == 0){
				Collectible heart = new Heart();
				heart.getImage().setX(((Location)this.locations.get(i)).getLocationX());
				heart.getImage().setY(((Location)this.locations.get(i)).getLocationY());
				heart.getImage().setCache(true);
				this.getGameLayout().getChildren().add(heart.getImage());
				this.getTypeClass().add(heart);
			}
			else if (type == 1){
				Collectible token = new Token();
				token.getImage().setX(((Location)this.locations.get(i)).getLocationX());
				token.getImage().setY(((Location)this.locations.get(i)).getLocationY());
				token.getImage().setCache(true);
				this.getGameLayout().getChildren().add(token.getImage());
				this.typeClass.add(token);
			}
		}
	}

//Controllers

	/**
	 * Getter for TimeController
	 * @see TimeController
	 * @return TimeController timeController
	 */
	public TimeController getTimeController() {
		return this.timeController;
	}

	/**
	 * Getter for LocationController
	 * @see LocationController
	 * @return LocationController locationController
	 */
	public LocationController getLocationController() {
		return this.locationController;
	}

	/**
	 * Getter for ArrayList TypeClass
	 * @return  ArrayList TypeClass
	 */
	public ArrayList getTypeClass(){
		return this.typeClass;
	}

	/**
	 * Getter for FileController
	 * @see NameController
	 * @return  FileController fileController
	 */
	public FileController getFileController() {
		return this.fileController;
	}

	/**
	 * Getter for NameController
	 * @see NameController
	 * @return  NameController nameController
	 */
	public NameController getNameController() {
		return this.nameController;
	}

	/**
	 * Getter for SoundController
	 * @see SoundController
	 * @return  SoundController soundController
	 */
	public SoundController getSoundController(){
		return this.soundController;
	}

	/**
	 * When this method is called the game screen window will pop up and start the game
	 */
	public void display(){
		Stage window = new Stage();
		this.initScene();
		window.setScene(this.getScene());
		window.show();
		this.getTimeController().startTime();
		this.getTimeController().stopTime();
		this.getTimeController().startTime();
		this.soundController.playMusic();
	}

	/**
	 * This method is for restarting the game
	 * Once called the game will restart as fresh
	 */
	public void restart(){
		this.avatar.init();
		this.typeClass.clear();
		this.gameLayout.getChildren().clear();
		this.setAvatarImage();
		this.getHealth().setText("Health: " + avatar.getHealth());
		this.getScore().setText("Score: " + avatar.getScore());
		this.getTimeController().startTime();
		this.getSoundController().playMusic();
	}

	/**
	 * Getter for avatar
	 * @return  Avatar avatar
	 */

	public Avatar getAvatar (){
		return this.avatar;
	}

	/**
	 * This returns the pause menu
	 * @return The pause menu
	 */
	public PauseMenu getPauseMenu() {
		return this.pauseMenu;
	}


}
