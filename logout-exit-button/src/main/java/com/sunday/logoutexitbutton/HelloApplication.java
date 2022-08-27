package com.sunday.logoutexitbutton;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        // botón [X] de la parte superior-derecha en la ventana
        // Si solo fuera esta línea, al dar a Cancelar en la Confirmación, el evento se consume igual y se cierra la ventana
        // stage.setOnCloseRequest(event -> logout(stage));
        // Para que no se cierre, se debe detener al event
        stage.setOnCloseRequest(event -> {
            event.consume();
            logout(stage);
        });
    }
    // En HelloController está logout(ActionEvent), aquí es logout(Stage)
    public void logout(Stage stage) {
        // Alerta de confirmación
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Do you want to save before exiting?");

        if(alert.showAndWait().get() == ButtonType.OK) {
            // no es necesario crear el 'stage' porque éste ya se crea en start()
            // .. y desde start() es pasado a logout()
            // stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("You successfully logged out!");
            stage.close();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}