package com.sunday.textfield;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private Label lbWelcome;
    @FXML
    private TextField tfAge;
    @FXML
    private Button btnSubmit;

    private int age;

    public void submit(ActionEvent event) {
        try {
            age = Integer.parseInt(tfAge.getText());
            // System.out.println(age);
            if(age >= 18)
                lbWelcome.setText("You are now signed up!");
            else
                lbWelcome.setText("You must be 18+!");
        } catch (NumberFormatException e) {
            // System.out.println("Enter only numbers.");
            lbWelcome.setText("Enter only numbers.");
        } catch (Exception e) {
            // System.out.println(e);
            lbWelcome.setText("Error");
        }
    }
}