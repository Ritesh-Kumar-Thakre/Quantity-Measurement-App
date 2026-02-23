package com.apps.quantitymeasurement;

import java.util.Scanner;

public class QuantityMeasurementApp {

    // ================= BUSINESS METHODS (For JUnit) =================

    public static <U extends Unit> boolean demonstrateComparison(
            double v1, U u1,
            double v2, U u2) {

        Quantity<U> q1 = new Quantity<>(v1, u1);
        Quantity<U> q2 = new Quantity<>(v2, u2);

        return q1.equals(q2);
    }

    public static <U extends Unit> Quantity<U> demonstrateConversion(
            double value,
            U from,
            U to) {

        if (from == null || to == null)
            throw new IllegalArgumentException("Units cannot be null");

        return new Quantity<>(value, from).convertTo(to);
    }

    public static <U extends Unit> Quantity<U> demonstrateAddition(
            Quantity<U> q1,
            Quantity<U> q2) {

        if (q1 == null || q2 == null)
            throw new IllegalArgumentException("Quantity cannot be null");

        return q1.add(q2);
    }

    public static <U extends Unit> Quantity<U> demonstrateAddition(
            Quantity<U> q1,
            Quantity<U> q2,
            U targetUnit) {

        if (q1 == null || q2 == null)
            throw new IllegalArgumentException("Quantity cannot be null");

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        return q1.add(q2, targetUnit);
    }

    // ================= CONSOLE METHODS =================

    public static void demonstrateLengthOperations(Scanner sc) {

        System.out.println("===== LENGTH OPERATIONS =====");

        Quantity<LengthUnit> q1 = getLengthInput(sc, "first");
        Quantity<LengthUnit> q2 = getLengthInput(sc, "second");

        System.out.println("Equality: " + q1.equals(q2));

        LengthUnit target = getLengthUnit(sc, "target for addition");
        System.out.println("Addition Result: " + q1.add(q2, target));

        LengthUnit convertTarget = getLengthUnit(sc, "target for conversion");
        System.out.println("Conversion Result: " + q1.convertTo(convertTarget));
    }

    public static void demonstrateWeightOperations(Scanner sc) {

        System.out.println("===== WEIGHT OPERATIONS =====");

        Quantity<WeightUnit> q1 = getWeightInput(sc, "first");
        Quantity<WeightUnit> q2 = getWeightInput(sc, "second");

        System.out.println("Equality: " + q1.equals(q2));

        WeightUnit target = getWeightUnit(sc, "target for addition");
        System.out.println("Addition Result: " + q1.add(q2, target));

        WeightUnit convertTarget = getWeightUnit(sc, "target for conversion");
        System.out.println("Conversion Result: " + q1.convertTo(convertTarget));
    }

    // ================= INPUT HELPERS =================

    private static Quantity<LengthUnit> getLengthInput(Scanner sc, String label) {

        System.out.print("Enter " + label + " length value: ");
        double value = sc.nextDouble();

        LengthUnit unit = getLengthUnit(sc, label + " length unit");

        return new Quantity<>(value, unit);
    }

    private static LengthUnit getLengthUnit(Scanner sc, String label) {

        System.out.println("Select " + label + ":");
        System.out.println("1. FEET");
        System.out.println("2. INCHES");
        System.out.println("3. YARDS");
        System.out.println("4. CENTIMETERS");

        int choice = sc.nextInt();

        switch (choice) {
            case 1: return LengthUnit.FEET;
            case 2: return LengthUnit.INCHES;
            case 3: return LengthUnit.YARDS;
            case 4: return LengthUnit.CENTIMETERS;
            default: throw new IllegalArgumentException("Invalid Length Unit");
        }
    }

    private static Quantity<WeightUnit> getWeightInput(Scanner sc, String label) {

        System.out.print("Enter " + label + " weight value: ");
        double value = sc.nextDouble();

        WeightUnit unit = getWeightUnit(sc, label + " weight unit");

        return new Quantity<>(value, unit);
    }

    private static WeightUnit getWeightUnit(Scanner sc, String label) {

        System.out.println("Select " + label + ":");
        System.out.println("1. KILOGRAM");
        System.out.println("2. GRAM");
        System.out.println("3. POUND");

        int choice = sc.nextInt();

        switch (choice) {
            case 1: return WeightUnit.KILOGRAM;
            case 2: return WeightUnit.GRAM;
            case 3: return WeightUnit.POUND;
            default: throw new IllegalArgumentException("Invalid Weight Unit");
        }
    }

    // ================= MAIN =================

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Select Category:");
        System.out.println("1. Length");
        System.out.println("2. Weight");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                demonstrateLengthOperations(sc);
                break;
            case 2:
                demonstrateWeightOperations(sc);
                break;
            default:
                System.out.println("Invalid Option");
        }

        sc.close();
    }
}