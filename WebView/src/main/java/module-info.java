module com.sunday.webview {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

                        
    opens com.sunday.webview to javafx.fxml;
    exports com.sunday.webview;
}