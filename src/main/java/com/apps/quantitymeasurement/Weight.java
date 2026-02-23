package com.apps.quantitymeasurement;

public class Weight {

    private final double value;
    private final WeightUnit unit;
    private static final double EPSILON = 1e-6;

    public Weight(double value, WeightUnit unit) {

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");

        this.value = value;
        this.unit = unit;
    }

    private double toBase() {
        return unit.toBase(value);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Weight other = (Weight) obj;

        return Math.abs(this.toBase() - other.toBase()) < EPSILON;
    }

    @Override
    public int hashCode() {
        long normalized = Math.round(toBase() / EPSILON);
        return Long.hashCode(normalized);
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }

    public Weight convertTo(WeightUnit targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double baseValue = toBase();
        double converted = targetUnit.fromBase(baseValue);

        converted = Math.round(converted * 1000000.0) / 1000000.0;

        return new Weight(converted, targetUnit);
    }

    public Weight add(Weight other) {

        if (other == null)
            throw new IllegalArgumentException("Operand cannot be null");

        double sumBase = this.toBase() + other.toBase();
        double result = unit.fromBase(sumBase);

        result = Math.round(result * 1000000.0) / 1000000.0;

        return new Weight(result, this.unit);
    }

    public Weight add(Weight other, WeightUnit targetUnit) {

        if (other == null)
            throw new IllegalArgumentException("Operand cannot be null");

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double sumBase = this.toBase() + other.toBase();
        double result = targetUnit.fromBase(sumBase);

        result = Math.round(result * 1000000.0) / 1000000.0;

        return new Weight(result, targetUnit);
    }
}