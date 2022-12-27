package bnmh.ca2.controllers;

import bnmh.ca2.models.BakedGood;
import bnmh.ca2.models.Ingredient;
import bnmh.ca2.utils.GenericLinkedList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {



    public static GenericLinkedList<BakedGood> list = new GenericLinkedList<>();
    public static GenericLinkedList<Ingredient> ingList = new GenericLinkedList<>();

    //loads main menu
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Baking Info");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }



}