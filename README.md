Car Rental Management System (Console Application)

Project Overview

This project is a console-based Car Rental Management System implemented in Java.
The application demonstrates a layered architecture using Controller → Service → Repository design and interacts with a PostgreSQL database via JDBC.

The project is designed to showcase CRUD operations, polymorphism, validation, and custom exception handling, as required by the assignment.

⸻

Architecture

The project follows a clean layered structure:
 • controller – entry point of the application (Main.java)
 • service – business logic and validation
 • repository – database access (JDBC)
 • model – domain entities
 • exception – custom exceptions
 • utils – database connection utilities

⸻

Controller Responsibilities (Main.java)

The Main class acts as the controller and performs the following responsibilities:

1. Entry Point
 • main() serves as the entry point of the application.
 • Demonstrates all system operations in sequence.

2. Service Layer Invocation
 • All operations are executed through the service layer.
 • Ensures validation and business logic are applied before database access.

⸻

Demonstrated CRUD Operations

Create
 • Customers are created using addCustomer()
 • Vehicles are created using addVehicle()
 • Rentals are created using createRental()

Read
 • All vehicles are retrieved using getAll()
 • Vehicle details are printed to the console

Update
 • Vehicle price updates are demonstrated via service methods

Delete
 • Customers, vehicles, and rentals are removed using delete() methods

⸻

Polymorphism Demonstration
 • Vehicles are referenced using the base class VehicleBase
 • Method calls such as:v.displayInfo();
 v.calculatoteTotal(days);
 execute subclass-specific behavior:
 • EconomyCar
 • LuxuryCar

This demonstrates runtime polymorphism as required.

⸻

Validation and Custom Exceptions

The controller intentionally triggers validation and exceptions to demonstrate correct handling:

Validation
 • Empty customer name → InvalidInputException

Duplicate Resource
 • Duplicate vehicle license plate → DuplicateResourceException

Resource Not Found
 • Creating a rental with a non-existing customer → ResourceNotFoundException

All exceptions are:
 • Thrown in the service layer
 • Properly handled and printed in the console

⸻

Console Output (Simulation of Requests / Responses)

The console output simulates real API behavior by displaying:
 • Successfully created entities
 • Retrieved data
 • Validation errors
 • Database constraint violations
 • Custom exception messages

This fulfills the requirement of simulating example requests and responses via CLI.

⸻

Technologies Used
 • Java
 • JDBC
 • PostgreSQL
 • IntelliJ IDEA

⸻

Notes
 • The controller implementation is inspired by the provided example but not copied.
 • The number of entities, methods, and exceptions differs from the example and is adapted specifically for the Car Rental domain.
 • The project fully complies with the assignment requirements.
