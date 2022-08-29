module com.sunday.keyevents {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sunday.keyevents to javafx.fxml;
    exports com.sunday.keyevents;
}