package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityArithmeticTest {

	// ---------- SUBTRACTION ----------

	@Test
	public void testSubtraction_SameUnit() {
		Quantity<LengthUnit> result = new Quantity<>(10.0, LengthUnit.FEET)
				.subtract(new Quantity<>(6.0, LengthUnit.INCHES));
		assertEquals(new Quantity<>(9.5, LengthUnit.FEET), result);
	}

	@Test
	public void testSubtraction_ExplicitTargetUnit() {
		Quantity<LengthUnit> result = new Quantity<>(10.0, LengthUnit.FEET)
				.subtract(new Quantity<>(6.0, LengthUnit.INCHES), LengthUnit.INCHES);
		assertEquals(new Quantity<>(114.0, LengthUnit.INCHES), result);
	}

	@Test
	public void testSubtraction_NegativeResult() {
		Quantity<WeightUnit> result = new Quantity<>(2.0, WeightUnit.KILOGRAM)
				.subtract(new Quantity<>(5.0, WeightUnit.KILOGRAM));
		assertEquals(new Quantity<>(-3.0, WeightUnit.KILOGRAM), result);
	}

	@Test
	public void testSubtraction_ResultZero() {
		Quantity<LengthUnit> result = new Quantity<>(10.0, LengthUnit.FEET)
				.subtract(new Quantity<>(120.0, LengthUnit.INCHES));
		assertEquals(new Quantity<>(0.0, LengthUnit.FEET), result);
	}

	@Test
	@SuppressWarnings("rawtypes")
	public void testSubtraction_CrossCategory_Throws() {

		Quantity length = new Quantity<>(5.0, LengthUnit.FEET);

		Quantity weight = new Quantity<>(2.0, WeightUnit.KILOGRAM);

		assertThrows(IllegalArgumentException.class, () -> length.subtract(weight));
	}

	@Test
	public void testSubtraction_NullOperand_Throws() {
		assertThrows(IllegalArgumentException.class, () -> new Quantity<>(5.0, LengthUnit.FEET).subtract(null));
	}

	@Test
	public void testSubtraction_NullTargetUnit_Throws() {
		assertThrows(IllegalArgumentException.class,
				() -> new Quantity<>(5.0, LengthUnit.FEET).subtract(new Quantity<>(3.0, LengthUnit.FEET), null));
	}

	// ---------- DIVISION ----------

	@Test
	public void testDivision_SameUnit() {
		double result = new Quantity<>(10.0, LengthUnit.FEET).divide(new Quantity<>(2.0, LengthUnit.FEET));
		assertEquals(5.0, result);
	}

	@Test
	public void testDivision_CrossUnit() {
		double result = new Quantity<>(24.0, LengthUnit.INCHES).divide(new Quantity<>(2.0, LengthUnit.FEET));
		assertEquals(1.0, result);
	}

	@Test
	public void testDivision_RatioLessThanOne() {
		double result = new Quantity<>(5.0, LengthUnit.FEET).divide(new Quantity<>(10.0, LengthUnit.FEET));
		assertEquals(0.5, result);
	}

	@Test
	public void testDivision_DivideByZero_Throws() {
		assertThrows(ArithmeticException.class,
				() -> new Quantity<>(5.0, LengthUnit.FEET).divide(new Quantity<>(0.0, LengthUnit.FEET)));
	}

	@Test
	@SuppressWarnings("rawtypes")
	public void testDivision_CrossCategory_Throws() {

		Quantity length = new Quantity<>(5.0, LengthUnit.FEET);

		Quantity weight = new Quantity<>(2.0, WeightUnit.KILOGRAM);

		assertThrows(IllegalArgumentException.class, () -> length.divide(weight));
	}

	@Test
	public void testDivision_NullOperand_Throws() {
		assertThrows(IllegalArgumentException.class, () -> new Quantity<>(5.0, LengthUnit.FEET).divide(null));
	}
}