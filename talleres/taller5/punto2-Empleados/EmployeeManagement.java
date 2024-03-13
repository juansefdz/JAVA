import java.util.ArrayList;

public class EmployeeManagement {
    private ArrayList<Employee> employees;

    public EmployeeManagement(){
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee); // Fixed line
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public void showEmployees() {
        for (Employee employee : employees) {
            System.out.println("Name: " + employee.getName() + ", Age: " + employee.getAge() +
                    ", Employee ID: " + employee.getEmployeeId() + ", Salary: " + employee.getSalary());
        }
    }
}
