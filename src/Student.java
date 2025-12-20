public class Student {
    private String name;
    private String id;
    private String major;
    private double gpa = 0.0;
    private int credits = 0;

    public Student(String name, String id, String major) {
        this.name = name;
        this.id = id;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getMajor() {
        return major;
    }

    public double getGpa() {
        return gpa;
    }

    public int getCredits() {
        return credits;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void addCredits(int c) {
        this.credits += c;
    }

    public void updateGPA(double newGPA) {
        this.gpa = newGPA;
    }

    public boolean isHonors() {
        return gpa >= 3.5;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', id='" + id + "', major='" + major + "', gpa=" + gpa + ", credits=" + credits + '}';
    }
}

