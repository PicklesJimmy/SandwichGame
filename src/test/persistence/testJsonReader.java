package persistence;

import model.Ingredients;
import model.Sandwich;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class testJsonReader extends JsonTest {
   
    // Attribution: this code structure is based on the JsonSerializationDemo
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Sandwich sd = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    // Attribution: this code structure is based on the JsonSerializationDemo
    @Test
    void testReaderEmptySandwich() {
        JsonReader reader = new JsonReader("./data/testReaderEmptySandwich.json");
        try {
            Sandwich sd = reader.read();
            assertEquals(0, sd.viewIngredients().size());
        } catch (IOException e) {
            e.printStackTrace();
            fail("Couldn't read from file");
        }
    }

    // Attribution: this code structure is based on the JsonSerializationDemo
    @Test
    void testReaderGeneralSandwich() {

        JsonReader reader = new JsonReader("./data/testReaderGeneralSandwich.json");
        try {
            Sandwich sd = reader.read();
            
            List<Ingredients> ingreds = sd.viewIngredients();
            assertEquals(3, ingreds.size());
            checkSandwich(sd.viewIngredients(), sd);
            assertEquals(3, sd.viewIngredients().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}