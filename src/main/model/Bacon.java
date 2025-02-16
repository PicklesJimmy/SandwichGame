package model;

public class Bacon extends Ingredients{

    // REQUIRES: 1<= input <= 2 
    // MODIFIES: this
    // EFFECTS: constructs a Bacon object with a given quality between 1(raw) and 2(cooked).
    public Bacon(int input) {
        super(input);
        setQuality(input);
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
