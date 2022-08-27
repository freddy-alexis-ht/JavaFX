module com.sunday.switchscenes {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sunday.switchscenes to javafx.fxml;
    exports com.sunday.switchscenes;
}