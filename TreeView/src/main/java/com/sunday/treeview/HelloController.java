package com.sunday.treeview;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TreeView treeView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Creating tree-items to add to the tree-view
        // root-item
        ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("/images/icon.png")));
        TreeItem<String> rootItem = new TreeItem<>("Files", icon);
        // branch-items
        TreeItem<String> branchItem1 = new TreeItem<>("Pictures");
        TreeItem<String> branchItem2 = new TreeItem<>("Videos");
        TreeItem<String> branchItem3 = new TreeItem<>("Music");
        // branch-items
        TreeItem<String> leafItem1 = new TreeItem<>("picture1");
        TreeItem<String> leafItem2 = new TreeItem<>("picture2");
        TreeItem<String> leafItem3 = new TreeItem<>("video1");
        TreeItem<String> leafItem4 = new TreeItem<>("video2");
        TreeItem<String> leafItem5 = new TreeItem<>("music1");
        TreeItem<String> leafItem6 = new TreeItem<>("music2");

        // Adding leaf-items to branch-items
        branchItem1.getChildren().addAll(leafItem1, leafItem2);
        branchItem2.getChildren().addAll(leafItem3, leafItem4);
        branchItem3.getChildren().addAll(leafItem5, leafItem6);

        // Adding branch-items to the root-item
        rootItem.getChildren().addAll(branchItem1, branchItem2, branchItem3);

        // Adding the root-item (with its content) to the tree-view
        treeView.setRoot(rootItem);
    }

    public void selectItem() {
        // To store the current-tree-item selected
        TreeItem<String> item = (TreeItem<String>) treeView.getSelectionModel().getSelectedItem();
        if(item != null) {
            System.out.println(item.getValue());
        }
    }
}