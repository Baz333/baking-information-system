package bnmh.ca2.controllers;

import bnmh.ca2.models.BakedGood;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    @FXML
    private String filepath = null;
    public Button backButton;
    public Button editButton;
    public Button fileButton;
    private ListView<String> recipeList;
    @FXML
    private Button addRecipeButton;
    @FXML
    private Button backButton;
    BakedGood bg = MenuController.bg;

    public void initialize() {
        nameLabel.setText(bg.getName());
        originLabel.setText(bg.getOrigin());
        descLabel.setText(bg.getDesc());
        try {
            InputStream stream = new FileInputStream(bg.getFilepath());
            Image image = new Image(stream);
            imgView.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void OnBackButton() throws IOException {
        FXMLLoader menuView = new FXMLLoader(AddGoodsController.class.getResource("menu-view.fxml"));
        backButton.getScene().setRoot(menuView.load());
    }

}