package persistence;

import model.Ingredients;
import model.Sandwich;
import model.Bacon;
import model.Pickle;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {
    private Bacon testB = new Bacon(1);
    private Pickle testP = new Pickle(2);
    private Ingredients testI = new Ingredients(1);

    // Attribution: this code structure is based on the JsonSerializationDemo
    @Test
    void testWriterInvalidFile() {
        try {
            Sandwich sd = new Sandwich();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    // Attribution: this code structure is based on the JsonSerializationDemo
    @Test
    void testWriterEmptySandwich() {
        try {
            Sandwich sd = new Sandwich();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptySandwich.json");
            writer.open();
            writer.write(sd);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptySandwich.json");
            sd = reader.read();
            assertEquals(0, sd.viewIngredients().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    // Attribution: this code structure is based on the JsonSerializationDemo
    @Test
    void testWriterGeneralSandwich() {
        try {
            Sandwich sd = new Sandwich();
            sd.addIngredient(testB);
            sd.addIngredient(testP);
            sd.addIngredient(testI);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralSandwich.json");
            writer.open();
            writer.write(sd);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralSandwich.json");
            sd = reader.read();
            List<Ingredients> ingreds = sd.viewIngredients();
            assertEquals(3, ingreds.size());
            checkSandwich(sd.viewIngredients(), sd);

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}