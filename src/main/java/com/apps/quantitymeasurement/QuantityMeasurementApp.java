package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

	public static boolean demonstrateLengthComparison(double v1, Length.LengthUnit u1, double v2,
			Length.LengthUnit u2) {

		Length l1 = new Length(v1, u1);
		Length l2 = new Length(v2, u2);

		return l1.equals(l2);
	}

	public static Length demonstrateLengthConversion(double value, Length.LengthUnit fromUnit,
			Length.LengthUnit toUnit) {

		Length source = new Length(value, fromUnit);
		return source.convertTo(toUnit);
	}

	
	public static Length demonstrateLengthConversion(Length length, Length.LengthUnit targetUnit) {

		return length.convertTo(targetUnit);
	}

	public static void main(String[] args) {

		
		boolean result = demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS, 36.0, Length.LengthUnit.INCHES);

		System.out.println("Are equal: " + result);

	
		Length converted = demonstrateLengthConversion(3.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);

		System.out.println("Converted value: " + converted);

		Length yard = new Length(1.0, Length.LengthUnit.YARDS);
		Length inches = demonstrateLengthConversion(yard, Length.LengthUnit.INCHES);

		System.out.println("1 yard in inches: " + inches);
	}
}