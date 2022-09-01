module com.sunday.mediaview {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.sunday.mediaview to javafx.fxml;
    exports com.sunday.mediaview;
}