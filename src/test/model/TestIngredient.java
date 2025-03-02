package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestIngredient {
    private Bacon testB;
    private Pickle testP;
    private Ingredients testI;
    private Bacon testNull1;
    private Pickle testNull2;
    private Bacon testB2;
    private Pickle testP2;
    private Ingredients testI2;

    @BeforeEach
    void runBefore() {
        testB = new Bacon(1);
        testP = new Pickle(1);
        testI = new Ingredients(1);
        testB2 = new Bacon(2);
        testP2 = new Pickle(2);
        testI2 = new Ingredients(2);
        testNull1 = new Bacon(3);
        testNull2 = new Pickle(3);

    }

    @Test
    void testConstructor() {
        assertNull(testNull1.getQuality());
        assertNull(testNull2.getQuality());
        assertEquals(testB.getQuality(), "Raw");
        assertEquals(testP.getQuality(), "Dill");
    }

    @Test
    void testBaconSetQuality() {
        testB.setQuality(1);
        assertEquals(testB.getQuality(), "Raw");
        testB.setQuality(2);
        assertEquals(testB.getQuality(), "Cooked");
        testB.setQuality(1);
        testB.setQuality(1);
        assertEquals(testB.getQuality(), "Raw");
        testB.setQuality(2);
        testB.setQuality(2);
        assertEquals(testB.getQuality(), "Cooked");
        assertEquals(testB2.getQuality(), "Cooked");
    }

    @Test
    void testPickleSetQuality() {
        testP.setQuality(1);
        assertEquals(testP.getQuality(), "Dill");
        testP.setQuality(2);
        assertEquals(testP.getQuality(), "Sweet");
        testP.setQuality(2);
        testP.setQuality(2);
        assertEquals(testP.getQuality(), "Sweet");
        assertEquals(testP2.getQuality(), "Sweet");


    }

    @Test
    void testIngredientSetQuality() {
        testI.setQuality(1);
        assertEquals(testI.getQuality(), "Uncooked");
        testI.setQuality(2);
        assertEquals(testI.getQuality(), "Cooked");
        testI.setQuality(1);
        testI.setQuality(1);
        assertEquals(testI.getQuality(), "Uncooked");
        testI.setQuality(2);
        testI.setQuality(2);
        assertEquals(testI.getQuality(), "Cooked");
        testI.setQuality(3);
        assertNull(testI.getQuality());
        assertEquals(testI2.getQuality(), "Cooked");

    }

    @Test
    void testReturnName() {
        assertEquals(testB.getName(), "Bacon");
        assertEquals(testP.getName(), "Pickle");
        assertEquals(testI.getName(), "Ingredient");

    }
}
