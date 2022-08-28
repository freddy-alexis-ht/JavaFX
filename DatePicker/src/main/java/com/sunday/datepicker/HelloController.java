package com.sunday.datepicker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelloController {
    @FXML
    private DatePicker dpikDate;
    @FXML
    private Label lbDate;

    public void getDate(ActionEvent event) {
        LocalDate date = dpikDate.getValue();
        // Default format: MM-dd-yyyy
        // Changing the output format for date
        String myFormattedDate = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        lbDate.setText(myFormattedDate);
    }
}