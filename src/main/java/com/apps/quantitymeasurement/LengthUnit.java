package com.apps.quantitymeasurement;

public enum LengthUnit implements Unit {

	FEET(12.0), INCHES(1.0), YARDS(36.0), CENTIMETERS(0.393701);

	private final double conversionFactor; // base = inches

	LengthUnit(double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	@Override
	public double toBase(double value) {
		return value * conversionFactor;
	}

	@Override
	public double fromBase(double baseValue) {
		return baseValue / conversionFactor;
	}

	@Override
	public double getConversionFactor() {
		return conversionFactor;
	}
}