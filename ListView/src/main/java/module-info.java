module com.sunday.listview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sunday.listview to javafx.fxml;
    exports com.sunday.listview;
}