package interfaces;

import code.*;

public interface Preloader{
	StartMenu startMenu = new StartMenu();
	GameScreen gameScreen = new GameScreen();
	Avatar avatar = new Avatar();
	TimeController timeController = new TimeController(gameScreen, avatar);
	PauseMenu pauseMenu = new PauseMenu();
}
