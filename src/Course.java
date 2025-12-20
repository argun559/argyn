public class Course {
    private String courseName;
    private String instructor;
    private Student[] students;

    public Course(String courseName, String instructor, int size) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.students = new Student[size];
    }

    public void addStudent(Student s, int index) {
        if (index >= 0 && index < students.length) {
            students[index] = s;
        }
    }

    public double courseAverageGPA() {
        double totalGPA = 0;
        for (Student s : students) {
            if (s != null) {
                totalGPA += s.getGpa();
            }
        }
        return totalGPA / students.length;
    }

    public Student highestCreditStudent() {
        Student maxStudent = null;
        for (Student s : students) {
            if (s != null && (maxStudent == null || s.getCredits() > maxStudent.getCredits())) {
                maxStudent = s;
            }
        }
        return maxStudent;
    }

    @Override
    public String toString() {
        return "Course{courseName='" + courseName + "', instructor='" + instructor + "'}";
    }
}


