package code;

import gui_version.interfaces.Constants;

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
