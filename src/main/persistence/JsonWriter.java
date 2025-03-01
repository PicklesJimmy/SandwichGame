package persistence;
import model.Sandwich;
import org.json.JSONObject;


import java.io.*;

// Represents a JSON writer that writes JSON representation of the current sandwich to file
// Attribution: this code structure is based on the JsonSerializationDemo
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    // Attribution: this code structure is based on the JsonSerializationDemo
    public JsonWriter(String destination) {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    // Attribution: this code structure is based on the JsonSerializationDemo
    public void open() throws FileNotFoundException {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of sandwich to file
    // Attribution: this code structure is based on the JsonSerializationDemo
    public void write(Sandwich sd) {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    // Attribution: this code structure is based on the JsonSerializationDemo
    public void close() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    // Attribution: this code structure is based on the JsonSerializationDemo
    private void saveToFile(String json) {
        // stub
    }
}
