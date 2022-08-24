package com.sunday.stages2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        Scene scene = new Scene(root, 600, 600, Color.SKYBLUE);

        // TEXTO
        Text text = new Text();
        text.setText("Domingo");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Verdana", 50)); // (fuente,tamaño)
        text.setFill(Color.BLUE); // Color de texto

        // LÍNEAS
        Line line = new Line();
        line.setStartX(200);
        line.setStartY(200);
        line.setEndX(500);
        line.setEndY(200);
        line.setStrokeWidth(5); // grosor de línea
        line.setStroke(Color.RED);
        line.setOpacity(0.5); // transparencia al 50%
        line.setRotate(45); // 45º, el punto final gira horario respecto al punto inicial

        // RECTÁNGULO
        Rectangle rectangle = new Rectangle();
        rectangle.setX(100);
        rectangle.setY(100);
        rectangle.setWidth(100);
        rectangle.setHeight(100); // se forma un cuadrado
        rectangle.setFill(Color.BLUE); // por defecto es negro
        rectangle.setStrokeWidth(5); // grosor de línea de borde
        rectangle.setStroke(Color.BLACK); // color de línea de borde

        // TRIÁNGULO
        Polygon triangle = new Polygon();
        triangle.getPoints().setAll(
                200.0, 200.0,
                300.0, 300.0,
                200.0, 300.0
        );
        triangle.setFill(Color.YELLOW);

        // CÍRCULOS
        Circle circle = new Circle();
        circle.setCenterX(350);
        circle.setCenterY(350);
        circle.setRadius(50);
        circle.setFill(Color.ORANGE);

        // IMÁGENES
        Image image = new Image(HelloApplication.class.getResource("/images/alien.png").toString());
        // absolute-path de ejemplo
        // Image image = new Image("D:\\CURSOS\\pry-javafx\\stages2\\src\\main\\resources\\images\\alien.png");
        ImageView imageView = new ImageView(image);
        imageView.setX(400);
        imageView.setY(400);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        root.getChildren().add(text);
        root.getChildren().add(line);
        root.getChildren().add(rectangle);
        root.getChildren().add(triangle);
        root.getChildren().add(circle);
        root.getChildren().add(imageView);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}