package com.apps.quantitymeasurement;

public class Quantity<U extends Unit> {

	private final double value;
	private final U unit;
	private static final double EPSILON = 1e-6;

	public Quantity(double value, U unit) {

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

		if (this == obj)
			return true;

		if (obj == null || getClass() != obj.getClass())
			return false;

		Quantity<?> other = (Quantity<?>) obj;

		// 🔥 IMPORTANT FIX: Units must be same enum type
		if (!this.unit.getClass().equals(other.unit.getClass()))
			return false;

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

	public Quantity<U> convertTo(U targetUnit) {

		if (targetUnit == null)
			throw new IllegalArgumentException("Target unit cannot be null");

		double baseValue = toBase();
		double converted = targetUnit.fromBase(baseValue);

		converted = Math.round(converted * 1000000.0) / 1000000.0;

		return new Quantity<>(converted, targetUnit);
	}

	public Quantity<U> add(Quantity<U> other) {

		if (other == null)
			throw new IllegalArgumentException("Operand cannot be null");

		double sumBase = this.toBase() + other.toBase();
		double result = unit.fromBase(sumBase);

		result = Math.round(result * 1000000.0) / 1000000.0;

		return new Quantity<>(result, this.unit);
	}

	public Quantity<U> add(Quantity<U> other, U targetUnit) {

		if (other == null)
			throw new IllegalArgumentException("Operand cannot be null");

		if (targetUnit == null)
			throw new IllegalArgumentException("Target unit cannot be null");

		double sumBase = this.toBase() + other.toBase();
		double result = targetUnit.fromBase(sumBase);

		result = Math.round(result * 1000000.0) / 1000000.0;

		return new Quantity<>(result, targetUnit);
	}

	// Inside Quantity<U> class
	public Quantity<U> subtract(Quantity<U> other) {
		if (other == null) {
			throw new IllegalArgumentException("Operand cannot be null");
		}
		// Category check: must be same unit enum class
		if (!this.unit.getClass().equals(other.unit.getClass())) {
			throw new IllegalArgumentException("Different measurement categories");
		}
		double diffBase = this.toBase() - other.toBase();
		double result = unit.fromBase(diffBase);
		result = Math.round(result * 1000000.0) / 1000000.0;
		return new Quantity<>(result, this.unit);
	}

	public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
		if (other == null) {
			throw new IllegalArgumentException("Operand cannot be null");
		}
		if (targetUnit == null) {
			throw new IllegalArgumentException("Target unit cannot be null");
		}
		if (!this.unit.getClass().equals(other.unit.getClass())) {
			throw new IllegalArgumentException("Different measurement categories");
		}
		double diffBase = this.toBase() - other.toBase();
		double result = targetUnit.fromBase(diffBase);
		result = Math.round(result * 1000000.0) / 1000000.0;
		return new Quantity<>(result, targetUnit);
	}

	public double divide(Quantity<U> other) {
		if (other == null) {
			throw new IllegalArgumentException("Operand cannot be null");
		}
		if (!this.unit.getClass().equals(other.unit.getClass())) {
			throw new IllegalArgumentException("Different measurement categories");
		}
		if (other.toBase() == 0.0) {
			throw new ArithmeticException("Division by zero");
		}
		return this.toBase() / other.toBase();
	}
	
	// ================= UC13 OPERATIONS =================

	public double multiply(Quantity<U> other) {

	    if (other == null)
	        throw new IllegalArgumentException("Operand cannot be null");

	    if (!this.unit.getClass().equals(other.unit.getClass()))
	        throw new IllegalArgumentException("Different measurement categories");

	    return this.toBase() * other.toBase();
	}

	public double mod(Quantity<U> other) {

	    if (other == null)
	        throw new IllegalArgumentException("Operand cannot be null");

	    if (!this.unit.getClass().equals(other.unit.getClass()))
	        throw new IllegalArgumentException("Different measurement categories");

	    if (other.toBase() == 0.0)
	        throw new ArithmeticException("Modulus by zero");

	    return this.toBase() % other.toBase();
	}

	public double power(int exponent) {

	    return Math.pow(this.toBase(), exponent);
	}
}