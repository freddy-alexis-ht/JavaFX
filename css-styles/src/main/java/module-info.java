module com.sunday.cssstyles {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sunday.cssstyles to javafx.fxml;
    exports com.sunday.cssstyles;
}