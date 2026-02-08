Endterm Project – REST API (Spring Boot)
Project Overview
This project is a REST API application developed as an endterm project for the course.
The main goal of the project is to demonstrate understanding of Spring Boot, REST architecture, layered application structure, and design patterns.

The application manages media content and orders using a clean separation between controllers, services, repositories, and models.

Technologies Used

Java 25
Spring Boot
Spring Web (REST API)
Spring Data JPA
H2 in-memory database
Maven
IntelliJ IDEA
Project Structure

The project follows the recommended repository structure provided in the assignment:

src/main/java/
 ├── controller     // REST controllers
 ├── service        // Business logic layer
 ├── repository     // Data access layer (JPA)
 ├── model          // Entity classes
 ├── dto            // Data Transfer Objects
 ├── exception      // Custom exceptions
 ├── patterns       // Design patterns implementation
 ├── utils          // Utility classes
 └── Application.java

src/main/resources/
 └── application.properties
 REST API
The application exposes REST endpoints using Spring MVC annotations.

Example Endpoint
GET /api/media
This endpoint returns a list of media content in JSON format.
If no records exist in the database, an empty list is returned.

Design Patterns

The following design patterns were implemented in the project:
Builder Pattern
Used for constructing complex objects such as orders in a step-by-step manner.
Factory Pattern
Used to create different types of media content based on input parameters.
Singleton Pattern
Used in cases where a single shared instance is required across the application.
These patterns help improve flexibility, readability, and maintainability of the code.

Database Configuration
The project uses an H2 in-memory database for development and demonstration purposes.
All database configuration settings are located in:
src/main/resources/application.properties

This allows the application to run without the need for an external database.

How to Run the Application
Open the project in IntelliJ IDEA
Make sure all Maven dependencies are downloaded
Run the Application.java class
Open a browser and navigate to:

http://localhost:8080/api/media

Screenshots

The docs/ folder contains screenshots that demonstrate:
Project structure in IntelliJ IDEA
Successful application startup
REST API response in the browser
UML or architecture diagram

These screenshots confirm correct project setup and functionality.

Conclusion

This project demonstrates the use of Spring Boot for building RESTful web services, proper layering of application components, and implementation of common design patterns.
All functional and structural requirements of the assignment have been fulfilled.


This structure ensures separation of concerns and improves readability and maintainability of the code.
