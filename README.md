Media Management REST API
Project Overview
This project is a REST API application developed as an endterm project for the course.
The goal of the project is to demonstrate understanding of:

Spring Boot
REST architecture
Layered application structure
Design patterns
Caching mechanisms
The application manages media content (movies, series, etc.) and supports full CRUD operations.
The project follows a clean layered architecture: controller → service → repository → database.
Technologies Used
Java 25
Spring Boot
Spring Web (REST API)
Spring Data JPA
H2 in-memory database
Spring Cache (in-memory caching)
Maven
IntelliJ IDEA
Project Structure
src/main/java/
 ├── controller     // REST controllers
 ├── service        // Business logic layer
 ├── repository     // Data access layer (JPA)
 ├── model          // Entity classes
 ├── dto            // Data Transfer Objects
 ├── exception      // Custom exceptions
 ├── patterns       // Factory & Singleton implementations
 ├── utils          // Utility classes
 └── Application.java


The structure strictly follows the layered architecture principle.
Each layer has a single responsibility.
Implemented Design Patterns
1. Factory Pattern

Used for creating different types of media content through MediaFactory.

2. Singleton Pattern

Used in LoggingService to ensure only one logging instance exists.

3. Caching (Spring In-Memory Cache)

Implemented using Spring’s caching abstraction.

Caching Implementation

To improve performance, an in-memory caching layer was added in the Service layer using Spring Cache.

Why caching was added?

The method findAll() and findById() are frequently used.
Without caching, each request would query the database.
With caching enabled, repeated requests return data from memory instead of H2.

How it works

@Cacheable is used for read operations:

findAll()

findById(Long id)

@CacheEvict is used for write operations:

create()

update()

delete()

When media content is modified, the cache is automatically cleared to prevent stale data.

Technical details

Cache type: Spring Simple In-Memory Cache

Storage: ConcurrentHashMap (managed by Spring)

Scope: Singleton (Spring Beans are singleton by default)

Enabled via @EnableCaching

This approach keeps caching logic inside the Service layer and does not break layered architecture.

REST Endpoints
Media Endpoints
Method	Endpoint	Description
GET	/media	Get all media
GET	/media/{id}	Get media by ID
POST	/media	Create new media
PUT	/media/{id}	Update media
DELETE	/media/{id}	Delete media
Database

The project uses H2 in-memory database.

Database runs in memory

Data resets on application restart

Suitable for development and testing

How to Run

Clone the repository

Open in IntelliJ IDEA

Run Application.java

Access API via:

http://localhost:8080

Architectural Notes

Controller layer handles HTTP requests

Service layer contains business logic and caching

Repository layer handles database access

DTOs are used to transfer data between layers

Custom exceptions improve error handling

Caching improves performance without breaking clean architecture

The application follows SOLID principles and separation of concerns.

Conclusion

This project demonstrates:

Proper REST API development using Spring Boot

Clean layered architecture

Usage of design patterns (Factory, Singleton)

Integration of in-memory caching

Good separation of responsibilities

The caching layer improves performance for frequently accessed data while keeping the system consistent and maintainable.
