package code.controllers;

import code.items.Avatar;
import code.Gui.GameScreen;
import interfaces.Constants;

/**
 * This class controls what happens when a key is pressed during the game is played
 *
 * when an A key is pressed the avatar moves left
 * when a left arrow key is pressed the avatar moves left
 * when an D key is pressed the avatar moves right
 * when a right arrow key is pressed the avatar moves right
 * when a P key is pressed the game pauses
 */
public class KeyController implements Constants {

	public void keyEventHandler(Avatar avatar, GameScreen gameScreen){
		gameScreen.getScene().setOnKeyPressed(event -> {
			switch (event.getCode()){
				case A:
					if (avatar.getImage().getX() > (windowWidth/column - objectWidth)/2) {
						avatar.getImage().setX(avatar.getImage().getX() - windowWidth / column);
						this.keyEventHandler(avatar, gameScreen);
						break;
					}
					else{
						break;
					}
				case D:
					if (avatar.getImage().getX() <= (windowWidth - windowWidth/column - objectWidth)) {
						avatar.getImage().setX(avatar.getImage().getX() + windowWidth / column);
						this.keyEventHandler(avatar, gameScreen);
						break;
					}
					else {
						break;
					}
				case LEFT:
					if (avatar.getImage().getX() > (windowWidth/column - objectWidth)/2) {
						avatar.getImage().setX(avatar.getImage().getX() - windowWidth / column);
						this.keyEventHandler(avatar, gameScreen);
						break;
					}
					else{
						break;
					}
				case RIGHT:
					if (avatar.getImage().getX() <= (windowWidth - windowWidth/column - objectWidth)) {
						avatar.getImage().setX(avatar.getImage().getX() + windowWidth / column);
						this.keyEventHandler(avatar, gameScreen);
						break;
					}
					else {
						break;
					}
				case P:
					gameScreen.getTimeController().stopTime();
					gameScreen.getPauseMenu().display(gameScreen);
			}

		});
	}
}
