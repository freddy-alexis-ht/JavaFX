package com.sunday.stages;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, Color.BLACK); // javafx.scene.paint.Color
        Image icon = new Image(HelloApplication.class.getResource("/images/alien.png").toString()); // javafx.scene.image.Image

        stage.getIcons().add(icon);
        stage.setTitle("Demo program");

        stage.setWidth(420);
        stage.setHeight(420);
        stage.setResizable(false);
        stage.setX(50); // por defecto se muestra en el centro
        stage.setY(50);
        stage.setFullScreen(true); // por defecto, 'esc' para salir del full-screen
        stage.setFullScreenExitHint("You can't scape unless you press 'q'");
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q")); // se cambia a 'q'

        stage.setScene(scene);
        stage.show();
    }
}