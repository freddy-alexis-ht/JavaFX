package com.domingo.eventhandling;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // En el video, el código inicial aparece como:
        // Parent root = FXMLLoader.load(getClass().getResource("archivo.fxml"));
        // Scene scene = new Scene(root);
        // stage.setScene(scene);
        // stage.show();
        // Por defecto aparece como:
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}