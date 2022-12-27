package bnmh.ca2.controllers;

import bnmh.ca2.models.BakedGood;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.image.ImageView;

public class GoodsDetailsController {

    @FXML
    private Label nameLabel;
    @FXML
    private Label originLabel;
    @FXML
    private Label descLabel;
    @FXML
    private ImageView imgView;
    BakedGood bg = MenuController.bg;

    public void initialize() {
        nameLabel.setText("Name: " + bg.getName());
    }

}