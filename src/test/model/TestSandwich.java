package model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSandwich {
    private Sandwich testSand;
    private Ingredients testB;
    private Ingredients testP;

    @BeforeEach
    void runBefore() {
        testSand = new Sandwich();
        testB = new Ingredients("Bacon");
        testP = new Ingredients("Pickle");
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
