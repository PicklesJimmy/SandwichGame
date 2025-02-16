package model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestIngredient {
    private Bacon testB;
    private Pickle testP;
    private Ingredients testI;

    @BeforeEach
    void runBefore() {
        testB = new Bacon("Bacon");
        testP = new Pickle("Pickle");
        testI = new Ingredients("Ingredient");
    }

    @Test
    void testConstructor() {
        assertNull(testB.getQuality());
        assertNull(testP.getQuality());
        assertEquals(testB.getName(), "Bacon");
        assertEquals(testP.getName(), "Pickle");
    }

    @Test
    void testBaconSetQuality() {
        testB.setQuality(1);
        assertEquals(testB.getQuality(), "raw");
        testB.setQuality(2);
        assertEquals(testB.getQuality(), "cooked");
        testB.setQuality(1);
        testB.setQuality(1);
        assertEquals(testB.getQuality(), "raw");
        testB.setQuality(2);
        testB.setQuality(2);
        assertEquals(testB.getQuality(), "cooked");

    }

    @Test
    void testPickleSetQuality() {
        testP.setQuality(1);
        assertEquals(testP.getQuality(), "dill");
        testP.setQuality(2);
        assertEquals(testP.getQuality(), "sweet");
        testP.setQuality(2);
        testP.setQuality(2);
        assertEquals(testP.getQuality(), "sweet");

    }

    @Test
    void testIngredientSetQuality() {
        testI.setQuality(1);
        assertEquals(testI.getQuality(), "uncooked");
        testI.setQuality(2);
        assertEquals(testI.getQuality(), "cooked");
        testI.setQuality(1);
        testI.setQuality(1);
        assertEquals(testI.getQuality(), "uncooked");
        testI.setQuality(2);
        testI.setQuality(2);
        assertEquals(testI.getQuality(), "cooked");
    }
}
