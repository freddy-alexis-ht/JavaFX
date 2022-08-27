module com.sunday.logoutexitbutton {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sunday.logoutexitbutton to javafx.fxml;
    exports com.sunday.logoutexitbutton;
}