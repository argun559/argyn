# Vehicle Management System

## Project Overview
This project demonstrates Object-Oriented Programming concepts in Java, including inheritance, abstraction, composition, and aggregation.  
The system manages different types of vehicles and their drivers.

## Class Hierarchy
- Vehicle (abstract superclass)
- Car, Motorcycle, Truck (subclasses)

Vehicle defines common fields and abstract methods.
Subclasses override engine behavior.

Driver is used to demonstrate composition and aggregation.

## Compilation and Execution
javac *.java  
java Main

## Screenshots
Add screenshots of the program output here.

## Reflection
Inheritance simplified the design by allowing common vehicle logic to be placed in one abstract class.
Method overriding allowed each vehicle type to have its own engine behavior.

The main challenge was using protected fields correctly and passing objects through constructors.
