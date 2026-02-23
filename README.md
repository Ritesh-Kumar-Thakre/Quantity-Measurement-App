# UC3 – Generic Quantity Class (DRY Principle Implementation)

## 📖 Description

UC3 refactors the previous implementation (UC1 & UC2) 
to eliminate code duplication between `Feet` and `Inches` classes.

Instead of maintaining separate classes with identical logic, 
this branch introduces a **single generic `QuantityLength` class** 
that represents any length measurement along with its unit type.

This implementation follows the **DRY (Don't Repeat Yourself)** principle 
while preserving all existing functionality.

---

## 🎯 Objective

- Eliminate duplicated logic from Feet and Inches classes
- Centralize conversion logic
- Support cross-unit equality (e.g., 1 foot = 12 inches)
- Maintain backward compatibility
- Improve scalability for future units

---

## ⚙️ Preconditions

- `QuantityMeasurementApp` class is instantiated.
- Two numerical values with corresponding units are provided.
- Conversion factors are defined as constants in an enum.

---

## 🔄 Main Flow

1. User provides two values with unit types.
2. Input validation ensures:
   - Numeric value
   - Supported unit type
3. Both values are converted to a common base unit (feet).
4. Converted values are compared using `Double.compare()`.
5. Equality result (`true` / `false`) is returned.

---

## 🏗️ Architecture Overview

### 🔹 LengthUnit Enum

Defines supported units and conversion factors relative to base unit (feet).

Example:

```java
public enum LengthUnit {
    FEET(1.0),
    INCH(1.0 / 12);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double toFeet(double value) {
        return value * conversionFactor;
    }
}
