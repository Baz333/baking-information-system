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
    private ListView bakedGoods = new ListView<>();
    @FXML
    private ListView ingredients = new ListView<>();

    public void OnSearchButton() {
        int key = 0;
        System.out.println(searchText.getText());
        char[] temp = searchText.getText().toLowerCase(Locale.ROOT).toCharArray();
        for (char c : temp) {
            key += c;
        }
        key = key % MainApplication.ingHash.length;
        System.out.println(key);
        LinkedNode<BakedGood> bg = MainApplication.goodsHash[key].getHead();
        LinkedNode<Ingredient> ing = MainApplication.ingHash[key].getHead();
        if (bg != null) {
            System.out.println(bg);
            searchBakedGood(key);
        }else if (ing != null){
            System.out.println(ing);
            searchIngredient(key);
        }
    }

    public void searchBakedGood(int key) {
        LinkedNode<BakedGood> bg = MainApplication.goodsHash[key].getHead();
        bakedGoods.getItems().add(
                bg.getContents().getName() + ": " +
                        bg.getContents().getDesc() + ", (Origin: " +
                        bg.getContents().getOrigin() + ")");

        System.out.println(bg.getContents().getName() + ": " +
                bg.getContents().getDesc() + ", (Origin: " +
                bg.getContents().getOrigin() + ")");
    }

    public void searchIngredient(int key) {
        LinkedNode<Ingredient> ing = MainApplication.ingHash[key].getHead();
        ingredients.getItems().add(
                ing.getContents().getName() + ": " +
                        ing.getContents().getDesc() + ", (Calories: " +
                        ing.getContents().getCalories() + ")");

        System.out.println(ing.getContents().getName() + ": " +
                ing.getContents().getDesc() + ", (Calories: " +
                ing.getContents().getCalories() + ")");
    }

    public void OnBackButton() throws IOException {
        FXMLLoader menuView = new FXMLLoader(AddGoodsController.class.getResource("menu-view.fxml"));
        backButton.getScene().setRoot(menuView.load());
    }
}
