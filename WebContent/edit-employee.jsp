<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="editEmployeeServlet" method="post">
		Department: <input type="text" name="department" value="${employeeToEidt.department}">
		Name: <input type="text" name="name" value="${employeeToEidt.name}">
		Years of Service: <input type="text" name="yearsOfService" value="${employeeToEidt.yearsOfService}">
		<input type="hidden" name="id" value="${employeeToEdit.id}">
		<input type="submit" value="Save Edited Employee">
	</form>
</body>
</html>