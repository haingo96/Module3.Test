package com.example.moduletest.controller;

import com.example.moduletest.models.Department;
import com.example.moduletest.models.Employee;
import com.example.moduletest.services.DepartmentManager;
import com.example.moduletest.services.EmployeeManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "employeeServlet", value = "employee-servlet")
public class EmployeeServlet extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "delete":
                deleteEmployee(request,response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            default:
                displayAllEmployee(request, response);
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        request.setAttribute("employeeId", id);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit-form.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        EmployeeManager.deleteEmployee(id);
        displayAllEmployee(request, response);
    }

    private void displayAllEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employees = EmployeeManager.selectAllEmployee();

        request.setAttribute("employees", employees);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee-list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "submitForm":
                editEmployee(request, response);
                break;
            default:
                displayAllEmployee(request,response);
                break;
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        double salary = Double.parseDouble(request.getParameter("salary"));

        int departmentId = Integer.parseInt(request.getParameter("department"));
        String departmentName = DepartmentManager.getDepartmentNameById(departmentId);

        Employee employee = new Employee(id, name, email, address, phoneNumber, salary, new Department(departmentId, departmentName));
        EmployeeManager.updateEmployee(employee);

        displayAllEmployee(request, response);
    }

    public void destroy() {
    }
}
