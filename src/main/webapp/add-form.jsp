<%--
  Created by IntelliJ IDEA.
  User: ngoho
  Date: 5/29/2023
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="employee-servlet" method="post">
  <h2>Edit employee</h2>
  <div>
    Name
    <input type="hidden" name="action" value="submitAddForm">
    <input type="text" name="name">
  </div>
  <div>
    Email
    <input type="email" name="email">
  </div>
  <div>
    Address
    <input type="text" name="address">
  </div>
  <div>
    Phone Number
    <input type="number" name="phoneNumber">
  </div>
  <div>
    Salary
    <input type="number" name="salary">
  </div>
  <div>
    <select name="department">
      <option value="1">Accountant</option>
      <option value="2">Technical</option>
    </select>
  </div>
  <input type="submit" value="Submit">
</form>
</body>
</html>
</body>
</html>
