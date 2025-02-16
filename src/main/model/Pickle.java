package model;

public class Pickle extends Ingredients{

    // REQUIRES: 1<= input <= 2 
    // MODIFIES: this
    // EFFECTS: constructs a Pickle object with  with a given quality between 1(raw) and 2(cooked).
    public Pickle(int input) {
        super(input);
        setQuality(input);
    }

    // REQUIRES: 1<= val <= 2 
    // MODIFIES: this
    // EFFECTS: sets the quality of Pickle to "dill"(1) or "sweet"(2) depending on the value the player entered.     
    @Override
    protected void setQuality(int val) {
        if (val == 1) {
            quality = "dill";
        } if (val == 2) {
            quality = "sweet";
        } 
    }
}
