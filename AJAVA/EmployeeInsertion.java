import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeInsertion{
    public static void main(String[] args) {
        try {
            // JDBC connection parameters
            String url = "jdbc:mysql://localhost:3306/your_database";
            String username = "your_username";
            String password = "your_password";

            // Sample data for insertion
            int[] employeeIds = {101, 102, 103};
            String[] employeeNames = {"John Doe", "Jane Smith", "Bob Johnson"};
            double[] employeeSalaries = {50000.0, 60000.0, 70000.0};
            // Establishing a connection to the database
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                // Using a PreparedStatement for INSERT
                String insertQuery = "INSERT INTO employees(emp_id, emp_name, emp_salary) VALUES (?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    // Loop through the employees and set parameter values
                    for (int i = 0; i < employeeIds.length; i++) {
                        preparedStatement.setInt(1, employeeIds[i]);
                        preparedStatement.setString(2, employeeNames[i]);
                        preparedStatement.setDouble(3, employeeSalaries[i]);
                        // Execute the update (INSERT) query
                        int rowsAffected = preparedStatement.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Record for employee ID " + employeeIds[i] + " inserted successfully.");
                        } else {
                            System.out.println("Failed to insert record for employee ID " + employeeIds[i] + ".");
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
