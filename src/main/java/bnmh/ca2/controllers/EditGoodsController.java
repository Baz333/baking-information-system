package bnmh.ca2.controllers;

import bnmh.ca2.models.BakedGood;
import bnmh.ca2.utils.LinkedNode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class EditGoodsController implements Initializable{

    public Label nameLabel;
    public ImageView imgView;
    public Label originLabel;
    public Label descLabel;

    public TextField Name;
    public TextField Origin;
    public TextField Description;
    public Button backButton;
    LinkedNode<BakedGood> bg = MainApplication.list.get(MainApplication.goodsEditId);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameLabel.setText("Name: " + bg.getContents().getName());
        originLabel.setText("Origin: " + bg.getContents().getOrigin());
        descLabel.setText("Description: " + bg.getContents().getDesc());
        try {
            InputStream stream = new FileInputStream(bg.getContents().getFilepath());
            Image image = new Image(stream);
            imgView.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void edit() throws IOException{
        bg.getContents().setName(Name.getText());
        bg.getContents().setOrigin(Origin.getText());
        bg.getContents().setDesc(Description.getText());
        OnBackButton();
    }

    public void OnBackButton() throws IOException {
        FXMLLoader menuView = new FXMLLoader(AddGoodsController.class.getResource("menu-view.fxml"));
        backButton.getScene().setRoot(menuView.load());
    }
}
