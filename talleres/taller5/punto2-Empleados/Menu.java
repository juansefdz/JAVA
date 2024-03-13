import javax.swing.*;

public class Menu {
    public void menu() {

        int option;
        EmployeeManagement employeeManagement = new EmployeeManagement();
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    EMPLOYEE MANAGEMENT MENU
                                    
                    1. Add employee.
                    2. Delete employee.
                    3. Show Employees list.
                                    
                    4. Exit. 
                                    
                    Enter the desired option"""));
            switch (option) {
                case 1:
                    String employeeType = JOptionPane.showInputDialog(null, """
                            What type of employee do you want to enter:
                            - Permanent
                            - Temporary
                            """).toLowerCase();
                    if (employeeType.equals("permanent") || employeeType.equals("temporary")) {
                        String name = JOptionPane.showInputDialog(null, "Enter employee name:");
                        int age = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter employee age:"));
                        int employeeId = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter employee ID:"));
                        double salary = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter employee salary:"));
                        switch (employeeType) {
                            case "permanent":
                                employeeManagement.addEmployee(new PermanentEmployee(name, age, employeeId, salary));
                                break;
                            case "temporary":
                                employeeManagement.addEmployee(new TemporaryEmployee(name, age, employeeId, salary));
                                break;
                        }
                    }
                    break;
                case 2:
                    int employeeIdToDelete = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter employee ID to delete:"));
                    // Buscar el empleado por su ID y eliminarlo
                    for (Employee temporalEmp : employeeManagement.getEmployees()) {
                        if (temporalEmp.getEmployeeId() == employeeIdToDelete) {
                            employeeManagement.removeEmployee(temporalEmp);
                            JOptionPane.showMessageDialog(null, "Employee deleted successfully.");
                            break;
                        }
                    }
                    break;
                case 3:
                    employeeManagement.showEmployees();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Thanks for using the software.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please choose a valid option.");
            }
        } while (option != 4);
    }
}



