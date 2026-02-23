package com.apps.quantitymeasurement;

public enum WeightUnit implements Unit {

    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double conversionFactor; // base = kg

    WeightUnit(double conversionFactor) {
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