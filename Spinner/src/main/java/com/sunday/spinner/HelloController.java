package com.sunday.spinner;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Spinner<Integer> spiNumbers;
    @FXML
    private Label lbNumbers;

    int currentValue;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // numbers from 1 to 10
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10);
        // Set the initial value
        valueFactory.setValue(1);
        // add the valueFactory to the Spinner
        spiNumbers.setValueFactory(valueFactory);

        // The label is in '1', despite the spinner is in another number
        currentValue = spiNumbers.getValue();
        lbNumbers.setText(Integer.toString(currentValue));

        // Listener to update the label when the spinner changes
        spiNumbers.valueProperty().addListener( (var1,var2,var3) -> {
            currentValue = spiNumbers.getValue();
            lbNumbers.setText(Integer.toString(currentValue));
        });
    }
}