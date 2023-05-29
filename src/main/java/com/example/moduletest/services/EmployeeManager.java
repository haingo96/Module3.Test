package com.example.moduletest.services;

import com.example.moduletest.models.Employee;
import com.example.moduletest.models.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/employeemanagedb";
    private static final String SQL_USERNAME = "root";
    private static final String SQL_PASSWORD = "C0223g1@";

    private static final String SQL_SELECT_ALL_EMPLOYEE = "SELECT * FROM Employee;";
    private static final String SQL_DELETE_EMPLOYEE_BY_ID = "DELETE FROM Employee WHERE employeeId = ?;";
    private static final String SQL_UPDATE_EMPLOYEE_BY_ID = "UPDATE Employee SET name = ?, email = ?, address = ?, phoneNumber = ?, salary = ?, departmentId = ? WHERE employeeId = ?;";
    private static final String SQL_INSERT_EMPLOYEE = "INSERT INTO Employee VALUES (NULL, ?, ?, ?, ?, ?, ?);";
    private static final String SQL_SELECT_EMPLOYEE_BY_NAME = "SELECT name FROM Employee WHERE name LIKE ?;";

    public static Connection getConnection() {
        Connection connection;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, SQL_USERNAME, SQL_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

    public static List<Employee> selectAllEmployee() {
        List<Employee> employees = new ArrayList<>();

        Connection connection = getConnection();
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_EMPLOYEE);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("employeeId");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                double salary = resultSet.getDouble("salary");

                int departmentId = resultSet.getInt("departmentId");
                String departmentName = DepartmentManager.getDepartmentNameById(departmentId);

                Employee employee = new Employee(id, name, email, address, phoneNumber, salary, new Department(departmentId, departmentName));

                employees.add(employee);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employees;
    }

    public static void deleteEmployee(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(SQL_DELETE_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateEmployee (Employee e) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(SQL_UPDATE_EMPLOYEE_BY_ID);
            preparedStatement.setString(1, e.getName());
            preparedStatement.setString(2, e.getEmail());
            preparedStatement.setString(3, e.getEmail());
            preparedStatement.setString(4, e.getPhoneNumber());
            preparedStatement.setDouble(5, e.getSalary());
            preparedStatement.setInt(6, e.getDepartment().getDepartmentId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void addEmployee(Employee e) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(SQL_INSERT_EMPLOYEE);
            preparedStatement.setString(1, e.getName());
            preparedStatement.setString(2, e.getEmail());
            preparedStatement.setString(3, e.getEmail());
            preparedStatement.setString(4, e.getPhoneNumber());
            preparedStatement.setDouble(5, e.getSalary());
            preparedStatement.setInt(6, e.getDepartment().getDepartmentId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static List<Employee> searchEmployee(String inputSearch) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement;
        List<Employee> employees = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(SQL_INSERT_EMPLOYEE);
            preparedStatement.setString(1, "%" + inputSearch + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employeeId");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                double salary = resultSet.getDouble("salary");

                int departmentId = resultSet.getInt("departmentId");
                String departmentName = DepartmentManager.getDepartmentNameById(departmentId);

                Employee employee = new Employee(id, name, email, address, phoneNumber, salary, new Department(departmentId, departmentName));

                employees.add(employee);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return employees;
    }
}
