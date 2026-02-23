package com.apps.quantitymeasurement;

import java.util.Scanner;

public class QuantityMeasurementApp {

	// Static method to demonstrate Length equality
	public static boolean demonstrateLengthEquality(Length l1, Length l2) {
		return l1.equals(l2);
	}

	// Static method to demonstrate Feet equality
	public static void demonstrateFeetEquality(Scanner sc) {
		System.out.print("Enter first feet: ");
		double f1 = sc.nextDouble();

		System.out.print("Enter second feet: ");
		double f2 = sc.nextDouble();

		Length feet1 = new Length(f1, Length.LengthUnit.FEET);
		Length feet2 = new Length(f2, Length.LengthUnit.FEET);

		System.out.println("Feet equality: " + demonstrateLengthEquality(feet1, feet2));
	}

	// Static method to demonstrate Inches equality
	public static void demonstrateInchesEquality(Scanner sc) {
		System.out.print("Enter first inches: ");
		double i1 = sc.nextDouble();

		System.out.print("Enter second inches: ");
		double i2 = sc.nextDouble();

		Length inch1 = new Length(i1, Length.LengthUnit.INCHES);
		Length inch2 = new Length(i2, Length.LengthUnit.INCHES);

		System.out.println("Inches equality: " + demonstrateLengthEquality(inch1, inch2));
	}

	// Static method to demonstrate Feet and Inches comparison
	public static void demonstrateFeetInchesComparison(Scanner sc) {
		System.out.print("Enter feet value: ");
		double feetValue = sc.nextDouble();

		System.out.print("Enter inches value: ");
		double inchValue = sc.nextDouble();

		Length feet = new Length(feetValue, Length.LengthUnit.FEET);
		Length inches = new Length(inchValue, Length.LengthUnit.INCHES);

		System.out.println("Feet vs Inches equality: " + demonstrateLengthEquality(feet, inches));
	}

	// Main method
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		demonstrateFeetEquality(sc);
		demonstrateInchesEquality(sc);
		demonstrateFeetInchesComparison(sc);

		sc.close();
	}
}