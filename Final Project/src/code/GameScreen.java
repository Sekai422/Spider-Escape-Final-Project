package code;

import gui_version.interfaces.Constants;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Random;

public class GameScreen implements Constants {
	Scene scene;
	Label health;
	Label score;
	Label gameOver;
	VBox healthLayout;
	VBox scoreLayout;
	Pane gameLayout;
	BorderPane baseLayout;
	int maxObstacleAmount;
	ArrayList typeClass = new ArrayList();
	ArrayListLocations arrayListLocations = new ArrayListLocations();
	ArrayList locations = arrayListLocations.getLocations();
	Avatar avatar = new Avatar();
	Random rand = new Random();
	TimeController timeController = new TimeController(this, avatar);
	KeyController keyController = new KeyController();
	PauseMenu pauseMenu = new PauseMenu();
	FileController fileController = new FileController();
	NameController nameController = new NameController();

	public PauseMenu getPauseMenu() {
		return this.pauseMenu;
	}

	public void init(){
		this.gameLayout = new Pane();
		this.baseLayout = new BorderPane();
		this.health = new Label("Health: " + avatar.getHealth());
		this.healthLayout = new VBox();
		this.score = new Label("Score: " + avatar.getScore());
		this.scoreLayout = new VBox();
		this.gameOver = new Label("Game Over");
		this.scene = new Scene(this.getBaseLayout());
	}

	//Constructor
	public GameScreen(){
		this.init();
		this.setGameScreen();
	}

//Initialize method
	public void setGameScreen() {
		this.setHealth();
		this.setHealthLayout();
		this.setScore();
		this.setScoreLayout();
		this.setGameOver();
		this.setGameLayout();
		this.setAvatarImage();
		this.getArrayListLocations().shuffleLocations();
		this.setBaseLayout();
		this.setScene();
	}

//Game Layout
	public Pane getGameLayout() {
		return this.gameLayout;
	}

	public void setGameLayout() {
		this.gameLayout.setStyle("-fx-background-color: gray;");
		this.gameLayout.setPrefWidth(windowWidth);
		this.gameLayout.setPrefHeight(windowHeight);
	}

//Base Layout
	public BorderPane getBaseLayout() {
		return this.baseLayout;
	}

	public void setBaseLayout(){
		this.baseLayout.setRight(this.getHealthLayout());
		this.baseLayout.setLeft(this.getScoreLayout());
		this.baseLayout.setCenter(this.getGameLayout());
	}

//Health
	public Label getHealth() {
		return this.health;
	}

	public VBox getHealthLayout() {
		return this.healthLayout;
	}

	public void setHealth() {
		this.health.setFont(new Font("Helvetica Neut Bold", 15));
	}

	public void setHealthLayout() {
		this.healthLayout.getChildren().add(this.getHealth());
	}

//Score
	public Label getScore() {
		return this.score;
	}

	public VBox getScoreLayout() {
		return this.scoreLayout;
	}

	public void setScore() {
		this.score.setFont(new Font("Helvetica Neut Bold", 15));
	}

	public void setScoreLayout(){
		this.scoreLayout.getChildren().add(this.getScore());
	}

//Game Over
	public Label getGameOver() {
		return this.gameOver;
	}

	public void setGameOver(){
		this.gameOver.setFont((new Font("Helvetica Neut Bold", 50)));
	}

	//Scene
	public Scene getScene() {
		return this.scene;
	}
	public void setScene() {
		this.keyController.keyEventHandler(avatar, this);
		this.timeController.init(this, this.avatar);
		this.timeController.startTime();

	}

//Images
	public void setAvatarImage(){
		avatar.getImage().setX(avatar.getLocation().getLocationX());
		avatar.getImage().setY(avatar.getLocation().getLocationY());
		this.getGameLayout().getChildren().add(avatar.getImage());
	}

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
			    this.typeClass.add(spider);
		    }
		 }
	}

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
				heart.getImage().setOpacity(opacity);
				this.getGameLayout().getChildren().add(heart.getImage());
				this.typeClass.add(heart);
			}
			else if (type == 1){
				Collectible token = new Token();
				token.getImage().setX(((Location)this.locations.get(i)).getLocationX());
				token.getImage().setY(((Location)this.locations.get(i)).getLocationY());
				token.getImage().setCache(true);
				token.getImage().setOpacity(opacity);
				this.getGameLayout().getChildren().add(token.getImage());
				this.typeClass.add(token);
			}
		}
	}

//EventHandlers

	public TimeController getTimeController() {
		return this.timeController;
	}

	public ArrayList getTypeClass(){
		return this.typeClass;
	}

	public ArrayListLocations getArrayListLocations() {
		return this.arrayListLocations;
	}

	public void restart(){
		this.avatar.init();
		this.typeClass.clear();
		this.gameLayout.getChildren().clear();
		this.setAvatarImage();
		this.getHealth().setText("Health: " + avatar.getHealth());
		this.getScore().setText("Score: " + avatar.getScore());
		this.getTimeController().startTime();
	}

	public FileController getFileController() {
		return this.fileController;
	}

	public NameController getNameController() {
		return this.nameController;
	}
}
