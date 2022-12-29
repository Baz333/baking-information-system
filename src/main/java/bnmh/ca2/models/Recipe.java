package bnmh.ca2.models;

import java.io.Serializable;

public class Recipe implements Serializable {



    //fields
    private BakedGood parent;
    private Recipe nextRecipe;
    private String name;
    private String desc;



    //constructor
    public Recipe(BakedGood parent, Recipe nextRecipe, String name, String desc) {
        setParent(parent);
        setNextRecipe(nextRecipe);
        setName(name);
        setDesc(desc);
    }



    //getters
    public BakedGood getParent() {
        return parent;
    }

    public Recipe getNextRecipe() {
        return nextRecipe;
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }



}
