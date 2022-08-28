module com.sunday.textfield {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sunday.textfield to javafx.fxml;
    exports com.sunday.textfield;
}