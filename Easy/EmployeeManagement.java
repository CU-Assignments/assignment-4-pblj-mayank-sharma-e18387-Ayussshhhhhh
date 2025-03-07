import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private String empId;
    private String name;
    private double salary;

    public Employee(String empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    public String getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + empId + ", Name: " + name + ", Salary: " + salary;
    }
}

class EmployeeManagementSystem {
    private ArrayList<Employee> employees;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
    }

    public void addEmployee(String empId, String name, double salary) {
        employees.add(new Employee(empId, name, salary));
        System.out.println("Employee added successfully!");
    }

    public void updateEmployee(String empId, String name, Double salary) {
        for (Employee emp : employees) {
            if (emp.getEmpId().equals(empId)) {
                if (name != null && !name.isEmpty()) {
                    emp.setName(name);
                }
                if (salary != null) {
                    emp.setSalary(salary);
                }
                System.out.println("Employee details updated!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public void removeEmployee(String empId) {
        employees.removeIf(emp -> emp.getEmpId().equals(empId));
        System.out.println("Employee removed successfully!");
    }

    public void searchEmployee(String empId) {
        for (Employee emp : employees) {
            if (emp.getEmpId().equals(empId)) {
                System.out.println(emp);
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found!");
        } else {
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        }
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManagementSystem system = new EmployeeManagementSystem();
        
        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    String empId = scanner.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double salary = scanner.nextDouble();
                    system.addEmployee(empId, name, salary);
                    break;
                case 2:
                    System.out.print("Enter Employee ID to update: ");
                    empId = scanner.nextLine();
                    System.out.print("Enter new name (press Enter to skip): ");
                    name = scanner.nextLine();
                    System.out.print("Enter new salary (press Enter to skip): ");
                    String salaryInput = scanner.nextLine();
                    Double newSalary = salaryInput.isEmpty() ? null : Double.parseDouble(salaryInput);
                    system.updateEmployee(empId, name, newSalary);
                    break;
                case 3:
                    System.out.print("Enter Employee ID to remove: ");
                    empId = scanner.nextLine();
                    system.removeEmployee(empId);
                    break;
                case 4:
                    System.out.print("Enter Employee ID to search: ");
                    empId = scanner.nextLine();
                    system.searchEmployee(empId);
                    break;
                case 5:
                    system.displayAllEmployees();
                    break;
                case 6:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
