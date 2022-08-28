module com.sunday.checkbox {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sunday.checkbox to javafx.fxml;
    exports com.sunday.checkbox;
}