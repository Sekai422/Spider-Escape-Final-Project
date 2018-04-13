package code.controllers;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

public class SoundController {

    public Media music = new Media(new File("media/ActionFace.mp3").toURI().toString());
    Media healthSound = new Media(new File("media/healthup.wav").toURI().toString());
    Media coinSound = new Media(new File("media/coin.wav").toURI().toString());
    Media damageSound = new Media(new File("media/hit.wav").toURI().toString());
    MediaPlayer musicPlayer = new MediaPlayer(music);

    public void playMedia (Media sound) {

        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    public void playMusic() {

        musicPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                musicPlayer.seek(Duration.ZERO);
            }
        });
        musicPlayer.play();
    }

    public void pauseMusic() {
        musicPlayer.pause();
    }

	public MediaPlayer getMusicPlayer() {
		return musicPlayer;
	}
}
