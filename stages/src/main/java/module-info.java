module com.sunday.stages {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sunday.stages to javafx.fxml;
    exports com.sunday.stages;
}