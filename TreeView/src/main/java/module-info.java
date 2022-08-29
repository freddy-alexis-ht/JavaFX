module com.sunday.treeview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sunday.treeview to javafx.fxml;
    exports com.sunday.treeview;
}