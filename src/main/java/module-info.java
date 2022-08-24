module com.sunday.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sunday.javafx to javafx.fxml;
    exports com.sunday.javafx;
}