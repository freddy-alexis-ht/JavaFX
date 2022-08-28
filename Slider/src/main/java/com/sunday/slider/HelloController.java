package com.sunday.slider;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label lbTemperature;
    @FXML
    private Slider sldTemperature;

    int temperature;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        temperature = (int) sldTemperature.getValue();
        lbTemperature.setText(Integer.toString(temperature) + "ºC");

        /*
        // Before Lambda, anonymous classes were used, in this case, an instance of the functional interface: ChangeListener
        // The code with anonymous-class would be like this
        sldTemperature.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                // slider current value
                temperature = (int) sldTemperature.getValue();
                lbTemperature.setText(Integer.toString(temperature) + "ºC");
            }
        });
        */

        /*
        Knowing that the functional interface is like this.. It'd be better to use Lambda.
            @FunctionalInterface
            public interface ChangeListener<T> {
                void changed(ObservableValue<? extends T> var1, T var2, T var3);
            }
        */

        // By using IntelliJ it helps with the conversion.
        // Note that we're not using any of the arguments, so the first line could be:
        //    sldTemperature.valueProperty().addListener((var1, var2, var3) -> {
        // But, this is the way IntelliJ did the conversion.
        sldTemperature.valueProperty().addListener((observableValue, number, t1) -> {
            // slider current value
            temperature = (int) sldTemperature.getValue();
            lbTemperature.setText(Integer.toString(temperature) + "ºC");
        });
    }
}