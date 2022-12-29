package bnmh.ca2.controllers;

import bnmh.ca2.models.BakedGood;
import bnmh.ca2.models.Ingredient;
import bnmh.ca2.utils.GenericLinkedList;
import bnmh.ca2.utils.LinkedNode;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {



    public static GenericLinkedList<BakedGood> list = new GenericLinkedList<>();
    public static GenericLinkedList<Ingredient> ingList = new GenericLinkedList<>();
    public static GenericLinkedList<BakedGood>[] goodsHash = new GenericLinkedList[10];
    public static GenericLinkedList<Ingredient>[] ingHash = new GenericLinkedList[10];

    //loads main menu
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Baking Info");
        stage.setScene(scene);
        stage.show();
        for(int i = 0; i < goodsHash.length; i++) {
            goodsHash[i] = new GenericLinkedList<>();
        }
        for(int i = 0; i < ingHash.length; i++) {
            ingHash[i] = new GenericLinkedList<>();
        }
    }

    public static void main(String[] args) {
        launch();
    }



}