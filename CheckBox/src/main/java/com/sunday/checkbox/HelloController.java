package com.sunday.checkbox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloController {

    @FXML
    private CheckBox chbOnOff;
    @FXML
    private Label lbBulb;
    @FXML
    private ImageView imvBulb;

    Image bulb_on = new Image(getClass().getResourceAsStream("/images/bulb-on.png"));
    Image bulb_off = new Image(getClass().getResourceAsStream("/images/bulb-off.png"));

    public void change(ActionEvent event) {
        if(chbOnOff.isSelected()) {
            lbBulb.setText("ON");
            imvBulb.setImage(bulb_on);
        }else{
            lbBulb.setText("OFF");
            imvBulb.setImage(bulb_off);
        }
    }
}