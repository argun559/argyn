# Object-Oriented Student Management System

## Overview
This project implements a Student Management System using Java and demonstrates key object-oriented programming principles. The system allows the management of students' data, including GPA, credits, and course enrollment. The project integrates fundamental OOP concepts such as encapsulation, composition, and abstraction.

Key features:
- Track student details like name, ID, GPA, and credits.
- Add students to a course and calculate the average GPA.
- Identify the student with the highest number of credits.

## Class Descriptions

### `Student` Class
Represents a student with the following fields:
- **`name`**: Student's name.
- **`id`**: Student's ID.
- **`major`**: Student's major.
- **`gpa`**: Student's GPA (default is 0.0).
- **`credits`**: Student's total credits (default is 0).

Methods:
- `addCredits(int c)`: Increases credits by `c`.
- `updateGPA(double newGPA)`: Updates GPA.
- `isHonors()`: Returns `true` if GPA >= 3.5.
- `toString()`: Returns a string with student details.

### `Course` Class
Represents a course with:
- **`courseName`**: Course name.
- **`instructor`**: Course instructor's name.
- **`students[]`**: An array of students in the course.

Methods:
- `addStudent(Student s, int index)`: Adds a student to the course.
- `courseAverageGPA()`: Returns the average GPA of the students.
- `highestCreditStudent()`: Finds the student with the highest credits.
- `toString()`: Returns a string with course details.

## Instructions to Compile and Run

### Compile the program:
```bash
javac *.java
Reflection
What I Learned

This project helped me practice object-oriented programming concepts like encapsulation, composition, and abstraction. I learned how to design classes that interact to manage data effectively.

Challenges Faced

I faced challenges in managing the array of students and ensuring data consistency when adding students or calculating averages.

Benefits of OOP

Encapsulation helped maintain data integrity by restricting direct access to fields, and composition allowed the Course class to manage multiple Student objects efficiently.

GitHub Workflow
assignment1-student-management/
├── src/
│   ├── Student.java
│   ├── Course.java
│   └── Main.java
├── README.md
└── .gitignore
