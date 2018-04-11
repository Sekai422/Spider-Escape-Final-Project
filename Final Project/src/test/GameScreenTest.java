package test;

import code.Avatar;
import code.GameScreen;
import org.junit.Test;
import javafx.scene.control.Label;


class GameScreenTest {

    @Test
    void checkScreen() {
        GameScreen aGameScreen = new GameScreen();
        aGameScreen.setGameScreen();
        //assertEquals(, , );
    }

    @Test
    void getGameLayout() {
    }

    @Test
    void getBaseLayout() {
    }

    @Test
    void getHealth() {
        Avatar avatar = new Avatar();
        avatar.updateHealth(4);
        this.setHealth();
        Label aLabel = new Label();
        aLabel.setText("Health: 4");
    }

    @Test
    void setHealth() {
        Avatar avatar = new Avatar();
        avatar.updateHealth(4);
        this.setHealth();
        Label aLabel = new Label();
        aLabel.setText("Health: 4");
    }

    @Test
    void getScore() {
        Avatar avatar = new Avatar();
        avatar.updateScore(4);
        this.setHealth();
        Label aLabel = new Label();
        aLabel.setText("Score: 4");
        //assertEquals(Label, , );
    }

    @Test
    void getGameOver() {
    }

    @Test
    void getScene() {
    }

    @Test
    void shuffledLocations() {
    }

    @Test
    void keyEventHandler() {
    }

    @Test
    void setDuration() {
    }
}