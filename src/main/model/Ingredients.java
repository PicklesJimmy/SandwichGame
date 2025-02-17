package model;

/*  Represents a single ingredient that have a certain quality attached to them */ 
public class Ingredients {
    protected String quality;
    
    // REQUIRES: 1<= input <= 2 
    // MODIFIES: this
    // EFFECTS: constructs an Ingredients object with a given quality between 1(raw) and 2(cooked).
    public Ingredients(int input) {
        setQuality(input);
    }

    // MODIFIES: this
    // EFFECTS: sets the quality of ingredient to "uncooked"(1) or "cooked"(2) 
    // depending on the value the player entered. Else, the quality is set to null.
    protected void setQuality(int val) {
        if (val == 1) {
            quality = "uncooked";
        } else if (val == 2) {
            quality = "cooked";
        } else {
            quality = null;
        }
    }
        
    

    // EFFECTS: return the quality of the ingredient, return null if there is no quality assigned
    public String getQuality() {
        if (quality != null) {
            return quality;
        } else {
            return null;
        }
    }
}
