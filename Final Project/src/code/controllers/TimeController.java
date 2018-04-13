package code.controllers;

import code.Gui.GameScreen;
import code.items.Avatar;
import code.items.Heart;
import code.items.Spider;
import code.items.Token;
import gui_version.interfaces.Constants;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class TimeController implements Constants {
	Timeline timer;
	KeyFrame frame;
	SoundController soundController = new SoundController();

	double distance = 0;
	double addDistance = 1;

	public TimeController(GameScreen gameScreen, Avatar avatar){
		init(gameScreen, avatar);
	}

	public void init(GameScreen gameScreen, Avatar avatar){
		this.timer = new Timeline(this.frame = new KeyFrame(
				Duration.millis(duration),
				event -> {
					this.update(gameScreen);
					this.collision(gameScreen, avatar);
				}));
	}

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
			/*if (((ImageView) gameScreen.getGameLayout().getChildren().get(i)).getY() >= windowHeight) {
				gameScreen.getGameLayout().getChildren().remove(i);
				gameScreen.typeClass.remove(i - 1);
			}*/
		}
	}

	public void gameOver(GameScreen gameScreen, Avatar avatar){
		if (avatar.getHealth() == 0) {
			this.stopTime();
			gameScreen.setGameOver();
			gameScreen.getBaseLayout().setCenter(gameScreen.getGameOver());
			gameScreen.getNameController().display(gameScreen);
		}
	}

	public KeyFrame getFrame() {
		return this.frame;
	}

	public Timeline getTimer() {
		return this.timer;
	}

	public void startTime(){
		this.timer.play();
		this.timer.setCycleCount(Animation.INDEFINITE);
	}

	public void stopTime() {
		this.timer.stop();
	}
}
