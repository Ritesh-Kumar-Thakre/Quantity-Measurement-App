package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VolumeTest {

    // -------- EQUALITY --------

    @Test
    public void testEquality_LitreToMillilitre() {
        assertEquals(
            new Quantity<>(1.0, VolumeUnit.LITRE),
            new Quantity<>(1000.0, VolumeUnit.MILLILITRE)
        );
    }

    @Test
    public void testEquality_LitreToGallon() {
        assertEquals(
            new Quantity<>(3.78541, VolumeUnit.LITRE),
            new Quantity<>(1.0, VolumeUnit.GALLON)
        );
    }

    @Test
    public void testVolumeVsLength_NotEqual() {
        assertNotEquals(
            new Quantity<>(1.0, VolumeUnit.LITRE),
            new Quantity<>(1.0, LengthUnit.FEET)
        );
    }

    // -------- CONVERSION --------

    @Test
    public void testConversion_LitreToMillilitre() {
        Quantity<VolumeUnit> result =
                new Quantity<>(1.0, VolumeUnit.LITRE)
                        .convertTo(VolumeUnit.MILLILITRE);

        assertEquals(new Quantity<>(1000.0, VolumeUnit.MILLILITRE), result);
    }

    @Test
    public void testConversion_GallonToLitre() {
        Quantity<VolumeUnit> result =
                new Quantity<>(1.0, VolumeUnit.GALLON)
                        .convertTo(VolumeUnit.LITRE);

        assertEquals(
                new Quantity<>(3.78541, VolumeUnit.LITRE),
                result);
    }

    // -------- ADDITION --------

    @Test
    public void testAddition_LitrePlusMillilitre() {
        Quantity<VolumeUnit> result =
                new Quantity<>(1.0, VolumeUnit.LITRE)
                        .add(new Quantity<>(500.0, VolumeUnit.MILLILITRE));

        assertEquals(
                new Quantity<>(1.5, VolumeUnit.LITRE),
                result);
    }

    @Test
    public void testAddition_WithTargetUnit() {
        Quantity<VolumeUnit> result =
                new Quantity<>(1.0, VolumeUnit.LITRE)
                        .add(new Quantity<>(1.0, VolumeUnit.GALLON),
                                VolumeUnit.MILLILITRE);

        assertEquals(
                new Quantity<>(4785.41, VolumeUnit.MILLILITRE),
                result);
    }
}