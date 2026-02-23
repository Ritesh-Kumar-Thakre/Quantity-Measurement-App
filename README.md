# UC5 – Unit-to-Unit Conversion (Same Measurement Type)

## 📌 Overview

UC5 extends the Quantity Measurement system by introducing explicit **unit-to-unit conversion functionality** in addition to equality comparison.

The `Length` class now supports:

- Instance-level conversion (`convertTo`)
- Static numeric conversion (`convert`)
- Cross-unit equality with precision handling

Supported units:

- FEET  
- INCHES (Base Unit)  
- YARDS  
- CENTIMETERS  

All conversions are internally normalized to **INCHES** to ensure mathematical consistency.

---

## 🎯 Objective

- Enable direct conversion between supported units
- Maintain immutability and value-object semantics
- Preserve equality logic from previous use cases
- Ensure floating-point precision safety
- Provide a clean and reusable API

---

## 🏗️ Design Architecture

### 🔹 Base Unit Strategy

All units are defined relative to **INCHES**.

| Unit | Conversion Factor (to Inches) |
|------|-------------------------------|
| FEET | 12.0 |
| INCHES | 1.0 |
| YARDS | 36.0 |
| CENTIMETERS | 0.393701 |

### 🔹 Conversion Formula
- result = (value × sourceFactor) / targetFactor

---

## 🧱 LengthUnit Enum

```java
FEET(12.0),
INCHES(1.0),
YARDS(36.0),
CENTIMETERS(0.393701);
