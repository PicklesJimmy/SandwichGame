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
            EventLog.getInstance().logEvent(new Event("Raw Bacon Added."));
        } else if (val == 2) {
            quality = "Cooked";
            EventLog.getInstance().logEvent(new Event("Cooked Bacon Added."));
        } else {
            quality = null;
            EventLog.getInstance().logEvent(new Event("No Bacon Added."));
        }
    }    

    // EFFECTS: returns the name of the Bacon.  
    public String getName() {
        return name; 
    }
    
    // EFFECTS: returns the Bacon as JSON object
    // Attribution: this code structure is based on the JsonSerializationDemo
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("quality", input);
        return json;
    }
}
