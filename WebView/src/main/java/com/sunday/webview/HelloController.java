package com.sunday.webview;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private WebView webView;
    @FXML
    private TextField tfLoad;

    private WebEngine engine;
    private String homePage;
    private double webZoom;
    private WebHistory history;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Instantiate the engine
        engine = webView.getEngine();
        homePage = "www.google.com";
        tfLoad.setText(homePage);
        webZoom = 1;
        loadPage();
    }

    public void loadPage() {
        // engine.load("http://www.google.com");
        engine.load("http://" + tfLoad.getText());
    }

    public void refreshPage() {
        engine.reload();
    }
    public void zoomIn() {
        webZoom += 0.25;
        webView.setZoom(webZoom);
    }
    public void zoomOut() {
        webZoom -= 0.25;
        webView.setZoom(webZoom);
    }
    public void displayHistory() {
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        for(WebHistory.Entry entry : entries) {
            System.out.println(entry.getUrl() + " " + entry.getLastVisitedDate());
        }
    }
    public void back() {
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        history.go(-1);
        // to change the URL displayed (because it didn't change when moving back and forward)
        tfLoad.setText(entries.get(history.getCurrentIndex()).getUrl());
    }
    public void forward() {
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        history.go(+1);
        tfLoad.setText(entries.get(history.getCurrentIndex()).getUrl());
    }
    public void executeJS() {
        engine.executeScript("window.location = \"https://www.youtube.com\";");
        tfLoad.setText("www.youtube.com");
    }
}