package bnmh.ca2.controllers;

import bnmh.ca2.models.Ingredient;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddIngredientsController {

    @FXML
    private Button backButton;
    @FXML
    private TextField nameText;
    @FXML
    private TextArea descText;
    @FXML
    private TextField calorieText;
    @FXML
    private Button addIngredientButton;

    public void initialize() {

        calorieText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[0-9]*")) {
                calorieText.setText(newValue.replaceAll("[^[0-9]]", ""));
            }
        });

    }

    public void OnAddIngredientButton() throws IOException {

        if(nameText.getText() != null && descText.getText() != null && calorieText.getText() != null) {

            Ingredient ing = new Ingredient(null, null, nameText.getText(), descText.getText(), Integer.parseInt(calorieText.getText()));
            MainApplication.ingList.add(ing);

            OnBackButton();

        }

    }

    public void OnBackButton() throws IOException {
        FXMLLoader menuView = new FXMLLoader(AddGoodsController.class.getResource("menu-view.fxml"));
        backButton.getScene().setRoot(menuView.load());
    }

}
