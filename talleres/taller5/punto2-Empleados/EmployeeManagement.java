import javax.swing.*;
import java.util.ArrayList;

public class EmployeeManagement {

    private ArrayList<Employee> employees;

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public EmployeeManagement() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {

        employees.remove(employee);
    }

    public void showEmployees() {
        for (Employee employee : employees) {
            JOptionPane.showMessageDialog(null,"Name: " + employee.getName() + ", Age: " + employee.getAge() +
                    ", Employee ID: " + employee.getEmployeeId() + ", Salary: " + employee.getSalary());
        }
    }
}
