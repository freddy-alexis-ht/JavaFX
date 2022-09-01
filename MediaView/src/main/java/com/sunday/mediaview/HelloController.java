package com.sunday.mediaview;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class HelloController implements Initializable {
    @FXML
    private MediaView mediaView;
    @FXML
    private Button btnPlay, btnPause, btnReset;

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // File: the video
        file = new File("C:\\Users\\Domingo\\Desktop\\birthday-card.mp4");
        // Media: contains info about the file, duration, metadata, tracks, video-resolution.
        System.out.println(file.toURI().toString()); // file:/C:/Users/Domingo/Desktop/birthday-card.mp4
        media = new Media(file.toURI().toString());
        // MediaPlayer provides the controls to control media
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer); // view
    }

    public void onPlay(ActionEvent event) {
        mediaPlayer.play(); // sound
    }
    public void onPause(ActionEvent event) {
        mediaPlayer.pause();
    }

    public void onReset(ActionEvent event) {
        // If the conditional is omitted
        // -> If reset is pressed and then play, the sound would be there but not the visual
        if(mediaPlayer.getStatus() != MediaPlayer.Status.READY) {
            mediaPlayer.seek(Duration.seconds(0.0));
        }
    }

}