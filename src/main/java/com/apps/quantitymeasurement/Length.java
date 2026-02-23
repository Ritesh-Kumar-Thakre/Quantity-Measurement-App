package com.apps.quantitymeasurement;

public class Length {

    private final double value;
    private final LengthUnit unit;
    private static final double EPSILON = 1e-6;

    public Length(double value, LengthUnit unit) {

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");

        this.value = value;
        this.unit = unit;
    }

    private double convertToBaseUnit() {
        return unit.toBase(value);   // Delegated to enum
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Length that = (Length) o;

        double thisBase = this.convertToBaseUnit();
        double thatBase = that.convertToBaseUnit();

        return Math.abs(thisBase - thatBase) < EPSILON;
    }

    @Override
    public int hashCode() {
        long normalized = Math.round(convertToBaseUnit() / EPSILON);
        return Long.hashCode(normalized);
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }

    // Convert to another unit
    public Length convertTo(LengthUnit targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double baseValue = convertToBaseUnit();
        double convertedValue = targetUnit.fromBase(baseValue);

        return new Length(convertedValue, targetUnit);
    }

    // UC6
    public Length add(Length thatLength) {

        if (thatLength == null)
            throw new IllegalArgumentException("Operand cannot be null");

        double sumBase = this.convertToBaseUnit() + thatLength.convertToBaseUnit();
        double result = this.unit.fromBase(sumBase);

        return new Length(result, this.unit);
    }

    // UC7
    public Length add(Length thatLength, LengthUnit targetUnit) {

        if (thatLength == null)
            throw new IllegalArgumentException("Operand cannot be null");

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double sumBase = this.convertToBaseUnit() + thatLength.convertToBaseUnit();
        double result = targetUnit.fromBase(sumBase);

        return new Length(result, targetUnit);
    }

    // Static conversion
    public static double convert(double value, LengthUnit source, LengthUnit target) {

        if (source == null || target == null)
            throw new IllegalArgumentException("Units cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");

        double baseValue = source.toBase(value);
        return target.fromBase(baseValue);
    }
}