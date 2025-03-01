package persistence;

import model.Ingredients;
import model.Sandwich;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Attribution: this code structure is based on the JsonSerializationDemo
public class JsonTest {
    protected void checkSandwich(List<Ingredients> ingreds, Sandwich sandwich) {
        assertEquals(ingreds, sandwich.viewIngredients());
    }
}
