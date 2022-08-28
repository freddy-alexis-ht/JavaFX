package com.sunday.progressbar;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private ProgressBar pbarIncrease;
    @FXML
    private Label lbIncrease;

    private double progress;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pbarIncrease.setStyle("-fx-accent: #00DD00;");
    }

    public void increaseProgress() { // button onAction
        progress = m(progress);
        if(progress < 1) {
            progress = progress+0.1;
            pbarIncrease.setProgress(m(progress));
            // show increment on label.
            lbIncrease.setText((int)(m(progress)*100) + "%");
        }
    }
    private double m(double d) {
        return (Math.round(d*10))/10.0;
    }
}