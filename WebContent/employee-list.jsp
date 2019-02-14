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
	<form action="navigationServlet" method="post">
		<table>
			<c:forEach items="${requestScope.allEmployees}" var="currentemployee">
			<tr>
				<td><input type="radio" name="id" value="${currentemployee.id}"></td>
				<td>${currentemployee.department}</td>
				<td>${currentemployee.name}</td>
				<td>${currentemployee.yearsOfService}</td>
			</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToEmployee">
		<input type="submit" value="delete" name="doThisToEmployee">
		<input type="submit" value="add" name="doThisToEmployee">
	</form>
</body>
</html>