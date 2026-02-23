package com.apps.quantitymeasurement;

public enum VolumeUnit implements Unit {

    LITRE(1.0),        // base unit: litres
    MILLILITRE(0.001), // 1 mL = 0.001 L
    GALLON(3.78541);   // 1 gallon ≈ 3.78541 L

    private final double conversionFactor;

    VolumeUnit(double conversionFactor) {
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