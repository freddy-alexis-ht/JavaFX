module com.sunday.spinner {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sunday.spinner to javafx.fxml;
    exports com.sunday.spinner;
}