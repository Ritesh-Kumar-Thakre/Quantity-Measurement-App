package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("rawtypes")
public class QuantityAdvancedOperationsTest {

    // -------- MULTIPLICATION --------

	@Test
	public void testMultiply_SameUnit() {

	    double result =
	            new Quantity<>(5.0, LengthUnit.FEET)
	                    .multiply(new Quantity<>(2.0, LengthUnit.FEET));

	    assertEquals(1440.0, result);
	}

    @Test
    public void testMultiply_CrossUnit() {

        double result =
                new Quantity<>(1.0, LengthUnit.FEET)
                        .multiply(new Quantity<>(12.0, LengthUnit.INCHES));

        assertEquals(144.0, result);
    }

    @Test
    public void testMultiply_CrossCategory_Throws() {

        Quantity length =
                new Quantity<>(5.0, LengthUnit.FEET);

        Quantity weight =
                new Quantity<>(2.0, WeightUnit.KILOGRAM);

        assertThrows(IllegalArgumentException.class,
                () -> length.multiply(weight));
    }

    // -------- MODULUS --------

    @Test
    public void testMod_SameUnit() {

        double result =
                new Quantity<>(10.0, LengthUnit.FEET)
                        .mod(new Quantity<>(3.0, LengthUnit.FEET));

        assertEquals(12.0, result);
    }

    @Test
    public void testMod_DivideByZero_Throws() {

        assertThrows(ArithmeticException.class,
                () -> new Quantity<>(5.0, LengthUnit.FEET)
                        .mod(new Quantity<>(0.0, LengthUnit.FEET)));
    }

    @Test
    public void testMod_CrossCategory_Throws() {

        Quantity length =
                new Quantity<>(5.0, LengthUnit.FEET);

        Quantity weight =
                new Quantity<>(2.0, WeightUnit.KILOGRAM);

        assertThrows(IllegalArgumentException.class,
                () -> length.mod(weight));
    }

    // -------- POWER --------

    @Test
    public void testPower_PositiveExponent() {

        double result =
                new Quantity<>(2.0, LengthUnit.FEET)
                        .power(2);

        // 2 ft = 24 inches
        // 24^2 = 576
        assertEquals(576.0, result);
    }

    @Test
    public void testPower_ZeroExponent() {

        double result =
                new Quantity<>(5.0, LengthUnit.FEET)
                        .power(0);

        assertEquals(1.0, result);
    }

    @Test
    public void testPower_NegativeExponent() {

        double result =
                new Quantity<>(2.0, LengthUnit.FEET)
                        .power(-1);

        assertEquals(1.0 / 24.0, result);
    }
}