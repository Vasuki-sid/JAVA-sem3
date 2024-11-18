
// Main class to test Student functionality
public class Mainstd {
    public static void main(String[] args) {
        // Create a new Student object
        Student student = new Student("S001", "John Doe");

        // Display initial details
        System.out.println("Initial Student ID: " + student.getStudentId());
        System.out.println("Initial Student Name: " + student.getStudentName());

        // Update student details
        student.setStudentId("S002");
        student.setStudentName("Jane Doe");

        // Add grades with validation
        student.addGrade(85.5);  // Valid grade
        student.addGrade(92.0);   // Valid grade
        student.addGrade(150.0);  // Invalid grade (out of range)

        // Display updated details and grades
        System.out.println("Updated Student ID: " + student.getStudentId());
        System.out.println("Updated Student Name: " + student.getStudentName());

        // Display all grades
        student.displayGrades();
    }
}