## STAGES


Al ejecutar la aplicación, se muestra una ventana, pero ésta está compuesta de lo que se muestra en la imagen.
- Stage: top level container to hold our JavaFX GUI apps, it's similar to JFrame in Swing.
- Scene: drawing surface for graphical content, it's similar to JPanel.
- Scene-Graph: it's a hierarchical tree of nodes. Nodes are different components in the scene: buttons, text-boxes, images, ...  

Como mínimo se necesita un 'root-node' para crear un 'Scene', el cual será agregado al 'Stage'.  

![stage-scene-sceneGraph](../stage-scene-sceneGraph.png)

### Código

Si borramos el código generado por defecto, tenemos:
~~~
public class HelloApplication extends Application {
    public static void main(String[] args) {
    }
}
~~~

- Nuestra clase 'HelloApplication' hereda la funcionalidad de 'Application'.  
- 'Application' es una clase abstracta, entre sus métodos algunos son static (p.e. launch()) y 1 es abstract: start()
- Ya que 'Application' es padre, se debe 'override' el método `start()`.
- Además, en `main(String[] args)` se debe llamar a `launch(args)` y pasarle 'args' como argumento.
- Notar que podría usarse: `Application.launch(args)`, pero por la herencia no es necesario.  
- Cuando se ejecuta 'launch()', internamente llama a 'start()'.

~~~
public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
    }
}
~~~

- Como se indicó, la primera capa es un 'Stage'. La línea `stage.show()` debe ir al final.
- Al ejecutar se verá la ventana.

~~~
    @Override
    public void start(Stage stage) throws Exception {
        stage.show();
    }
~~~

- La siguiente capa es el 'Scene', el cual como mínimo debe tener un 'root-node' como argumento en el constructor de Scene.
- Hay varios tipos de root-node, son como 'layout-managers'. Estos indican como los nodes (componentes) estarán distribuidos.
- Un tipo básico de root-node es 'Group', es como decir "grupo de nodos".

~~~
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group(); // javafx.scene.Group
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
~~~

### Modificaciones  

Agregando un título con un ícono al 'stage', y background-color negro en el 'scene'.  

~~~
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, Color.BLACK); // javafx.scene.paint.Color
        Image icon = new Image(HelloApplication.class.getResource("/images/alien.png").toString()); // javafx.scene.image.Image
        stage.getIcons().add(icon);
        stage.setTitle("Demo program");
        stage.setScene(scene);
        stage.show();
    }
~~~

Se establece un tamaño del 'stage', pero se indica que inicialmente se mostrará full-screen, y que se debe presionar 'q' para salir de ese modo.  
Al salir del full-screen se mostrará en 420x420, ubicado en x=50,y=50.

~~~
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
~~~