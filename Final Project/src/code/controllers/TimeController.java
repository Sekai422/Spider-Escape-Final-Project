package code.controllers;

import code.Gui.GameScreen;
import code.items.Avatar;
import code.items.Heart;
import code.items.Spider;
import code.items.Token;
import interfaces.Constants;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * This class controls the actions every time a specific time passes
 *
 * It will generate new Obstacles and Collectibles
 * It will move all Obstacles and Collectibles by one pixels down
 * It will speed up all the Obstacles and Collectibles moving down
 * It will update avatar's health and score each time it hits Obstacles and/or Collectibles
 * It will remove Obstacles and Collectibles that are offscreen
 */

public class TimeController implements Constants {
	SoundController soundController = new SoundController();
	Timeline timer;
	KeyFrame frame;
	double distance = 0;
	double addDistance = 1;

	/**
	 * This constructor initializes the TimeController
	 *
	 * @param gameScreen The game screen that is being played
	 * @param avatar     The avatar that is in the game screen
	 */
	public TimeController(GameScreen gameScreen, Avatar avatar){
		init(gameScreen, avatar);
	}

	/**
	 * This method sets and initializes the timeline settings
	 * @param gameScreen    The game screen that is being played
	 * @param avatar        The avatar that is in the game screen
	 */
	public void init(GameScreen gameScreen, Avatar avatar){
		this.timer = new Timeline(this.frame = new KeyFrame(
				Duration.millis(duration),
				event -> {
					this.update(gameScreen);
					this.collision(gameScreen, avatar);
				}));
	}

	/**
	 * This method updates the speed of the Obstacles and the Collectibles moving down
	 * @param gameScreen        The game screen that is being played
	 */
	public void update(GameScreen gameScreen){
		this.distance = this.distance + 1;
		if (distance >= ((windowHeight - objectHeight) / row)) {
			gameScreen.getLocationController().shuffleLocations();
			gameScreen.setObstaclesImage();
			gameScreen.setCollectiblesImage();
			this.distance = 0;
			this.addDistance = this.addDistance + speed;
		}
	}

	/**
	 * This method checks for collision between the avatar and Collectibles and Obstacles.
	 * It also updates the avatars score and health.
	 * @param gameScreen    The game screen that is being played
	 * @param avatar        The avatar that is in the game screen
	 */
	public void collision (GameScreen gameScreen, Avatar avatar){
		for (int i = gameScreen.getGameLayout().getChildren().size() - 1; i > 0; i--) {
			if (gameScreen.getGameLayout().getChildren().get(i) instanceof ImageView) {
				((ImageView) gameScreen.getGameLayout().getChildren().get(i)).setY(
						((ImageView) gameScreen.getGameLayout().getChildren().get(i)).getY() + this.addDistance);
				if (gameScreen.getGameLayout().getChildren().get(i).getBoundsInParent().intersects(avatar.getImage().getBoundsInParent())) {
					if (gameScreen.getTypeClass().get(i - 1) instanceof Spider) {
						soundController.playMedia(soundController.damageSound);
						avatar.updateHealth(((Spider) gameScreen.getTypeClass().get(i - 1)).getDamage());
						gameScreen.getHealth().setText("Health: " + avatar.getHealth());
						this.gameOver(gameScreen, avatar);

					} else if (gameScreen.getTypeClass().get(i - 1) instanceof Heart) {
						soundController.playMedia(soundController.healthSound);
						avatar.updateHealth(((Heart) gameScreen.getTypeClass().get(i - 1)).getHealthUp());
						gameScreen.getHealth().setText("Health: " + avatar.getHealth());
						this.gameOver(gameScreen, avatar);

					} else if (gameScreen.getTypeClass().get(i - 1) instanceof Token) {
						soundController.playMedia(soundController.coinSound);
						avatar.updateScore(((Token) gameScreen.getTypeClass().get(i - 1)).getScore());
						gameScreen.getScore().setText("Score: " + avatar.getScore());

					}
					gameScreen.getGameLayout().getChildren().remove(i);
					gameScreen.getTypeClass().remove(i - 1);
				}
			}
			if (((ImageView) gameScreen.getGameLayout().getChildren().get(i)).getY() >= windowHeight) {
				gameScreen.getGameLayout().getChildren().remove(i);
				gameScreen.getTypeClass().remove(i - 1);
			}
		}
	}

	/**
	 * This method invokes when the avatar's health hits zero
	 *
	 * This will display the game over screen ending the game
	 * @param gameScreen    The game screen that is being played
	 * @param avatar        The avatar that is in the game screen
	 */
	public void gameOver(GameScreen gameScreen, Avatar avatar){
		if (avatar.getHealth() == 0) {
			this.stopTime();
			gameScreen.setGameOver();
			gameScreen.getBaseLayout().setCenter(gameScreen.getGameOver());
			gameScreen.getNameController().display(gameScreen);
		}
	}

	/**
	 * This method starts the timeline forever
	 */
	public void startTime(){
		this.timer.play();
		this.timer.setCycleCount(Animation.INDEFINITE);
	}

	/**
	 * This method stops the time
	 */
	public void stopTime() {
		this.timer.stop();
	}
}
