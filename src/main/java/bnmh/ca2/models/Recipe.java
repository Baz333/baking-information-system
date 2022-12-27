package bnmh.ca2.models;

import java.io.Serializable;

public class Recipe implements Serializable {



    //fields
    private BakedGood parent;
    private Recipe nextRecipe;
    private Ingredient head;
    private int calories;
    private String desc;



    //constructor
    public Recipe(BakedGood parent, Recipe nextRecipe, Ingredient head, int calories, String desc) {
        setParent(parent);
        setNextRecipe(nextRecipe);
        setHead(head);
        setCalories(calories);
        setDesc(desc);
    }



    //getters
    public BakedGood getParent() {
        return parent;
    }

    public Recipe getNextRecipe() {
        return nextRecipe;
    }

    public Ingredient getHead() {
        return head;
    }

    public int getCalories() {
        return calories;
    }

    public String getDesc() {
        return desc;
    }



    //setters
    public void setParent(BakedGood parent) {
        this.parent = parent;
    }

    public void setNextRecipe(Recipe nextRecipe) {
        this.nextRecipe = nextRecipe;
    }

    public void setHead(Ingredient head) {
        this.head = head;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }



}
