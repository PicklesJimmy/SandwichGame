package model;

import java.util.List;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

/*  Represents a sandwich having a list of ingredients inside the sandwich, 
 and the type of bread used for the sandwich. */ 
public class Sandwich implements Writable {
    private List<Ingredients> ingredientsList;

    // EFFECTS: constructs an empty list of ingredients.
    public Sandwich() {
        ingredientsList = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: add the ingredient to the list of ingredients
    public void addIngredient(Ingredients ingredient) {
        ingredientsList.add(ingredient);
        // EventLog.getInstance().logEvent(new Event("Sandwich Ingredient Added."));
    }

    // EFFECTS: return the list of ingredients,
    public List<Ingredients> viewIngredients() {
        return ingredientsList;
    }

    // EFFECTS: return the list of ingredients, and their ingredients
    public List<String> viewIngredQuality() {
        EventLog.getInstance().logEvent(new Event("Ingredient List Viewed."));
        List<String> ingList = new ArrayList<>();
        for (Ingredients i : ingredientsList) {
            ingList.add(i.getQuality() + " " + i.getName());
        }
        return ingList;
    }

    // MODIFIES: this
    // EFFECTS: remove the last ingredient added from the sandwich and return true, return false if list is empty
    public boolean removeIngredients() {
        if (ingredientsList.isEmpty()) {
            // EventLog.getInstance().logEvent(new Event("Ingredient Remove Failed."));
            return false;
        } else {
            int last = ingredientsList.size() - 1;
            ingredientsList.remove(last);
            EventLog.getInstance().logEvent(new Event("Ingredient Removed."));
            return true;
        }
    } 
    
    // EFFECTS: returns the Sandwich as JSON object
    // Attribution: this code structure is based on the JsonSerializationDemo
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Ingredients", ingredToJson());
        return json;
    }

    // EFFECTS: returns ingredients in this sandwich as a JSON array
    // Attribution: this code structure is based on the JsonSerializationDemo
    private JSONArray ingredToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Ingredients i : ingredientsList) {
            jsonArray.put(i.toJson());
        }

        return jsonArray;
    }


}
