# UC4 – Extended Unit Support (Yards & Centimeters)

## 📖 Description

UC4 extends the generic `QuantityLength` design from UC3 
by introducing additional units:

- YARDS
- CENTIMETERS

This use case demonstrates the scalability of the generic design.
New units are added only in the `LengthUnit` enum without modifying
the `QuantityLength` class.

All equality comparisons work seamlessly across:
- Feet
- Inches
- Yards
- Centimeters

---

## 🎯 Objective

- Extend supported units without modifying core logic
- Maintain DRY principle
- Support full cross-unit equality comparisons
- Preserve backward compatibility
- Ensure mathematical accuracy in conversions

---

## ⚙️ Preconditions

- UC3 generic implementation is already in place.
- LengthUnit enum supports base-unit conversion.
- Conversion factors are defined correctly.

Conversion references:
- 1 yard = 3 feet
- 1 yard = 36 inches
- 1 cm = 0.393701 inches

---

## 🏗️ Updated LengthUnit Enum

Example:

```java
public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12),
    YARDS(3.0),
    CENTIMETERS(0.393701 / 12);

    private final double conversionFactorToFeet;

    LengthUnit(double conversionFactorToFeet) {
        this.conversionFactorToFeet = conversionFactorToFeet;
    }

    public double toFeet(double value) {
        return value * conversionFactorToFeet;
    }
}
