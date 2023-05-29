package com.example.moduletest.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentManager {
    private static String SQL_SELECT_DEPARTMENT_BY_ID = "SELECT departmentName FROM Department WHERE departmentId = ?;";

    public static String getDepartmentNameById(int departmentId) {
        Connection connection = EmployeeManager.getConnection();
        PreparedStatement preparedStatement;
        String departmentName = "";

        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_DEPARTMENT_BY_ID);
            preparedStatement.setInt(1, departmentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                departmentName = resultSet.getString("departmentName");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return departmentName;
    }
}
