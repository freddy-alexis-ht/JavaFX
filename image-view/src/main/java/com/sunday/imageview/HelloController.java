package com.sunday.imageview;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloController {

    @FXML
    private ImageView imvFoto;

    private Image image = new Image(getClass().getResourceAsStream("/images/luna.jpg"));

    // método asociado al botón para cambiar las imágenes
    public void displayImage() {
        // se pone la foto en el cuadro.
        imvFoto.setImage(image);
    }
}