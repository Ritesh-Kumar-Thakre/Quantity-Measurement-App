package com.apps.quantitymeasurement;

public class Length {

	private final double value;
	private final LengthUnit unit;
	private static final double EPSILON = 1e-6;

	public enum LengthUnit {

		FEET(12.0),
		INCHES(1.0),
		YARDS(36.0),
		CENTIMETERS(0.393701);

		private final double conversionFactor;

		LengthUnit(double conversionFactor) {
			this.conversionFactor = conversionFactor;
		}

		public double getConversionFactor() {
			return conversionFactor;
		}
	}

	public Length(double value, LengthUnit unit) {
		if (unit == null) {
			throw new IllegalArgumentException("Unit cannot be null");
		}
		if (!Double.isFinite(value)) {
			throw new IllegalArgumentException("value must be a finite number");
		}

		this.value = value;
		this.unit = unit;
	}

	private double convertToBaseUnit() {
		return value * unit.getConversionFactor();
	}

	private boolean compare(Length that) {
		double thisValue = this.convertToBaseUnit();
		double thatValue = that.convertToBaseUnit();
		return Math.abs(thisValue - thatValue) < EPSILON;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Length that = (Length) o;
		return compare(that);
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

	public Length convertTo(LengthUnit targetUnit) {
		if (targetUnit == null) {
			throw new IllegalArgumentException("Target unit cannot be null");
		}

		double baseValue = this.convertToBaseUnit();
		double convertedValue = baseValue / targetUnit.getConversionFactor();
		convertedValue = Math.round(convertedValue * 100.0) / 100.0;

		return new Length(convertedValue, targetUnit);
	}

	public static double convert(double value, LengthUnit source, LengthUnit target) {
		if (source == null || target == null) {
			throw new IllegalArgumentException("Units cannot be null");
		}
		if (!Double.isFinite(value)) {
			throw new IllegalArgumentException("Value must be a finite number");
		}

		double baseValue = value * source.getConversionFactor();
		double convertedValue = baseValue / target.getConversionFactor();
		return Math.round(convertedValue * 100.0) / 100.0;
	}

	public Length add(Length other) {
		if (other == null) {
			throw new IllegalArgumentException("Length cannot be null");
		}

		double base1 = this.convertToBaseUnit();
		double base2 = other.convertToBaseUnit();

		double sumBase = base1 + base2;

		double result = sumBase / this.unit.getConversionFactor();
		result = Math.round(result * 100.0) / 100.0;

		return new Length(result, this.unit);
	}
}