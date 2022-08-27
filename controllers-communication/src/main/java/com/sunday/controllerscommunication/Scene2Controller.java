package com.sunday.controllerscommunication;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Scene2Controller {

    @FXML
    Label lbHello;

    public void displayUsername(String username) {
        lbHello.setText("Hello: "+username);
    }
}
