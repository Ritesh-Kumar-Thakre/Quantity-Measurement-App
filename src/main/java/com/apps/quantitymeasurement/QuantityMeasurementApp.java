package com.apps.quantitymeasurement;

import java.util.Scanner;

public class QuantityMeasurementApp {

    // Equality for JUnit
    public static boolean demonstrateLengthComparison(
            double v1, Length.LengthUnit u1,
            double v2, Length.LengthUnit u2) {

        Length l1 = new Length(v1, u1);
        Length l2 = new Length(v2, u2);
        return l1.equals(l2);
    }

    // Conversion for JUnit
    public static Length demonstrateLengthConversion(
            double value,
            Length.LengthUnit fromUnit,
            Length.LengthUnit toUnit) {

        if (fromUnit == null || toUnit == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }

        Length source = new Length(value, fromUnit);
        return source.convertTo(toUnit);
    }

    // -------- Console Methods Below --------

    public static void demonstrateLengthComparison(Scanner sc) {
        System.out.print("Enter first value: ");
        double value1 = sc.nextDouble();
        Length.LengthUnit unit1 = getUnit(sc, "first");

        System.out.print("Enter second value: ");
        double value2 = sc.nextDouble();
        Length.LengthUnit unit2 = getUnit(sc, "second");

        Length l1 = new Length(value1, unit1);
        Length l2 = new Length(value2, unit2);

        System.out.println(l1 + " == " + l2 + " ? " + l1.equals(l2));
    }

    public static void demonstrateLengthConversion(Scanner sc) {
        System.out.print("Enter value to convert: ");
        double value = sc.nextDouble();

        Length.LengthUnit fromUnit = getUnit(sc, "source");
        Length.LengthUnit toUnit = getUnit(sc, "target");

        Length source = new Length(value, fromUnit);
        Length converted = source.convertTo(toUnit);

        System.out.println(source + " -> " + converted);
    }

    public static Length.LengthUnit getUnit(Scanner sc, String label) {

        System.out.println("Select " + label + " unit:");
        System.out.println("1. FEET");
        System.out.println("2. INCHES");
        System.out.println("3. YARDS");
        System.out.println("4. CENTIMETERS");

        int choice = sc.nextInt();

        switch (choice) {
            case 1: return Length.LengthUnit.FEET;
            case 2: return Length.LengthUnit.INCHES;
            case 3: return Length.LengthUnit.YARDS;
            case 4: return Length.LengthUnit.CENTIMETERS;
            default: throw new IllegalArgumentException("Invalid Unit Choice");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        demonstrateLengthComparison(sc);
        demonstrateLengthConversion(sc);

        sc.close();
    }
}