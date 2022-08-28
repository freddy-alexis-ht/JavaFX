module com.sunday.slider {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sunday.slider to javafx.fxml;
    exports com.sunday.slider;
}