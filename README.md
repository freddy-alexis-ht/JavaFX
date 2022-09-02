## 1. CONFIGURACIÓN DEL PROYECTO

### Repo-local y Repo-remoto
- Creación del repo-remoto
    - Licencia: GNU GLP v3
- Creación del repo-local: `git init`
- Vinculación de repos: `git remote add origin https://github.com/freddy-alexis-ht/JavaFX.git`
- Sincronización de branches: `git pull origin master`

### Creación del proyecto

- Ir a: https://openjfx.io/ -> Download -> Windows/18.0.2/SDK
- Elegir un lugar para descomprimir, p.e.: `C:\Program Files\Java`
- En IntelliJ -> New Project -> JavaFX -> Name: javafx -> group: com.sunday -> artifact: javafx -> Project SDK: 18

- Ir a https://openjfx.io/openjfx-docs/ -> Java FX and Intellij -> Non-modular from IDE -> Seguir las instrucciones:
- Se mostrarán algunas clases por defecto, pero con warnings:
  - File -> Project Structure -> Project -> SDK -> 18.0.2
  - File -> Project Structure Libraries -> + -> Java -> select the JavaFX SDK downloaded: C:\Program Files\Java\javafx-sdk-18.0.2\lib -> Apply -> OK

Según la web-page de la documentación indicada antes, hay más pasos, pero me bastó con los anteriores. Se ejecuta y se muestra una ventana.

### Scene Builder

- Buscar SceneBuilder: https://gluonhq.com/products/scene-builder/ -> Download
- File -> Settings -> Languages & Frameworks -> JavaFX -> Path to SceneBuilder -> ubicación del `.exe`
- En el proyecto: ir al archivo `.fxml` -> Open in SceneBuilder.

### Probando el SceneBuilder
- Containers -> AnchorPane -> otros componentes
- File -> Save (esto se guardará en el `.fxml`)

En la clase principal estará este código:
- Para ejecutar, borrar las dimensiones en 'scene'.
~~~
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        stage.setTitle("Hello!");
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }
~~~

- Esto también sirve (un poco más resumido)
~~~
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage.setTitle("Hello!");
        stage.setScene(new Scene(root));
        stage.show();
    }
~~~

## Creación de módulos

- File -> New Module -> Name: stages -> Location: ..\pry-javafx\stages -> group: com.sunday -> artifact: stages -> Project SDK: 18
- Ejecutar para verificar que funciona.
  - Name .. nombre del módulo en el proyecto
  - Location .. nombre del módulo en las carpetas
  - Group y artifact .. carpetas en el proyecto

## Orden de módulos:
1. stages .. working with stage, scene, root-node.
2. stages2 .. working with nodes: text, lines, images, ..
3. event-handling .. working with controller and .fxml.
4. css-styling .. applying css to a JavaFX GUI application
5. switch-scenes .. switching from scene1 to scene2
6. logout-exit-button .. closing a window with confirmation popup
7. image-view .. Using ImageView features
8. TextField .. Working with text-fields in a submit-app
9. CheckBox .. Working with a check-box to turn on/off a bulb
10. RadioButton .. Working with radio-buttons to select foods
11. DatePicker .. Using date-picker to show the date on a label
12. ColorPicker .. Using color-picker to change the background-color
13. ChoiceBox .. Using a choice-box as a list of food
14. Slider .. Using a slider to change the temperature
15. ProgressBar .. Increase the progress-bar with each click in the button
16. Spinner .. Changing numbers in the Spinner and display in Label.
17. ListView .. Selected ListView item displayed on a label
18. TreeView .. TreeView with root, branches, leaves and an icon
19. MenuBar .. Working with Menu, MenuItems, onAction, shortcut and more
20. KeyEvents .. Detecting key-events in a Scene with EventHandler
21. Animations .. Translate, rotate, fade and scale an image (module: Animations)
22. MediaView .. Play, pause and reset a video (module: MediaView)
23. WebView .. Embedding a web browser (module: WebView)
24. MP3-Player .. A complete mp3 player (module: MP3Player)

## Markdown

[Markdown syntax in IntelliJ 2021](https://www.jetbrains.com/help/upsource/markdown-syntax.html "02-abr-2021")

[Markdown sintax in IntelliJ 2022](https://www.jetbrains.com/help/idea/markdown.html "22-jul-2022")