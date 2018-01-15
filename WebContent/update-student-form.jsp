<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Information</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link type = "text/css" rel="stylesheet" href = "css/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class = "container" >
		<form action = "StudentUpdateServlet" method = "POST">
			<input type = "text" name = "studentId" value = "${edit_student.id}"/>
			<div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="firstName">Firstname</label>
			      <input type="text" name = "firstName" class="form-control" id="firstName" value="${edit_student.firstname}">
			    </div>
			    <div class="form-group col-md-6">
			      <label for="lastName">Lastname</label>
			      <input type="text" name = "lastName" class="form-control" id="lastName" value="${edit_student.lastname}">
			    </div>
	 		</div>
	 		<div class="form-row">
			   	<div class="form-group col-md-6">
			      <label for="inputEmail4">Email</label>
			      <input type="email" name = "email" class="form-control" id="inputEmail4" value="${edit_student.email}">
			   	</div>
			    <div class="form-group col-md-6">
			      <label for="inputPassword4">Password</label>
			      <input type="password" name = "password" class="form-control" id="inputPassword4" placeholder="Password">
			    </div>
	  		</div>
				<div class="form-group col-md-12">
				    <label for="inputAddress">Address</label>
				    <input type="text" name = "address" class="form-control" id="inputAddress" placeholder="1234 Main St">
				</div>
		  	<div class="form-row">
		    	<div class="form-group col-md-6">
			      <label for="inputCity">City</label>
			      <input type="text" name = "city" class="form-control" id="inputCity">
			    </div>
			    <div class="form-group col-md-4">
				      <label for="inputState">State</label>
				      <select id="inputState" class="form-control">
				        <option selected>Choose</option>
				        <option>...</option>
				        <option>California</option>
				        <option>Washington</option>
				        <option>Florida</option>
				        <option>Wisconsin</option>
				        <option>Texas</option>
				        <option>Pennsylvania</option>
				      </select>
			    </div>
			    <div class="form-group col-md-2">
			      <label for="inputZip">Zip</label>
			      <input type="text" name = "zip" class="form-control" id="inputZip">
			    </div>
		  	</div>
		  	<button type="submit" class="submit btn btn-primary">Update</button>	
		</form>
		<a class = "cancel" href = "StudentControllerServlet"><button type = button" class="btn btn-danger" >Cancel</button></a>
	</div>
</body>
</html>