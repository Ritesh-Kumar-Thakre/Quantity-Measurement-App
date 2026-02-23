package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ================= LENGTH EQUALITY =================

    @Test
    public void testLength_FeetEqualsInches() {
        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        assertEquals(feet, inches);
    }

    @Test
    public void testLength_YardEqualsFeet() {
        Quantity<LengthUnit> yard =
                new Quantity<>(1.0, LengthUnit.YARDS);
        Quantity<LengthUnit> feet =
                new Quantity<>(3.0, LengthUnit.FEET);

        assertEquals(yard, feet);
    }

    @Test
    public void testLength_CentimeterEqualsInch() {
        Quantity<LengthUnit> cm =
                new Quantity<>(2.54, LengthUnit.CENTIMETERS);
        Quantity<LengthUnit> inch =
                new Quantity<>(1.0, LengthUnit.INCHES);

        assertEquals(cm, inch);
    }

    @Test
    public void testLength_NotEqual() {
        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> feet2 =
                new Quantity<>(2.0, LengthUnit.FEET);

        assertNotEquals(feet, feet2);
    }

    // ================= WEIGHT EQUALITY =================

    @Test
    public void testWeight_KgEqualsGram() {
        Quantity<WeightUnit> kg =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> gram =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        assertEquals(kg, gram);
    }

    @Test
    public void testWeight_KgEqualsPound() {
        Quantity<WeightUnit> kg =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> pound =
                new Quantity<>(2.2046226218, WeightUnit.POUND);

        assertEquals(kg, pound);
    }

    @Test
    public void testWeight_NotEqual() {
        Quantity<WeightUnit> kg =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> kg2 =
                new Quantity<>(2.0, WeightUnit.KILOGRAM);

        assertNotEquals(kg, kg2);
    }

    // ================= TYPE SAFETY =================

    @Test
    public void testLengthAndWeight_NotEqual() {
        Quantity<LengthUnit> length =
                new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<WeightUnit> weight =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertNotEquals(length, weight);
    }

    // ================= CONVERSION =================

    @Test
    public void testConversion_Length() {
        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                feet.convertTo(LengthUnit.INCHES);

        assertEquals(
                new Quantity<>(12.0, LengthUnit.INCHES),
                inches);
    }

    @Test
    public void testConversion_Weight() {
        Quantity<WeightUnit> kg =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                kg.convertTo(WeightUnit.GRAM);

        assertEquals(
                new Quantity<>(1000.0, WeightUnit.GRAM),
                gram);
    }

    @Test
    public void testConversion_RoundTrip() {
        Quantity<LengthUnit> original =
                new Quantity<>(3.0, LengthUnit.FEET);

        Quantity<LengthUnit> converted =
                original.convertTo(LengthUnit.INCHES)
                        .convertTo(LengthUnit.FEET);

        assertEquals(original, converted);
    }

    // ================= ADDITION =================

    @Test
    public void testAddition_LengthSameUnit() {
        Quantity<LengthUnit> result =
                new Quantity<>(1.0, LengthUnit.FEET)
                        .add(new Quantity<>(2.0, LengthUnit.FEET));

        assertEquals(
                new Quantity<>(3.0, LengthUnit.FEET),
                result);
    }

    @Test
    public void testAddition_LengthCrossUnit() {
        Quantity<LengthUnit> result =
                new Quantity<>(1.0, LengthUnit.FEET)
                        .add(new Quantity<>(12.0, LengthUnit.INCHES));

        assertEquals(
                new Quantity<>(2.0, LengthUnit.FEET),
                result);
    }

    @Test
    public void testAddition_WithTargetUnit() {
        Quantity<LengthUnit> result =
                new Quantity<>(1.0, LengthUnit.FEET)
                        .add(new Quantity<>(12.0, LengthUnit.INCHES),
                                LengthUnit.INCHES);

        assertEquals(
                new Quantity<>(24.0, LengthUnit.INCHES),
                result);
    }

    @Test
    public void testAddition_Weight() {
        Quantity<WeightUnit> result =
                new Quantity<>(1.0, WeightUnit.KILOGRAM)
                        .add(new Quantity<>(1000.0, WeightUnit.GRAM));

        assertEquals(
                new Quantity<>(2.0, WeightUnit.KILOGRAM),
                result);
    }

    @Test
    public void testAddition_WithZero() {
        Quantity<LengthUnit> result =
                new Quantity<>(5.0, LengthUnit.FEET)
                        .add(new Quantity<>(0.0, LengthUnit.INCHES));

        assertEquals(
                new Quantity<>(5.0, LengthUnit.FEET),
                result);
    }

    @Test
    public void testAddition_Negative() {
        Quantity<LengthUnit> result =
                new Quantity<>(5.0, LengthUnit.FEET)
                        .add(new Quantity<>(-2.0, LengthUnit.FEET));

        assertEquals(
                new Quantity<>(3.0, LengthUnit.FEET),
                result);
    }

    // ================= EXCEPTIONS =================

    @Test
    public void testNullUnit_Throws() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Quantity<>(1.0, null)
        );
    }

    @Test
    public void testNaN_Throws() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Quantity<>(Double.NaN, LengthUnit.FEET)
        );
    }

    @Test
    public void testInfinity_Throws() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Quantity<>(Double.POSITIVE_INFINITY, LengthUnit.FEET)
        );
    }

    @Test
    public void testAddNull_Throws() {
        Quantity<LengthUnit> length =
                new Quantity<>(1.0, LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> length.add(null)
        );
    }

    @Test
    public void testAddWithTargetNull_Throws() {
        Quantity<LengthUnit> length =
                new Quantity<>(1.0, LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> length.add(
                        new Quantity<>(1.0, LengthUnit.FEET),
                        null)
        );
    }
}