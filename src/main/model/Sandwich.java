package model;

import java.util.List;
import java.util.ArrayList;

/*  Represents a sandwich having a list of ingredients inside the sandwich, 
 and the type of bread used for the sandwich. */ 
public class Sandwich {
    private List<Ingredients> ingredientsList;

    // EFFECTS: constructs an empty list of ingredients.
    public Sandwich() {
        ingredientsList = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: add the ingredient to the list of ingredients
    public void addIngredient(Ingredients ingredient) {
        ingredientsList.add(ingredient);
    }

    // EFFECTS: return the list of ingredients,
    public List<Ingredients> viewIngredients() {
        return ingredientsList;
    }

    // MODIFIES: this
    // EFFECTS: remove the last ingredient added from the sandwich and return true, return false if list is empty
    public boolean removeIngredients() {
        if (ingredientsList.isEmpty()) {
            return false;
        } else {
            int last = ingredientsList.size() -1;
            ingredientsList.remove(last);
            return true;
        }
    } 


}
