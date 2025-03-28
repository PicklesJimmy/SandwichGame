package model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSandwich {
    private Sandwich testSand;
    private Bacon testB;
    private Pickle testP;

    @BeforeEach
    void runBefore() {
        testSand = new Sandwich();
        testB = new Bacon(1);
        testP = new Pickle(1);
    }

    @Test
    void testConstructor() {
        assertTrue(testSand.viewIngredients().isEmpty());
    }

    @Test
    void testAddIngredient() {
        testSand.addIngredient(testB);
        assertEquals(testSand.viewIngredients().size(), 1);
        testSand.addIngredient(testP);
        assertEquals(testSand.viewIngredients().size(), 2);
    }

    @Test
    void testRemoveIngredientEmptyList() {
        assertFalse(testSand.removeIngredients());

    }

    @Test
    void testViewIngredientsEmpty() {
        assertTrue(testSand.viewIngredients().isEmpty());
    }

    @Test
    void testViewIngredients() {
        testSand.addIngredient(testB);
        testSand.addIngredient(testP);
        assertEquals(testSand.viewIngredients().size(), 2);
        assertEquals(testSand.viewIngredients().get(0), testB);
        assertEquals(testSand.viewIngredients().get(1), testP);
        testSand.addIngredient(testP);
        assertEquals(testSand.viewIngredients().get(2), testP);
        assertEquals(testSand.viewIngredients().size(), 3);

    }

    @Test
    void testViewIngredientsAndQuality() {
        testSand.addIngredient(testB);
        testSand.addIngredient(testP);
        assertEquals(testSand.viewIngredQuality().size(), 2);
        assertEquals(testSand.viewIngredQuality().get(0), "Raw Bacon");
        assertEquals(testSand.viewIngredQuality().get(1), "Dill Pickle");

    }

    @Test
    void testRemoveIngredientRemove2() {
        testSand.addIngredient(testB);
        testSand.addIngredient(testP);
        assertTrue(testSand.removeIngredients());
        assertEquals(testSand.viewIngredients().size(), 1);
        assertTrue(testSand.removeIngredients());
        assertTrue(testSand.viewIngredients().isEmpty());

    }

    @Test
    void testRemoveIngredientRepeat() {
        testSand.addIngredient(testB);
        assertTrue(testSand.removeIngredients());
        assertTrue(testSand.viewIngredients().isEmpty());
        testSand.addIngredient(testP);
        assertTrue(testSand.removeIngredients());
        assertTrue(testSand.viewIngredients().isEmpty());
    }

    @Test
    void testRemoveIngredientSame() {
        testSand.addIngredient(testB);
        testSand.addIngredient(testB);
        assertTrue(testSand.removeIngredients());
        assertTrue(testSand.removeIngredients());
        assertTrue(testSand.viewIngredients().isEmpty());
    }


}
