package model;

import java.util.List;
import java.util.ArrayList;

/*  Represents a sandwich having a list of ingredients inside the sandwich, 
 and the type of bread used for the sandwich. */ 
public class Sandwich {
    private List<Ingredients> ingredientsList;
    private Ingredients bread;


    // EFFECTS: constructs an empty list of ingredients.
    public Sandwich() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: add the ingredient to the list of ingredients
    public void addIngredient(Ingredients ingredient) {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: set the bread of sandwich to the specified bread
    public void setBread(Ingredients bread) {
        // stub
    }
    

    // EFFECTS: return the list of ingredients 
    public List<Ingredients> viewIngredients() {
        return null; // stub
    }

    // EFFECTS: return the bread used for the sandwich 
    public Ingredients viewBread() {
        return null; // stub
    }
}
