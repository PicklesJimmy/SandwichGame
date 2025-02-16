package model;

/*  Represents a single ingredient that have a certain quality attached to them */ 
public class Ingredients {
    protected String quality;
    private String name;
    
    // EFFECTS: constructs an Ingredients object with a given name, and a quality of null.
    public Ingredients(String name) {
        this.name = name;
        quality = null;
    }

    // REQUIRES: 1<= val <= 2 
    // MODIFIES: this
    // EFFECTS: sets the quality of ingredient to "uncooked"(1) or "cooked"(2) 
    // depending on the value the player entered.
    protected void setQuality(int val) {
        if (val == 1) {
            quality = "uncooked";
        } if (val == 2) {
            quality = "cooked";
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

    // EFFECTS: return the name of the ingredient,
    public String getName() {
        return name;
    }

}
