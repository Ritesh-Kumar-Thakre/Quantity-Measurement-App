package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WeightTest {

    @Test
    public void testEquality_KgToGram() {
        assertEquals(
                new Weight(1.0, WeightUnit.KILOGRAM),
                new Weight(1000.0, WeightUnit.GRAM)
        );
    }

    @Test
    public void testEquality_KgToPound() {
        assertEquals(
                new Weight(1.0, WeightUnit.KILOGRAM),
                new Weight(2.2046226218, WeightUnit.POUND)
        );
    }

    @Test
    public void testConversion_KgToGram() {
        Weight result =
                new Weight(1.0, WeightUnit.KILOGRAM)
                        .convertTo(WeightUnit.GRAM);

        assertEquals(
                new Weight(1000.0, WeightUnit.GRAM),
                result);
    }

    @Test
    public void testAddition_KgPlusGram() {
        Weight result =
                new Weight(1.0, WeightUnit.KILOGRAM)
                        .add(new Weight(500.0, WeightUnit.GRAM));

        assertEquals(
                new Weight(1.5, WeightUnit.KILOGRAM),
                result);
    }

    @Test
    public void testAddition_WithTargetUnit() {
        Weight result =
                new Weight(1.0, WeightUnit.KILOGRAM)
                        .add(new Weight(1.0, WeightUnit.KILOGRAM),
                                WeightUnit.GRAM);

        assertEquals(
                new Weight(2000.0, WeightUnit.GRAM),
                result);
    }

    @Test
    public void testInvalidUnit_Throws() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Weight(1.0, null)
        );
    }

    @Test
    public void testNaNValue_Throws() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Weight(Double.NaN, WeightUnit.KILOGRAM)
        );
    }
}