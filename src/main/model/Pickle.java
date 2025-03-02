package model;

import org.json.JSONObject;

/*  Represents a single pickle that have a certain quality and name attached to them */ 
public class Pickle extends Ingredients {
    private String name;
    private Integer input;

    // REQUIRES: 1<= input <= 2 
    // MODIFIES: this
    // EFFECTS: constructs a Pickle object with  with a given quality between 1(raw) and 2(cooked) and a name.
    public Pickle(int input) {
        super(input);
        this.input = input;
        setQuality(input);
        name = "Pickle";
    }

    // MODIFIES: this
    // EFFECTS: sets the quality of Pickle to "dill"(1) or "sweet"(2) depending on the value the player entered.     
    @Override
    protected void setQuality(int val) {
        if (val == 1) {
            quality = "Dill";
        } else if (val == 2) {
            quality = "Sweet";
        } else {
            quality = null;
        }
    }

    // EFFECTS: returns the name of the pickle.  
    public String getName() {
        return name;
    }
    
    // EFFECTS: returns the Pickle as JSON object
    // Attribution: this code structure is based on the JsonSerializationDemo
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("quality", input);
        return json;
    }
}
