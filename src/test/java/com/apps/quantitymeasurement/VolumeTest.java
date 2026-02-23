package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VolumeTest {

    // -------- EQUALITY --------

    @Test
    public void testEquality_LitreToLitre_SameValue() {
        assertEquals(
            new Quantity<>(1.0, VolumeUnit.LITRE),
            new Quantity<>(1.0, VolumeUnit.LITRE)
        );
    }

    @Test
    public void testEquality_LitreToLitre_DifferentValue() {
        assertNotEquals(
            new Quantity<>(1.0, VolumeUnit.LITRE),
            new Quantity<>(2.0, VolumeUnit.LITRE)
        );
    }

    @Test
    public void testEquality_LitreToMillilitre_EquivalentValue() {
        assertEquals(
            new Quantity<>(1.0, VolumeUnit.LITRE),
            new Quantity<>(1000.0, VolumeUnit.MILLILITRE)
        );
    }

    @Test
    public void testEquality_MillilitreToLitre_EquivalentValue() {
        assertEquals(
            new Quantity<>(1000.0, VolumeUnit.MILLILITRE),
            new Quantity<>(1.0, VolumeUnit.LITRE)
        );
    }

    @Test
    public void testEquality_LitreToGallon() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(3.78541, VolumeUnit.LITRE);

        Quantity<VolumeUnit> gallon =
                new Quantity<>(1.0, VolumeUnit.GALLON);

        assertEquals(litre, gallon);
    }

    @Test
    public void testEquality_GallonToLitre_EquivalentValue() {
        assertTrue(
            new Quantity<>(1.0, VolumeUnit.GALLON)
                .equals(new Quantity<>(3.78541, VolumeUnit.LITRE))
        );
    }

    @Test
    public void testEquality_MillilitreToGallon_EquivalentValue() {

        Quantity<VolumeUnit> ml =
                new Quantity<>(3785.41, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> gallon =
                new Quantity<>(1.0, VolumeUnit.GALLON);

        assertEquals(ml, gallon);
    }

    // -------- INCOMPATIBILITY --------

    @Test
    public void testVolumeVsLength_Incompatible() {
        assertNotEquals(
            new Quantity<>(1.0, VolumeUnit.LITRE),
            new Quantity<>(1.0, LengthUnit.FEET)
        );
    }

    @Test
    public void testVolumeVsWeight_Incompatible() {
        assertNotEquals(
            new Quantity<>(1.0, VolumeUnit.LITRE),
            new Quantity<>(1.0, WeightUnit.KILOGRAM)
        );
    }

    // -------- CONVERSION --------

    @Test
    public void testConversion_LitreToMillilitre() {
        Quantity<VolumeUnit> result =
            new Quantity<>(1.0, VolumeUnit.LITRE).convertTo(VolumeUnit.MILLILITRE);
        assertEquals(new Quantity<>(1000.0, VolumeUnit.MILLILITRE), result);
    }

    @Test
    public void testConversion_MillilitreToLitre() {
        Quantity<VolumeUnit> result =
            new Quantity<>(1000.0, VolumeUnit.MILLILITRE).convertTo(VolumeUnit.LITRE);
        assertEquals(new Quantity<>(1.0, VolumeUnit.LITRE), result);
    }

    @Test
    public void testConversion_LitreToGallon() {
        Quantity<VolumeUnit> result =
            new Quantity<>(3.78541, VolumeUnit.LITRE).convertTo(VolumeUnit.GALLON);
        assertTrue(result.equals(new Quantity<>(1.0, VolumeUnit.GALLON)));
    }

    @Test
    public void testConversion_GallonToLitre() {
        Quantity<VolumeUnit> result =
            new Quantity<>(1.0, VolumeUnit.GALLON).convertTo(VolumeUnit.LITRE);
        assertTrue(result.equals(new Quantity<>(3.78541, VolumeUnit.LITRE)));
    }

    @Test
    public void testConversion_SameUnit() {
        Quantity<VolumeUnit> result =
            new Quantity<>(5.0, VolumeUnit.LITRE).convertTo(VolumeUnit.LITRE);
        assertEquals(new Quantity<>(5.0, VolumeUnit.LITRE), result);
    }

    // -------- ADDITION --------

    @Test
    public void testAddition_SameUnit_LitrePlusLitre() {
        Quantity<VolumeUnit> result =
            new Quantity<>(1.0, VolumeUnit.LITRE)
                .add(new Quantity<>(2.0, VolumeUnit.LITRE));
        assertEquals(new Quantity<>(3.0, VolumeUnit.LITRE), result);
    }

    @Test
    public void testAddition_CrossUnit_LitrePlusMillilitre() {
        Quantity<VolumeUnit> result =
            new Quantity<>(1.0, VolumeUnit.LITRE)
                .add(new Quantity<>(500.0, VolumeUnit.MILLILITRE));
        assertEquals(new Quantity<>(1.5, VolumeUnit.LITRE), result);
    }

    @Test
    public void testAddition_WithTargetUnit() {
        Quantity<VolumeUnit> result =
            new Quantity<>(1.0, VolumeUnit.LITRE)
                .add(new Quantity<>(1.0, VolumeUnit.GALLON),
                     VolumeUnit.MILLILITRE);
        assertTrue(result.equals(new Quantity<>((1.0 + 3.78541) * 1000.0, VolumeUnit.MILLILITRE)));
    }
}