package com.sunday.keyevents;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = loader.load();

        // To have access to any member of our controller
        HelloController controller = loader.getController();
        Scene scene = new Scene(root);


        // handling key-press
        /*
        // Using anonymous class as an instance of the functional interface
        // When the scene detects a KeyEvent it will call the handle() method
            scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                }
            });
        */
        // Using Lambda
        scene.setOnKeyPressed( event -> {
            switch (event.getCode()) {
                case W: controller.moveUp(); break;
                case S: controller.moveDown(); break;
                case A: controller.moveLeft(); break;
                case D: controller.moveRight(); break;
                default: break;
            }
        });

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}