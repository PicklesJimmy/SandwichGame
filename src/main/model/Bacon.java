package model;

public class Bacon extends Ingredients{

    // EFFECTS: constructs a Bacon object with a given name, and a quality of null.
    public Bacon(String name) {
        super(name);
    }

    // REQUIRES: 1<= val <= 2 
    // MODIFIES: this
    // EFFECTS: sets the quality of Bacon to "raw"(1) or "cooked"(2) depending on the value the player entered.   
    @Override
    protected void setQuality(int val) {
        if (val == 1) {
            quality = "raw";
        } if (val == 2) {
            quality = "cooked";
        }     
    }    
}
