# UC7 – Addition with Target Unit Specification

## 📌 Overview

UC7 extends UC6 by allowing the caller to explicitly specify the **target unit** for the addition result.

Instead of always returning the result in the unit of the first operand (UC6 behavior), UC7 provides flexibility to return the result in **any supported unit**.

Example:

- add(1 FOOT, 12 INCHES, FEET) → 2 FEET
- add(1 FOOT, 12 INCHES, INCHES) → 24 INCHES
- add(1 FOOT, 12 INCHES, YARDS) → ~0.667 YARDS

All operations internally normalize to the base unit (**INCHES**) before performing arithmetic.

---

## 🎯 Objective

- Provide explicit control over result unit
- Maintain immutability
- Preserve backward compatibility with UC6
- Ensure precision-safe arithmetic
- Improve API clarity and flexibility

---

## 🏗️ Design Architecture

### 🔹 Base Unit Strategy

All arithmetic operations normalize to **INCHES**.

Steps:

1. Convert both operands to base unit (inches)
2. Add values
3. Convert result to explicitly specified target unit
4. Return new `Length` instance

---

## ➕ Addition API

### 1️⃣ Explicit Target Unit Method

```java
public Length add(Length other, LengthUnit targetUnit)
