package bnmh.ca2.controllers;

import bnmh.ca2.models.BakedGood;
import bnmh.ca2.models.Ingredient;
import bnmh.ca2.utils.LinkedNode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Locale;

public class SearchController {

    @FXML
    private Button backButton;
    @FXML
    private TextField searchText;
    @FXML
    private Button searchButton;
    @FXML
    private RadioButton nameRadio;
    @FXML
    private RadioButton descriptionRadio;
    @FXML
    private ListView bakedGoods;
    @FXML
    private ListView ingredients;

    public void OnSearchButton() {
        char[] temp = searchText.getText().toLowerCase(Locale.ROOT).toCharArray();
        int key = 0;
        for (char c : temp) {
            key += c;
        }
        key = key % 10;
        LinkedNode<BakedGood> bg = MainApplication.goodsHash[key].getHead();
        LinkedNode<Ingredient> ing = MainApplication.ingHash[key].getHead();

            if (bg != null) {
                if (bg.getContents().getName().matches(searchText.getText())) {
                bakedGoods.getItems().add(
                        bg.getContents().getName() + ": " +
                                bg.getContents().getDesc() + ", (Origin: " +
                                bg.getContents().getOrigin() + ")");

                System.out.println(bg.getContents().getName() + ": " +
                        bg.getContents().getDesc() + ", (Origin: " +
                        bg.getContents().getOrigin() + ")");
            }

            if (ing != null) {
                System.out.println("Not found");
                if (ing.getContents().getName().matches(searchText.getText())) {
                    ingredients.getItems().add(
                            ing.getContents().getName() + ": " +
                            ing.getContents().getDesc() + ", (Calories: " +
                            ing.getContents().getCalories() + ")");

                    System.out.println(bg.getContents().getName() + ": " +
                            ing.getContents().getDesc() + ", (Calories: " +
                            ing.getContents().getCalories() + ")");
                }
            }
        }
    }

    public void OnBackButton() throws IOException {
        FXMLLoader menuView = new FXMLLoader(AddGoodsController.class.getResource("menu-view.fxml"));
        backButton.getScene().setRoot(menuView.load());
    }
}
