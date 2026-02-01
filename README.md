# Car Rental Management System (JDBC, PostgreSQL)

## Project Description
This project is a **Car Rental Management System** implemented in **Java** using **JDBC** and **PostgreSQL**.  
The system follows a **layered architecture** and demonstrates proper usage of **OOP principles**, **SOLID**, **interfaces**, **generics**, **exception handling**, and **database integration**.

The application allows managing vehicles and engines, validating business rules, and preventing invalid or duplicate data from being stored in the database.

---

## Architecture Overview

The project is structured using a clean layered architecture:

- **Controller layer** – handles application flow
- **Service layer** – contains business logic and validation
- **Repository layer** – performs database operations using JDBC
- **Model layer** – represents domain entities
- **Exception layer** – custom runtime exceptions
- **Utility layer** – helper classes (reflection, sorting, DB connection)

This separation ensures **maintainability, scalability, and testability**.

---

## Technologies Used

- Java (JDK 17+)
- PostgreSQL
- JDBC
- IntelliJ IDEA
- pgAdmin

---

## Project Structure

src
├── controller
├── service
│ └── interfaces
├── repository
│ └── interfaces
├── model
├── exception
├── db
├── utils

---

## Database Design

The system uses a PostgreSQL database with the following tables:

### engine
- `id` (INT, PRIMARY KEY)
- `engine_type` (VARCHAR)
- `horse_power` (INT)

### vehicle
- `id` (INT, PRIMARY KEY)
- `name` (VARCHAR)
- `brand` (VARCHAR)
- `available` (BOOLEAN)
- `vehicle_type` (VARCHAR)
- `seats` (INT)
- `load_capacity_kg` (INT)
- `has_ac` (BOOLEAN)
- `engine_id` (INT, FOREIGN KEY → engine.id)

The database schema ensures **referential integrity** using foreign keys.

---

## Repository Layer (JDBC)

The repository layer uses **pure JDBC** with:
- `Connection`
- `PreparedStatement`
- `ResultSet`

A generic interface `CrudRepository<T>` is implemented to support:
- `create`
- `findById`
- `findAll`
- `update`
- `delete`

This demonstrates **generic programming** and **interface-based design**.

---

## Service Layer & Validation

The service layer:
- validates entities before saving
- checks for duplicate records
- throws meaningful custom exceptions

Example:
- Attempting to add an engine with an existing ID results in `DuplicateResourceException`.

This ensures **business rules are enforced at the service level**, not in controllers or repositories.

---

## Exception Handling

The project includes custom runtime exceptions, such as:
- `DuplicateResourceException`
- `DatabaseOperationException`
- `ValidationException`

These exceptions improve readability, debugging, and robustness of the system.

---

## How to Run the Project

1. Create a PostgreSQL database named `Cardb`
2. Execute the provided SQL schema to create tables
3. Update database credentials in `DatabaseConnection`
4. Run the `Main` class

The application will validate entities and perform database operations.

---

## Key Features Demonstrated

- SOLID principles
- Layered architecture
- Interfaces and generics
- JDBC with PostgreSQL
- Custom exception handling
- Data validation
- Prevention of duplicate records

---

## Conclusion

This project demonstrates a complete backend system using **Java, JDBC, and PostgreSQL**, following best practices in **object-oriented design** and **software architecture**.

It is designed for educational purposes and showcases how real-world backend applications are structured.
