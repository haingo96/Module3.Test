package com.example.moduletest.models;

public class Employee {
    private int employeeId;
    private String Name;
    private String email;
    private String address;
    private String phoneNumber;
    private double salary;
    private Department department;

    public Employee() {
    }

    public Employee(String name, String email, String address, String phoneNumber, double salary, Department department) {
        Name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.department = department;
    }

    public Employee(int employeeId, String name, String email, String address, String phoneNumber, double salary, Department department) {
        this.employeeId = employeeId;
        Name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.department = department;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
