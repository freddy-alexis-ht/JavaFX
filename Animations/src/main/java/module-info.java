module com.sunday.animations {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sunday.animations to javafx.fxml;
    exports com.sunday.animations;
}