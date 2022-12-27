package bnmh.ca2.models;

import java.io.Serializable;

public class Ingredient implements Serializable {



    //fields
    private Recipe parent;
    private Ingredient nextIngredient;
    private String name;
    private String desc;
    private int calories;



    //constructor
    public Ingredient(Recipe parent, Ingredient nextIngredient, String name, String desc, int calories) {
        setParent(parent);
        setNextIngredient(nextIngredient);
        setName(name);
        setDesc(desc);
        setCalories(calories);
    }



    //getters
    public Recipe getParent() {
        return parent;
    }

    public Ingredient getNextIngredient() {
        return nextIngredient;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getCalories() {
        return calories;
    }



    //setters
    public void setParent(Recipe parent) {
        this.parent = parent;
    }

    public void setNextIngredient(Ingredient nextIngredient) {
        this.nextIngredient = nextIngredient;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }



}
