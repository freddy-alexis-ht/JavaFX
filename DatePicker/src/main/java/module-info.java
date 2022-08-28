module com.sunday.datepicker {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sunday.datepicker to javafx.fxml;
    exports com.sunday.datepicker;
}