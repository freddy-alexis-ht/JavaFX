module com.sunday.choicebox {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sunday.choicebox to javafx.fxml;
    exports com.sunday.choicebox;
}