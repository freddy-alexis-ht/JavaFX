module com.sunday.menubar {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sunday.menubar to javafx.fxml;
    exports com.sunday.menubar;
}