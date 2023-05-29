<%--
  Created by IntelliJ IDEA.
  User: ngoho
  Date: 5/29/2023
  Time: 9:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>PhoneNumber</th>
        <th>Salary</th>
        <th>Department</th>
        <th>Action</th>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.getEmployeeId()}</td>
            <td>${employee.getName()}</td>
            <td>${employee.getEmail()}</td>
            <td>${employee.getAddress()}</td>
            <td>${employee.getPhoneNumber()}</td>
            <td>${employee.getSalary()}</td>
            <td>${employee.getDepartment().getDepartmentname()}</td>
            <a href="/employee-servlet?action=edit&id=${employee.getEmployeeId()}"></a>
            <a href="/employee-servlet?action=delete&id=${employee.getEmployeeId()}"></a>
        </tr>
    </c:forEach>
</table>
</body>
</html>
