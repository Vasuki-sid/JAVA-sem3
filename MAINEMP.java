public class MAINEMP {
    public static void main(String[] args) {
        // Create instances of Manager and Programmer
        Manager manager = new Manager("Alice", 80000, 15000); // Base salary + bonus
        Programmer programmer = new Programmer("Bob", 60000, 5000); // Base salary + overtime pay

        // Display details and calculated salaries
        System.out.println("Manager Details:");
        manager.displayDetails();
        System.out.println("Total Salary: " + manager.calculateSalary());

        System.out.println("\nProgrammer Details:");
        programmer.displayDetails();
        System.out.println("Total Salary: " + programmer.calculateSalary());
    }
}