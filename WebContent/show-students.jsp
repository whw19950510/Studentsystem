<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link type = "text/css" rel="stylesheet" href = "css/style.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Student Information</title>
</head>
<body>

	<div class = "container" >
		<div id = "content">
			<table class = "table table-striped">
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>   	
				<c:forEach items = "${show_students}" var = "currentstu">
					<tr>
						<td>
							<c:out value="${currentstu.getId()}"></c:out>
						</td>
						<td>
							<c:out value = "${currentstu.getFirstname()}"></c:out>
						</td>
						<td>
							<c:out value = "${currentstu.getLastname()}"></c:out>
						</td>
						<td>
							<c:out value = "${currentstu.getEmail()}"></c:out>
						</td>
						<td>
							<a id = "update" class ="btn btn-sm btn-info" href = "update-student-form.jsp"><i class="tiny material-icons">edit</i>Update</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<a id = "add" class = "btn btn-primary" role="button" href = "add-student-form.jsp"><i class="tiny material-icons">add_circle</i>Add Student</a>
	</div>
</body>
</html>