package com.sunday.radiobutton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class HelloController {
    @FXML
    private Label lbFood;
    @FXML
    private RadioButton rbtnPizza, rbtnSushi, rbtnRamen;

    public void getFood(ActionEvent event) {

        if(rbtnPizza.isSelected()) {
            lbFood.setText(rbtnPizza.getText());
        }else if(rbtnSushi.isSelected()) {
            lbFood.setText(rbtnSushi.getText());
        }else if(rbtnRamen.isSelected()) {
            lbFood.setText(rbtnRamen.getText());
        }
    }
}