package com.apps.quantitymeasurement;

import java.util.Scanner;

public class QuantityMeasurementApp {

	// Inner class to represent Feet measurement
	public static class Feet {
		private final double value;

		public Feet(double value) {
			this.value = value;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}

			if (obj == null || this.getClass() != obj.getClass()) {
				return false;
			}

			Feet other = (Feet) obj;
			return Double.compare(this.value, other.value) == 0;
		}
	}

	// Inner class to represent Inches measurement
	public static class Inches {
		private final double value;

		public Inches(double value) {
			this.value = value;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}

			if (obj == null || this.getClass() != obj.getClass()) {
				return false;
			}

			Inches other = (Inches) obj;
			return Double.compare(this.value, other.value) == 0;
		}
	}

	// Static method to demonstrate Feet equality
	public static void demonstrateFeetEquality() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first feet: ");
		double f1 = sc.nextDouble();
		System.out.print("Enter second feet: ");
		double f2 = sc.nextDouble();
		Feet feet1 = new Feet(f1);
		Feet feet2 = new Feet(f2);
		System.out.println("Are they equal? " + feet1.equals(feet2));
	}

	// Static method to demonstrate Inches equality
	public static void demonstrateInchesEquality() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first Inche: ");
		double i1 = sc.nextDouble();
		System.out.print("Enter second Inche: ");
		double i2 = sc.nextDouble();
		Inches inch1 = new Inches(i1);
		Inches inch2 = new Inches(i2);
		System.out.println("Inches equality: " + inch1.equals(inch2));
	}

	// Main method
	public static void main(String[] args) {
		demonstrateFeetEquality();
		
		demonstrateInchesEquality();
	}
}