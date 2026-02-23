package com.apps.quantitymeasurement;

import java.util.Scanner;

public class QuantityMeasurementApp {

    // For JUnit test
    public static boolean demonstrateLengthComparison(
            double v1, Length.LengthUnit u1,
            double v2, Length.LengthUnit u2) {

        Length l1 = new Length(v1, u1);
        Length l2 = new Length(v2, u2);

        return l1.equals(l2);
    }

    // For Console program
    public static boolean demonstrateLengthComparison(Scanner sc) {

        System.out.print("Enter first value: ");
        double value1 = sc.nextDouble();

        System.out.println("Select first unit:");
        System.out.println("1. FEET");
        System.out.println("2. INCHES");
        System.out.println("3. YARDS");
        System.out.println("4. CENTIMETERS");
        int unitChoice1 = sc.nextInt();

        System.out.print("Enter second value: ");
        double value2 = sc.nextDouble();

        System.out.println("Select second unit:");
        System.out.println("1. FEET");
        System.out.println("2. INCHES");
        System.out.println("3. YARDS");
        System.out.println("4. CENTIMETERS");
        int unitChoice2 = sc.nextInt();

        Length.LengthUnit unit1 = getUnit(unitChoice1);
        Length.LengthUnit unit2 = getUnit(unitChoice2);

        Length l1 = new Length(value1, unit1);
        Length l2 = new Length(value2, unit2);

        boolean result = l1.equals(l2);

        System.out.println("Are lengths equal? " + result);

        return result;
    }

    public static Length.LengthUnit getUnit(int choice) {
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
        sc.close();
    }
}