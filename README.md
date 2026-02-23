# UC1 – Feet Measurement Equality

## 📖 Description

This branch implements **Use Case 1 (UC1): Feet Measurement Equality**  
for the Quantity Measurement Application.

The `QuantityMeasurementApp` class checks whether two numerical values 
measured in feet are equal, ensuring proper object comparison and 
handling of edge cases.

---

## 🎯 Objective

To compare two measurements in feet using proper object-oriented design 
and by overriding the `equals()` method following the Java Equality Contract.

---

## ⚙️ Preconditions

- The `QuantityMeasurementApp` class is instantiated.
- Two numerical values in feet are provided for comparison.

---

## 🔄 Main Flow

1. User provides two numerical values in feet.
2. Values are validated to ensure they are numeric.
3. Two `Feet` objects are created.
4. The `equals()` method is used to compare them.
5. The result (`true` or `false`) is returned.

---

## ✅ Postconditions

- Returns `true` if both values are equal.
- Returns `false` if values differ or comparison is invalid.

---

## 🏗️ Implementation Details

### 🔹 Class Design
- Main class: `QuantityMeasurementApp`
- Inner class: `Feet`
- Measurement value stored as:
  ```java
  private final double value;
