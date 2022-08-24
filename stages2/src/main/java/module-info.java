module com.sunday.stages2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sunday.stages2 to javafx.fxml;
    exports com.sunday.stages2;
}