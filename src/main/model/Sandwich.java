package model;

import java.util.List;
import java.util.ArrayList;

/*  Represents a sandwich having a list of ingredients inside the sandwich, 
 and the type of bread used for the sandwich. */ 
public class Sandwich {
    private List<Ingredients> ingredientsList;

    // EFFECTS: constructs an empty list of ingredients.
    public Sandwich() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: add the ingredient to the list of ingredients
    public void addIngredient(Ingredients ingredient) {
        // stub
    }

    // EFFECTS: return the list of ingredients 
    public List<Ingredients> viewIngredients() {
        return null; // stub
    }

    // MODIFIES: this
    // EFFECTS: remove the last ingredient added from the list of ingredients, return null if list is empty
    public void removeIngredients(List<Ingredients> list) {
        // stub
    } 


}
