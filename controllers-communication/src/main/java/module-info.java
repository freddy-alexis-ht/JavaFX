module com.sunday.controllerscommunication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sunday.controllerscommunication to javafx.fxml;
    exports com.sunday.controllerscommunication;
}