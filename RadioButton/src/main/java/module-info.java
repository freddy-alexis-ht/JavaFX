module com.sunday.radiobutton {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sunday.radiobutton to javafx.fxml;
    exports com.sunday.radiobutton;
}