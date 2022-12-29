package bnmh.ca2.controllers;

import bnmh.ca2.models.BakedGood;
import bnmh.ca2.models.Recipe;
import bnmh.ca2.utils.LinkedNode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
    private ListView<String> recipeList;
    @FXML
    private Button addRecipeButton;
    @FXML
    private Button backButton;
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

        repopulate();

    }

    public void repopulate() {

        recipeList.getItems().clear();

        Recipe temp = MenuController.bg.getHead();
        int i = 1;
        while (temp != null) {

            recipeList.getItems().add(i + ": " +
                    temp.getName() + " (" +
                    temp.getDesc() + ")");

            System.out.println(temp.getName() + " (" +
                    temp.getDesc() + ")");
            i++;
            temp = temp.getNextRecipe();

        }

    }

    public void OnAddRecipeButton() throws IOException {
        FXMLLoader addRecipeView = new FXMLLoader(GoodsDetailsController.class.getResource("add-recipe-view.fxml"));
        addRecipeButton.getScene().setRoot(addRecipeView.load());
    }

    public void OnBackButton() throws IOException {
        FXMLLoader menuView = new FXMLLoader(GoodsDetailsController.class.getResource("menu-view.fxml"));
        backButton.getScene().setRoot(menuView.load());
    }

}