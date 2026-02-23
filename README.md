# UC2 – Feet and Inches Measurement Equality

## 📖 Description

This branch extends **UC1 (Feet Equality)** by introducing 
support for **Inches measurement equality**.

Both Feet and Inches are treated as separate entities.  
This use case ensures accurate comparison within the same unit type 
(feet-to-feet and inch-to-inch).

⚠️ Note: This use case does NOT compare feet with inches directly as objects.  
They are handled independently.

---

## 🎯 Objective

To:
- Implement equality check for Inches measurements.
- Maintain same object-oriented principles used in UC1.
- Reduce dependency on the main method by using dedicated static methods.
- Ensure full test coverage.

---

## ⚙️ Preconditions

- `QuantityMeasurementApp` class is instantiated.
- Two numerical values for feet or inches are provided (hard-coded).

---

## 🔄 Main Flow

1. The `main()` method calls a static method to compare feet values.
2. The `main()` method calls another static method to compare inch values.
3. Static methods instantiate:
   - `Feet` class
   - `Inches` class
4. Each class:
   - Validates input
   - Compares values using `equals()`
5. Result (`true` / `false`) is returned.

---

## ✅ Postconditions

- Returns `true` if two values of the same unit are equal.
- Returns `false` if values differ.
- Supports:
  - Feet-to-Feet comparison
  - Inch-to-Inch comparison

---

## 🏗️ Implementation Details

### 🔹 Classes Implemented

- `QuantityMeasurementApp`
- `Feet` (inner class)
- `Inches` (inner class)

Both classes contain:

```java
private final double value;
