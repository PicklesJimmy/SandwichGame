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
        this.source = source;
    }

    // EFFECTS: reads Sandwich from file and returns it;
    // throws IOException if an error occurs reading data from file
    // Attribution: this code structure is based on the JsonSerializationDemo
    public Sandwich read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseSandwich(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    // Attribution: this code structure is based on the JsonSerializationDemo
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses sandwich from JSON object and returns it
    // Attribution: this code structure is based on the JsonSerializationDemo
    private Sandwich parseSandwich(JSONObject jsonObject) {
        Sandwich sd = new Sandwich();
        addIngredients(sd, jsonObject);
        return sd;
    }
    

    // MODIFIES: sd
    // EFFECTS: parses ingredients from JSON object and adds them to sandwich
    // Attribution: this code structure is based on the JsonSerializationDemo
    private void addIngredients(Sandwich sd, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Ingredients");
        for (Object json : jsonArray) {
            JSONObject nextIngred = (JSONObject) json;
            addIngred(sd, nextIngred);
        }
    }

    // MODIFIES: sd
    // EFFECTS: parses a single ingredient from JSON object and adds it to sandwich
    // Attribution: this code structure is based on the JsonSerializationDemo
    private void addIngred(Sandwich sd, JSONObject jsonObject) {
        Integer quality = jsonObject.getInt("quality");
        String name = jsonObject.getString("name");

        if (name.equals("Bacon")) {
            Bacon b = new Bacon(quality);
            sd.addIngredient(b);
        } else {
            Pickle p = new Pickle(quality);
            sd.addIngredient(p);
        }
    }
}
