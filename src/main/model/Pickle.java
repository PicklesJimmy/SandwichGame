package model;

public class Pickle extends Ingredients{

    // EFFECTS: constructs a Pickle object with a given name, and a quality of null.
    public Pickle(String name) {
        super(name);
    }

    // REQUIRES: 1<= val <= 2 
    // MODIFIES: this
    // EFFECTS: sets the quality of Pickle to "dill"(1) or "sweet"(2) depending on the value the player entered.     
    @Override
    protected void setQuality(int val) {
       // stub    
    }

}
