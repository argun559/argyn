public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Alice", "S001", "Computer Science");
        Student student2 = new Student("Bob", "S002", "Mathematics");
        Student student3 = new Student("Charlie", "S003", "Physics");
        Student student4 = new Student("David", "S004", "Biology");
        Student student5 = new Student("Eva", "S005", "Chemistry");

        student1.updateGPA(3.8);
        student1.addCredits(15);
        student2.updateGPA(3.2);
        student2.addCredits(20);
        student3.updateGPA(3.6);
        student3.addCredits(18);
        student4.updateGPA(3.9);
        student4.addCredits(22);
        student5.updateGPA(3.3);
        student5.addCredits(19);


        Course course = new Course("Introduction to Java", "Prof. Smith", 5);
        course.addStudent(student1, 0);
        course.addStudent(student2, 1);
        course.addStudent(student3, 2);
        course.addStudent(student4, 3);
        course.addStudent(student5, 4);


        Student[] students = { student1, student2, student3, student4, student5 };


        System.out.println("Students:");
        for (Student s : students) {
            System.out.println(s);
        }


        System.out.println(course);


        System.out.println("Highest credit student: " + course.highestCreditStudent());


        System.out.println("Course average GPA: " + course.courseAverageGPA());


        System.out.println("Top student by GPA: " + getTopStudent(students));
        System.out.println("Number of honors students: " + countHonors(students));
        System.out.println("Total credits earned: " + totalCredits(students));
    }


    public static Student getTopStudent(Student[] arr) {
        Student topStudent = null;
        for (Student s : arr) {
            if (topStudent == null || s.getGpa() > topStudent.getGpa()) {
                topStudent = s;
            }
        }
        return topStudent;
    }


    public static int countHonors(Student[] arr) {
        int count = 0;
        for (Student s : arr) {
            if (s.isHonors()) {
                count++;
            }
        }
        return count;
    }


    public static int totalCredits(Student[] arr) {
        int total = 0;
        for (Student s : arr) {
            total += s.getCredits();
        }
        return total;
    }
}

