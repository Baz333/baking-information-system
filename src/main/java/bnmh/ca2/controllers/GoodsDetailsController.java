package bnmh.ca2.controllers;

import bnmh.ca2.models.BakedGood;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.*;

public class GoodsDetailsController {

    public TextField Name;
    public TextField Origin = null;
    public TextField Description = null;
    public Button edit;
    public Button backEditButton;
    public ImageView imageView = null;

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

    public void OnFileButton() throws IOException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.webp"));
        File selectedFile = fileChooser.showOpenDialog(fileButton.getScene().getWindow());
        if(selectedFile != null) {
            filepath = selectedFile.getAbsolutePath();
        }
        InputStream stream = new FileInputStream(filepath);
        Image image = new Image(stream);
        imageView.setImage(image);
    }

    public void OnBackButton() throws IOException {
        FXMLLoader menuView = new FXMLLoader(AddGoodsController.class.getResource("menu-view.fxml"));
        backButton.getScene().setRoot(menuView.load());
    }

    public void OnBackEditButton() throws IOException {
        FXMLLoader menuView = new FXMLLoader(AddGoodsController.class.getResource("baked-good-details.fxml"));
        backEditButton.getScene().setRoot(menuView.load());
    }

    public void OnEditButton() throws IOException {
        FXMLLoader menuView = new FXMLLoader(AddGoodsController.class.getResource("baked-good-details.fxml"));
        edit.getScene().setRoot(menuView.load());
        if(!Name.getText().isEmpty()) {
            bg.setName(Name.getText());
            nameLabel.setText(Name.getText());
        }
        if(!Origin.getText().isEmpty()) {
            originLabel.setText(Origin.getText());
            bg.setOrigin(Origin.getText());
        }
        if(!Description.getText().isEmpty()){
            bg.setDesc(Description.getText());
            descLabel.setText(Description.getText());
        }
        if(filepath != null){
            bg.setFilepath(filepath);
            imgView = imageView;
            try {
                InputStream stream = new FileInputStream(filepath);
                Image image = new Image(stream);
                imgView.setImage(image);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void OnEditButtonPressed() throws IOException {
        FXMLLoader addIngredientView = new FXMLLoader(MenuController.class.getResource("goods-edit.fxml"));
        editButton.getScene().setRoot(addIngredientView.load());
    }

}