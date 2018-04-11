package interfaces;

import code.Gui.GameScreen;
import code.Gui.PauseMenu;
import code.Gui.StartMenu;
import code.controllers.TimeController;
import code.items.Avatar;

public interface Preloader{
	StartMenu startMenu = new StartMenu();
	GameScreen gameScreen = new GameScreen();
	Avatar avatar = new Avatar();
	TimeController timeController = new TimeController(gameScreen, avatar);
	PauseMenu pauseMenu = new PauseMenu();
}
