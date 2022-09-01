## Description

In MediaView we can display video or other media source.

### hello-view.fxml in SceneBuilder

- Controller
    - com.sunday.mediaview.HelloController


- Containers
    - AnchorPane (400x300)


- Controls
    - MediaView
        - Fit width: 400
        - Fix height: 200
        - fx:id: mediaView
    - Buttons
        - Text: PLAY, fx:id: btnPlay, onAction: onPlay
        - Text: PAUSE, fx:id: btnPause, onAction: onPause
        - Text: RESET, fx:id: btnReset, onAction: onReset


### module-info.java

In `HelloController.java` some javafx.media controls we'll be used, so we need to require it in the module-info.java:

~~~
module com.sunday.mediaview {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.sunday.mediaview to javafx.fxml;
    exports com.sunday.mediaview;
}
~~~

### pom.xml

Add the dependency.

~~~
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-media</artifactId>
        <version>18-ea+2</version>
    </dependency>
~~~

### HelloController.java

~~~

~~~



A
