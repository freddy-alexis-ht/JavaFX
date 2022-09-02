package com.sunday.mp3player;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class HelloController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private Label lbSong;
    @FXML
    private Button btnPlay, btnPause, btnReset, btnPrevious, btnNext;
    @FXML
    private ComboBox<String> cboxSpeed;
    @FXML
    private Slider sliVolume;
    @FXML
    private ProgressBar pbarSong;

    // directory of music
    private File directory;
    private File[] files;
    private ArrayList<File> songs; // playlist

    private int songNumber;
    private int[] speeds = {25,50,75,100,125,150,175,200};

    // keep track of the progress-bar and will be updated every second
    private Timer timer;
    private TimerTask task;
    private boolean running; // true if the mp3-player is playing

    private Media media;
    private MediaPlayer player;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // initialize the ArrayList
        songs = new ArrayList<File>();

        // option-1
        // ClassLoader classLoader = getClass().getClassLoader();
        // directory = new File(classLoader.getResource("music").getFile());
        // option-2
        // directory = new File("D:\\01-EVE\\CURSOS\\15-JavaFX2\\JavaFX\\Mp3Player\\src\\main\\resources\\music");
        // option-3
        directory = new File("Mp3Player/src/main/resources/music");
        files = directory.listFiles(); // get the files in 'directory' ('music' folder)
        if(files != null) {
            for(File file : files) {
                songs.add(file);
                // System.out.println(file); // prints in the console:
                // Mp3Player\src\main\resources\music\ABBA-Super-Trouper.mp3
                // Mp3Player\src\main\resources\music\ACDC-ThunderStruck.mp3
                // Mp3Player\src\main\resources\music\Barry-White-Just-the-way-you-are.mp3
            }
        }

        media = new Media(songs.get(songNumber).toURI().toString());
        player = new MediaPlayer(media);
        lbSong.setText(songs.get(songNumber).getName());

        // COMBO-BOX: to populate the combo-box
        for(int i=0; i < speeds.length; i++) {
            cboxSpeed.getItems().add(Integer.toString(speeds[i]) + "%");
        }
        cboxSpeed.setOnAction(e -> changeSpeed(e)); // (this::changeSpeed)

        // VOLUME
        sliVolume.valueProperty().addListener( (var1,var2,var3) -> {
            player.setVolume(sliVolume.getValue() * 0.01);
        });

        // PROGRESS-BAR COLOR
        pbarSong.setStyle("-fx-accent: #0f0;");

    }

    public void playMedia() {
        beginTimer(); // TIMER
        changeSpeed(null);
        // if the volume was in 0, and then press 'play', the song started at 50% (volume), and the slider still was in 0. This fix that:
        player.setVolume(sliVolume.getValue() * 0.01);
        player.play();
    }
    public void pauseMedia() {
        cancelTimer(); // TIMER
        player.pause();
    }
    public void resetMedia() {
        pbarSong.setProgress(0); // TIMER
        player.seek(Duration.seconds(0));
    }
    public void previousMedia() {
        // if the last song is reached, the 'next' button does nothing
        if(songNumber > 0) {
            songNumber--;
            player.stop();

            // TIMER
            if(running) {
                cancelTimer();
            }

            media = new Media(songs.get(songNumber).toURI().toString());
            player = new MediaPlayer(media);
            lbSong.setText(songs.get(songNumber).getName());
            // to play automatically after 'next' button is pressed
            playMedia();
        }
        // when the last song is reached, the 'next' button goes to the first song
        else {
            songNumber = songs.size() -1;
            player.stop();

            // TIMER
            if(running) {
                cancelTimer();
            }

            media = new Media(songs.get(songNumber).toURI().toString());
            player = new MediaPlayer(media);
            lbSong.setText(songs.get(songNumber).getName());
            // to play automatically after 'next' button is pressed
            playMedia();
        }
    }
    public void nextMedia() {
        // if the last song is reached, the 'next' button does nothing
        if(songNumber < songs.size()-1) {
            songNumber++;
            player.stop();

            // TIMER
            if(running) {
                cancelTimer();
            }

            media = new Media(songs.get(songNumber).toURI().toString());
            player = new MediaPlayer(media);
            lbSong.setText(songs.get(songNumber).getName());
            // to play automatically after 'next' button is pressed
            playMedia();
        }
        // when the last song is reached, the 'next' button goes to the first song
        else {
            songNumber = 0;
            player.stop();

            // TIMER
            if(running) {
                cancelTimer();
            }

            media = new Media(songs.get(songNumber).toURI().toString());
            player = new MediaPlayer(media);
            lbSong.setText(songs.get(songNumber).getName());
            // to play automatically after 'next' button is pressed
            playMedia();
        }
    }
    public void changeSpeed(ActionEvent event) {
        if(cboxSpeed.getValue() == null) {
            player.setRate(1);
        } else {
            // if the '%' hadn't been added in the combo-box:
            // player.setRate(Integer.parseInt(cboxSpeed.getValue()) * 0.01);
            // with the '%' added
            player.setRate(Integer.parseInt(cboxSpeed.getValue().substring(0,cboxSpeed.getValue().length()-1)) * 0.01);
        }
    }
    public void beginTimer() {
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                running = true;
                double current = player.getCurrentTime().toSeconds();
                double end = media.getDuration().toSeconds();
                // System.out.println(current/end);
                pbarSong.setProgress(current/end);
                // once the song has finished, the 'timer' should be canceled
                if(current/end == 1) {
                    cancelTimer();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000); // (task, delay, period: time to repeat the task)
    }
    public void cancelTimer() {
        running = false;
        timer.cancel();
    }
}