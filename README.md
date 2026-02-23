# UC9 – Weight Measurement Equality, Conversion, and Addition

## 📌 Overview

UC9 extends the **Quantity Measurement Application** to support **weight measurements** in addition to length. This use case introduces a new measurement category — **weight** — alongside length, demonstrating that the scalable design from UC1–UC8 can be extended to multiple categories.

Weight measurements support:

- Equality comparison
- Unit conversion
- Addition operations (with optional target unit)

Supported weight units:

- **Kilogram (kg)** — Base unit for weight conversions  
- **Gram (g)** — 1 kg = 1000 g  
- **Pound (lb)** — 1 lb ≈ 0.453592 kg :contentReference[oaicite:0]{index=0}

Weight measurements are treated independently from length measurements — they are not directly comparable (e.g., 1 foot ≠ 1 kilogram). :contentReference[oaicite:1]{index=1}

---

## 🎯 Objective

- Add support for **weight measurements** using a new `WeightUnit` enum
- Apply the same design patterns used for length
- Maintain backward compatibility
- Preserve precision and immutability
- Enable weight equality, conversion, and arithmetic

---

## 🎯 Preconditions

- `WeightUnit` enum exists as a standalone class
- `QuantityWeight` class mirrors `QuantityLength` with conversion, equality, and arithmetic
- Conversion constants are defined relative to kilogram
- Length measurements remain supported and unaffected
- Cross-category comparisons are disallowed :contentReference[oaicite:2]{index=2}

---

## 🔄 Main Flow

### 1. Equality Comparison

- Input: Two weight values with units
- Convert both values to kilograms
- Compare using `equals()`
- Return result (true/false) :contentReference[oaicite:3]{index=3}

### 2. Unit Conversion

- Input: Numeric value, source unit, target unit
- Convert to base unit (kilogram)
- Convert to target unit
- Return a new `QuantityWeight` object :contentReference[oaicite:4]{index=4}

### 3. Addition

- Input: Two `QuantityWeight` objects (with optional explicit target unit)
- Convert both to base unit
- Add values
- Convert sum to target or first operand’s unit
- Return new `QuantityWeight` :contentReference[oaicite:5]{index=5}

---

## 🧱 WeightUnit Enum

Define `WeightUnit` with conversion factors relative to base unit (**kilogram**):

```java
public enum WeightUnit {
    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double toKilogramFactor;

    public double convertToBaseUnit(double value) {
        return value * toKilogramFactor;
    }

    public double convertFromBaseUnit(double baseValue) {
        return baseValue / toKilogramFactor;
    }
}
