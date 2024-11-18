class Employee {
  protected int employeeID;
  private double salary;

  public Employee(int id, double salary) {
      this.employeeID = id;
      this.salary = salary;
  }
}

class emp extends Employee {
  public emp(int id, double salary) {
      super(id, salary);
  }

  public void displayEmployeeID() {
      System.out.println("Employee ID: " + employeeID);
  }
}

public class emp {
  public static void main(String[] args) {
      emp manager = new emp(101, 50000);
      manager.displayEmployeeID();

      // The following line would cause a compilation error due to private access
      // System.out.println("Salary: " + manager.salary);
  }
}