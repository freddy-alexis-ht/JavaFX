module com.sunday.imageview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sunday.imageview to javafx.fxml;
    exports com.sunday.imageview;
}