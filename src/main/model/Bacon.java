package model;

import org.json.JSONObject;

/*  Represents a single bacon that have a certain quality and a name attached to them */ 
public class Bacon extends Ingredients {
    private String name;
    private Integer input;

    // REQUIRES: 1<= input <= 2 
    // MODIFIES: this
    // EFFECTS: constructs a Bacon object with a given quality between 1(raw) and 2(cooked) and a name.
    public Bacon(int input) {
        super(input);
        this.input = input;
        setQuality(input);
        this.name = "Bacon";
    }

    // MODIFIES: this
    // EFFECTS: sets the quality of Bacon to "raw"(1) or "cooked"(2) depending on the value the player entered.   
    @Override
    protected void setQuality(int val) {
        if (val == 1) {
            quality = "Raw";
        } else if (val == 2) {
            quality = "Cooked";
        } else {
            quality = null;
        }
    }    

    // EFFECTS: returns the name of the Bacon.  
    public String getName() {
        return null; // stub
    }
    
    // EFFECTS: returns the Bacon as JSON object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("quality", input);
        return json;
    }
}
