package persistence;

import model.Sandwich;
import model.Bacon;
import model.Pickle;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    // Attribution: this code structure is based on the JsonSerializationDemo
    public JsonReader(String source) {
        // stub
    }

    // EFFECTS: reads Sandwich from file and returns it;
    // throws IOException if an error occurs reading data from file
    // Attribution: this code structure is based on the JsonSerializationDemo
    public Sandwich read() throws IOException {
        return null; // stub 
    }

    // EFFECTS: reads source file as string and returns it
    // Attribution: this code structure is based on the JsonSerializationDemo
    private String readFile(String source) throws IOException {
       return null; // stub
    }

    // EFFECTS: parses sandwich from JSON object and returns it
    // Attribution: this code structure is based on the JsonSerializationDemo
    private Sandwich parseSandwich(JSONObject jsonObject) {
        return null; // stub
    }

    // MODIFIES: sd
    // EFFECTS: parses ingredients from JSON object and adds them to sandwich
    // Attribution: this code structure is based on the JsonSerializationDemo
    private void addIngredients(Sandwich sd, JSONObject jsonObject) {
       // stub
    }

    // MODIFIES: sd
    // EFFECTS: parses a single ingredient from JSON object and adds it to sandwich
    // Attribution: this code structure is based on the JsonSerializationDemo
    private void addIngred(Sandwich sd, JSONObject jsonObject) {
       // stub
    }
}
