module com.sunday.colorpicker {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sunday.colorpicker to javafx.fxml;
    exports com.sunday.colorpicker;
}