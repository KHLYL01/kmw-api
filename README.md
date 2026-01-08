# KMW API 🛡️

### Enterprise Subscription Management System built with Clean Architecture & SOLID Principles

KMW is a robust backend engine designed to handle digital subscriptions, pricing strategies, and payment processing. This project is a showcase of high-level software engineering practices, moving beyond basic CRUD operations to a decoupled, maintainable, and highly testable architecture.

---

## 🏗️ Architectural Excellence: Clean Architecture
This project follows the **Hexagonal (Ports & Adapters) Architecture**, ensuring that the business logic (Core) remains independent of frameworks, databases, and external APIs.



### Project Structure:
- **Core Domain:** Pure Java entities and logic (The heart of the system).
- **Core Ports:** Interfaces defining the contracts for external communication (DIP).
- **Core UseCases:** Orchestrates specific business flows (SRP).
- **Infrastructure:** Low-level details like JPA repositories and external API adapters.
- **Web/API:** REST Controllers, DTOs, and MapStruct mappers.

---

## 🧩 SOLID Principles in Action

### 1. Single Responsibility Principle (SRP)
Each component has a singular focus. For instance, `RegisterUserUseCase` manages the registration flow, while dedicated `Mappers` handle data transformation, and `Adapters` handle persistence.

### 2. Open/Closed Principle (OCP)
The **Pricing Engine** utilizes the **Strategy Pattern**. New subscription tiers (e.g., VIP, Trial) can be introduced by adding a new `PricingStrategy` implementation without modifying the existing registration logic.



### 3. Liskov Substitution Principle (LSP)
All notification and payment providers are interchangeable. The system can substitute a `SendGridMailAdapter` with a `TwilioSmsAdapter` seamlessly, as both adhere strictly to the `NotificationProvider` contract.

### 4. Interface Segregation Principle (ISP)
Instead of a bloated "God Interface", I implemented specialized interfaces like `PaymentProcessor` and `Refundable`. Clients only depend on the methods they actually require.

### 5. Dependency Inversion Principle (DIP)
High-level business logic does not depend on low-level implementation details. Both depend on abstractions (Ports). This allows switching from MySql to MongoDB or Stripe to PayPal by simply swapping an Adapter.



---

## 🛠️ Tech Stack & Tools
- **Java 17+** & **Spring Boot 3.x**
- **Spring Data JPA** (Persistence)
- **MapStruct** (Professional Object Mapping)
- **MySql / H2** (Database)
- **Lombok** (Code Conciseness)
- **Jakarta Validation** (Robust Input Validation)
- **Swagger/OpenAPI** (Interactive Documentation)

---

## 🚀 Key Features
- **Decoupled Pricing Engine:** Dynamic discount calculation.
- **Multi-Provider Support:** Plug-and-play notification and payment systems.
- **Layered Data Protection:** Using DTOs to prevent internal entity exposure.
- **Global Error Handling:** Consistent API responses for business exceptions.

---

## 📖 Getting Started
1. **Clone the repo:**
   ```bash
   git clone [https://github.com/KHLYL01/kmw-api.git](https://github.com/KHLYL01/kmw-api.git)