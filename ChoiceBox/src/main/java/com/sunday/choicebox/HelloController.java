package com.sunday.choicebox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label lbFood;
    @FXML
    private ChoiceBox<String> chobFood;

    // Data to populate the ChoiceBox
    private String[] food = {"pizza", "sushi", "ramen"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chobFood.getItems().addAll(food);
        chobFood.setOnAction(event -> getFood(event)); // (this::getFood)
    }

    public void getFood(ActionEvent event) {
        String myFood = chobFood.getValue();
        lbFood.setText(myFood);
    }
}