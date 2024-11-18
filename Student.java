import java.util.ArrayList;
import java.util.List;

// Student.java
public class Student {
    // Private instance variables
    private String student_id;
    private String student_name;
    private List<Double> grades; // List to store grades

    // Constructor to initialize the Student object
    public Student(String student_id, String student_name) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.grades = new ArrayList<>(); // Initialize the grades list
    }

    // Getter method for student_id
    public String getStudentId() {
        
        return student_id;
    }

    // Setter method for student_id
    public void setStudentId(String student_id) {
        this.student_id = student_id;
        System.out.println("Student ID updated to: " + student_id);
    }

    // Getter method for student_name
    public String getStudentName() {
        return student_name;
    }

    // Setter method for student_name
    public void setStudentName(String student_name) {
        this.student_name = student_name;
        System.out.println("Student Name updated to: " + student_name);
    }

    // Method to add a grade with validation
    public void addGrade(double grade) {
        if (grade >= 0 && grade <= 100) { // Validate that the grade is between 0 and 100
            grades.add(grade);
            System.out.println("Grade added: " + grade);
        } else {
            System.out.println("Invalid grade. Please enter a grade between 0 and 100.");
        }
    }

    // Method to display all grades
    public void displayGrades() {
        System.out.println("Grades for " + student_name + ": " + grades);
    }
}
