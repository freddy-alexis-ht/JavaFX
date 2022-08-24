module com.domingo.eventhandling {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.domingo.eventhandling to javafx.fxml;
    exports com.domingo.eventhandling;
}