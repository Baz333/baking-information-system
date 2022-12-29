package bnmh.ca2.controllers;

import bnmh.ca2.models.BakedGood;
import bnmh.ca2.models.Ingredient;
import bnmh.ca2.utils.GenericLinkedList;
import bnmh.ca2.utils.LinkedNode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.*;

public class MenuController {



    @FXML
    private ListView<String> goodsList = new ListView<>();
    @FXML
    private ListView<String> ingList = new ListView<>();
    @FXML
    private Button addGoodsButton;
    @FXML
    private Button addIngredientsButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button loadButton;
    @FXML
    private Button hashButton;
    public static BakedGood bg;

    public void initialize() {

        repopulateGL();
        repopulateIL();

        goodsList.setOnMouseClicked(click -> {
            if (click.getClickCount() == 2) {
                if (goodsList.getSelectionModel().getSelectedItem() != null) {
                    String uidSelected = goodsList.getSelectionModel().getSelectedItem();
                    uidSelected = uidSelected.substring(0, uidSelected.indexOf(":"));
                    System.out.println(uidSelected);
                    BakedGood temp = MainApplication.list.get((Integer.parseInt(uidSelected)) - 1).getContents();
                    bg = temp;
                    System.out.println(temp.getName());
                    FXMLLoader caseScene = new FXMLLoader(MenuController.class.getResource("baked-good-details.fxml"));
                    try {
                        goodsList.getScene().setRoot(caseScene.load());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

    }

    public void repopulateGL() {

        goodsList.getItems().clear();

        LinkedNode<BakedGood> temp = MainApplication.list.getHead();
        int i = 1;
        while (temp != null) {

            goodsList.getItems().add(i + ": " +
                    temp.getContents().getName() + ": " +
                    temp.getContents().getDesc() + ", (Origin: " +
                    temp.getContents().getOrigin() + ")");

            System.out.println(temp.getContents().getName() + ": " +
                    temp.getContents().getDesc() + ", (Origin: " +
                    temp.getContents().getOrigin() + ")");
            i++;
            temp = temp.getNext();

        }

    }

    public void repopulateIL() {

        ingList.getItems().clear();

        LinkedNode<Ingredient> temp = MainApplication.ingList.getHead();
        while (temp != null) {

            ingList.getItems().add(temp.getContents().getName() + ": " +
                    temp.getContents().getDesc() + ", (" +
                    temp.getContents().getCalories() + " calories)");

            System.out.println(temp.getContents().getName() + ": " +
                    temp.getContents().getDesc() + ", (" +
                    temp.getContents().getCalories() + " calories)");

            temp = temp.getNext();

        }

    }

    public String goodsFilename() {
        return "baking-system.xml";
    }

    public String ingredientsFilename() {
        return "ingredients-save.xml";
    }

    public String goodsHashFilename() {
        return "goods-hash-table.xml";
    }

    public String ingHashFilename() {
        return "ing-hash-table.xml";
    }

    public void OnAddGoodsButtonPressed() throws IOException {
        FXMLLoader addBakedGoodView = new FXMLLoader(MenuController.class.getResource("add-baked-good-view.fxml"));
        addGoodsButton.getScene().setRoot(addBakedGoodView.load());
    }

    public void OnAddIngredientsButtonPressed() throws IOException {
        FXMLLoader addIngredientView = new FXMLLoader(MenuController.class.getResource("add-ingredient-view.fxml"));
        addIngredientsButton.getScene().setRoot(addIngredientView.load());
    }

    public void OnSaveButton() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(goodsFilename()));
        ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream(ingredientsFilename()));
        ObjectOutputStream out3 = new ObjectOutputStream(new FileOutputStream(goodsHashFilename()));
        ObjectOutputStream out4 = new ObjectOutputStream(new FileOutputStream(ingHashFilename()));
        out.writeObject(MainApplication.list.getHead());
        out2.writeObject(MainApplication.ingList.getHead());
        out3.writeObject(MainApplication.goodsHash);
        out4.writeObject(MainApplication.ingHash);
        out.close();
        out2.close();
        out3.close();
        out4.close();
    }

    public void OnLoadButton() throws IOException {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(goodsFilename()));
            ObjectInputStream in2 = new ObjectInputStream(new FileInputStream(ingredientsFilename()));
            ObjectInputStream in3 = new ObjectInputStream(new FileInputStream(goodsHashFilename()));
            ObjectInputStream in4 = new ObjectInputStream(new FileInputStream(ingHashFilename()));
            MainApplication.list.setHead((LinkedNode<BakedGood>) in.readObject());
            MainApplication.ingList.setHead((LinkedNode<Ingredient>) in2.readObject());
            MainApplication.goodsHash = (GenericLinkedList<BakedGood>[]) in3.readObject();
            MainApplication.ingHash = (GenericLinkedList<Ingredient>[]) in4.readObject();
            in.close();
            in2.close();
            in3.close();
            in4.close();
            repopulateGL();
            repopulateIL();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void OnHashButton() {

        System.out.println("=====Hash Table goodsHash=====");
        for(int i = 0; i < MainApplication.goodsHash.length; i++) {
            System.out.println("---Chain " + i + "---");
            LinkedNode<BakedGood> temp = MainApplication.goodsHash[i].getHead();
            while(temp != null) {
                System.out.println(temp.getContents());
                temp = temp.getNext();
            }
            System.out.println("\n");
        }
        System.out.println("\n\n=====Hash Table ingHash=====");
        for(int i = 0; i < MainApplication.ingHash.length; i++) {
            System.out.println("---Chain " + i + "---");
            LinkedNode<Ingredient> temp = MainApplication.ingHash[i].getHead();
            while(temp != null) {
                System.out.println(temp.getContents());
                temp = temp.getNext();
            }
            System.out.println("\n");
        }

    }



}