module com.sunday.progressbar {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sunday.progressbar to javafx.fxml;
    exports com.sunday.progressbar;
}