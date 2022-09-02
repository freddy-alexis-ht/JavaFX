module com.sunday.mp3player {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.sunday.mp3player to javafx.fxml;
    exports com.sunday.mp3player;
}