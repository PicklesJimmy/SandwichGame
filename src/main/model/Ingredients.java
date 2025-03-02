package model;

import org.json.JSONObject;
import persistence.Writable;

/*  Represents a single ingredient that have a certain quality and name attached to them */ 
public class Ingredients implements Writable {
    protected String quality;
    private Integer input;
    private String name;
    
    // REQUIRES: 1<= input <= 2 
    // MODIFIES: this
    // EFFECTS: constructs an Ingredients object with a given quality between 1(raw) and 2(cooked) and a name.
    public Ingredients(int input) {
        setQuality(input);
        this.input = input;
        this.name = "Ingredient";

    }

    // MODIFIES: this
    // EFFECTS: sets the quality of ingredient to "uncooked"(1) or "cooked"(2) 
    // depending on the value the player entered. Else, the quality is set to null.
    protected void setQuality(int val) {
        if (val == 1) {
            quality = "Uncooked";
        } else if (val == 2) {
            quality = "Cooked";
        } else {
            quality = null;
        }
    }

    // EFFECTS: returns the name of the ingredient.  
    public String getName() {
        return name;
    }
        

    // EFFECTS: return the quality of the ingredient, return null if there is no quality assigned
    public String getQuality() {
        if (quality != null) {
            return quality;
        } else {
            return null;
        }
    }

    // EFFECTS: returns the Ingredient as JSON object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("quality", input);
        json.put("name", name);

        return json;
    }

}
