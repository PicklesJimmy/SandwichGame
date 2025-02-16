package model;

/*  Represents a single ingredient that have a certain quality attached to them */ 
public class Ingredients {
    
    // EFFECTS: constructs an Ingredients object with a given name, and a quality of null.
    public Ingredients(String name) {
        // stub
    }

    // REQUIRES: 1<= val <= 2 
    // MODIFIES: this
    // EFFECTS: sets the quality of ingredient to "uncooked"(1) or "cooked"(2) 
    // depending on the value the player entered.
    protected void setQuality(int val) {
        // stub
    }
        
    

    // EFFECTS: return the quality of the ingredient, return null if there is no quality assigned
    public String getQuality() {
        return ""; // stub
    }

    // EFFECTS: return the name of the ingredient,
    public String getName() {
        return ""; // stub
    }

}
