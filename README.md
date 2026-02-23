# UC8 – Refactoring Unit Enum to Standalone with Conversion Responsibility

## 📌 Overview

UC8 refactors the architecture developed from UC1–UC7 by extracting the `LengthUnit` enum from inside the `QuantityLength` class into a standalone top-level enum.

In previous implementations, embedding `LengthUnit` within `QuantityLength` created tighter coupling, limited scalability, and introduced architectural constraints when expanding to multiple measurement categories (length, weight, volume, etc.).

UC8 resolves this by:

- Moving `LengthUnit` to a separate file
- Assigning conversion responsibility directly to the enum
- Delegating conversion logic from `QuantityLength` to `LengthUnit`
- Preserving all existing functionality from UC1–UC7

This refactoring improves cohesion, reduces coupling, eliminates circular dependency risks, and establishes a scalable architecture for future measurement systems.

---

## 🎯 Objective

- Enforce Single Responsibility Principle (SRP)
- Separate unit logic from quantity logic
- Centralize conversion responsibility
- Improve maintainability and readability
- Enable scalable multi-category measurement support
- Preserve backward compatibility

---

## 🏗️ Architectural Transformation

### 🔹 Before UC8
QuantityLength
└── nested enum LengthUnit

Issues:
- Conversion logic partially inside QuantityLength
- Tight coupling between quantity and unit
- Harder to scale across measurement categories
- Risk of circular dependencies

---

### 🔹 After UC8
LengthUnit (Standalone Enum)
QuantityLength (Delegates conversion)

Improvements:
- Clear separation of concerns
- Unit conversion centralized in LengthUnit
- QuantityLength simplified
- Scalable structure for new measurement types

---

## 🧱 Standalone LengthUnit Enum

`LengthUnit` is now a top-level enum responsible for:

- Defining conversion factors
- Converting values to base unit
- Converting values from base unit

### Base Unit

The system uses **FEET** as the base unit.

### Example Implementation

```java
public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12),
    YARDS(3.0),
    CENTIMETERS(1.0 / 30.48);

    private final double factorToFeet;

    LengthUnit(double factorToFeet) {
        this.factorToFeet = factorToFeet;
    }

    public double convertToBaseUnit(double value) {
        return value * factorToFeet;
    }

    public double convertFromBaseUnit(double baseValue) {
        return baseValue / factorToFeet;
    }

    public double getConversionFactor() {
        return factorToFeet;
    }
}
