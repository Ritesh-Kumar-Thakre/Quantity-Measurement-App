# UC6 – Addition of Two Length Units (Same Category)

## 📌 Overview

UC6 extends UC5 by introducing **addition operations** between length measurements.

The `Length` class now supports adding two length objects that may have different units (but belong to the same measurement category: length).

The result is always returned in the **unit of the first operand** (or explicitly specified target unit).

Example:

- 1 FOOT + 12 INCHES = 2 FEET
- 12 INCHES + 1 FOOT = 24 INCHES

All operations internally normalize to the base unit (INCHES) before performing arithmetic.

---

## 🎯 Objective

- Enable arithmetic operations on length value objects
- Support cross-unit addition
- Maintain immutability
- Preserve precision handling
- Ensure mathematical correctness (commutativity, identity)

---

## 🏗️ Design Architecture

### 🔹 Base Unit Strategy

All arithmetic operations normalize to **INCHES** (base unit).

Steps:

1. Convert both operands to base unit (inches)
2. Add values
3. Convert sum to the unit of the first operand
4. Return new `Length` instance

---

## ➕ Addition API

### 1️⃣ Instance Method

```java
public Length add(Length other)
