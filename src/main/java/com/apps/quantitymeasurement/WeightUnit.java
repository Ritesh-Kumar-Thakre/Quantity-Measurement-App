package com.apps.quantitymeasurement;

public enum WeightUnit {

    KILOGRAM(1.0),          // Base unit
    GRAM(0.001),            // 1 g = 0.001 kg
    POUND(0.453592);        // 1 lb = 0.453592 kg

    private final double conversionFactor; // to base unit (kg)

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double toBase(double value) {
        return value * conversionFactor;
    }

    public double fromBase(double baseValue) {
        return baseValue / conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }
}