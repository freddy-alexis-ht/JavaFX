package com.sunday.listview;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private ListView<String> livFood;
    @FXML
    private Label lbFood;

    private String[] foods = {"pizza", "sushi", "ramen"};
    private String currentFood;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // add array-items to the list-view
        // on execution: the ListView displays the items
        livFood.getItems().addAll(foods);
        // on change the selection, the item will be displayed on the label
        livFood.getSelectionModel().selectedItemProperty().addListener( (var1,var2,var3) -> {
            // the selected item is stored
            currentFood = livFood.getSelectionModel().getSelectedItem();
            lbFood.setText(currentFood);
        });

    }
}