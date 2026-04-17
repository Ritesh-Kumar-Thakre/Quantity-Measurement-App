# ⚙️ Quantity Measurement App

This project represents a **progressive backend development journey**, starting from basic object-oriented programming and evolving into a **fully distributed microservices architecture** using Spring Boot and Spring Cloud.

Each Use Case (UC) builds upon the previous one, demonstrating **incremental learning, clean design, and real-world backend practices**.

---

## 🚀 Project Vision

To design and implement a **robust quantity measurement system** capable of:

* Handling multiple measurement domains
* Performing unit conversions and arithmetic operations
* Scaling from monolithic design → enterprise microservices architecture

---

## 🧠 Use Case Progression (UC1 → UC18)

---

### 🔹 UC1 – UC4: Foundations of Measurement System

* Introduced **basic quantity modeling**
* Equality comparison between units (e.g., feet vs inch)
* Conversion logic using base units
* Handling floating-point precision

💡 *Outcome:* Built a strong foundation for unit-based calculations

---

### 🔹 UC5 – UC8: Arithmetic Operations

* Addition, subtraction, and division of quantities
* Cross-unit operations (e.g., inch + feet)
* Validation of compatible unit types

💡 *Outcome:* Enabled real-world mathematical operations on quantities

---

### 🔹 UC9 – UC10: Multiple Measurement Domains

* Extended system to support:

  * Length
  * Volume
  * Weight
  * Temperature
* Introduced **ENUM-based unit categorization**

💡 *Outcome:* Made the system scalable and domain-independent

---

### 🔹 UC11 – UC12: Clean Code & Design Improvements

* Refactored code using:

  * DRY principle
  * Separation of concerns
* Introduced reusable logic

💡 *Outcome:* Improved maintainability and readability

---

### 🔹 UC13 – UC14: Advanced OOP & Design Principles

* Applied **SOLID principles**:

  * SRP, OCP, LSP, ISP, DIP
* Introduced:

  * Interfaces (`IMeasurable`)
  * Abstraction & polymorphism
  * Better extensibility

💡 *Outcome:* Production-level code design

---

### 🔹 UC15: N-Tier Architecture

* Structured backend into:

  * Controller Layer
  * Service Layer
  * Repository Layer
* Introduced DTOs and proper layering

💡 *Outcome:* Enterprise-ready backend structure

---

### 🔹 UC16: Database Integration

* Integrated database using:

  * JDBC / JPA
* Designed schema and persistence layer
* Handled transactions and connections

💡 *Outcome:* Persistent and data-driven application

---

### 🔹 UC17: Spring Boot Backend

* Built REST APIs using Spring Boot
* Implemented:

  * Dependency Injection
  * Service-based architecture
  * API endpoints for measurement operations

💡 *Outcome:* Fully functional backend service

---

### 🔹 UC18: Security & Authentication

* Implemented **Spring Security**
* Added:

  * JWT Authentication
  * OAuth2 integration
* Secured APIs and user access

💡 *Outcome:* Secure and production-ready backend

---

## 🏗️ Final Evolution: Microservices Architecture

At the final stage, the application is transformed into a **distributed microservices system**.

### 🔧 Components

* **API Gateway** → Central routing & JWT validation
* **Eureka Server** → Service discovery
* **User Service** → Authentication & user management
* **Measurement Service** → Core business logic
* **Admin Server** → Monitoring

---

## 🔄 System Flow

```text
Client → API Gateway → JWT Filter → Microservices
                    ↓
              Eureka Server
```

---

## ⚙️ Tech Stack

* Java
* Spring Boot
* Spring Cloud (Gateway, Eureka)
* Spring Security
* JWT / OAuth2
* Maven
* MySQL / H2
* Docker

---

## ▶️ Getting Started

```bash
git clone <your-repo-url>
cd QuantityMeasurementApp
mvn clean install
```

### Run with Docker

```bash
docker-compose up
```

---

## 📌 Why This Project Stands Out

* 📈 Shows **progressive learning (UC-wise evolution)**
* 🧩 Covers **OOP → Architecture → Security → Microservices**
* 🏗️ Demonstrates **real-world backend design patterns**
* 🔐 Includes **authentication & API security**
* ☁️ Ready for **cloud deployment & scaling**
