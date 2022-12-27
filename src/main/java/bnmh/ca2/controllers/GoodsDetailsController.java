package bnmh.ca2.controllers;

import bnmh.ca2.models.BakedGood;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

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
        originLabel.setText("Origin: " + bg.getOrigin());
        descLabel.setText("Description: " + bg.getDesc());
        try {
            InputStream stream = new FileInputStream(bg.getFilepath());
            Image image = new Image(stream);
            imgView.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}