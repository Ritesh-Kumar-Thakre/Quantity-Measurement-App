package com.apps.quantitymeasurement;

public enum LengthUnit {

    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    // Convert value to base unit (inches)
    public double toBase(double value) {
        return value * conversionFactor;
    }

    // Convert from base unit (inches) to this unit
    public double fromBase(double baseValue) {
        double result = baseValue / conversionFactor;
        return Math.round(result * 1000000.0) / 1000000.0;
    }
}