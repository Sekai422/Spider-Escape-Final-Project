package code.controllers;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class SoundController {

    Media music = new Media(new File("Final Project/src/media/ActionFace.mp3").toURI().toString());
    Media healthSound = new Media(new File("Final Project/src/media/healthup.wav").toURI().toString());
    Media coinSound = new Media(new File("Final Project/src/media/coin.wav").toURI().toString());
    Media damageSound = new Media(new File("Final Project/src/media/hit.wav").toURI().toString());

    public void playMedia (Media sound) {

        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

    }


}
