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

    /**
     * A MediaPlayer object using a Media object is created and played.
     * @param sound this is the JavaFX media file that will be played
     */
    public void playMedia (Media sound) {

        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    /**
     * The game music is played and repeated using the music Media object.
     */
    public void playMusic() {

        musicPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                musicPlayer.seek(Duration.ZERO);
            }
        });
        musicPlayer.play();
    }

    /**
     * The MediaPlayer object for music is paused.
     */
    public void pauseMusic() {
        musicPlayer.pause();
    }

    /**
     * Used to control MediaPlayer object for music in pause menu by returning the musicPlayer from SoundController class.
     * @return musicPlayer MediaPlayer object for music.
     */
	public MediaPlayer getMusicPlayer() {
		return musicPlayer;
	}
}
