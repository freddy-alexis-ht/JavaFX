package com.sunday.colorpicker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class HelloController {
    @FXML
    private AnchorPane ancPane;
    @FXML
    private ColorPicker cpikColor;

    public void changeColor(ActionEvent event) {
        Color color = cpikColor.getValue();
        // BackgroundFill(arg1,arg2,arg3) .. on the video it's said that arg2 y arg3
        // .. can be: CornerRadii.EMPTY and Insets.EMPTY; but it's assigned to null for simplicity
        ancPane.setBackground(new Background(new BackgroundFill(color, null, null)));
    }
}