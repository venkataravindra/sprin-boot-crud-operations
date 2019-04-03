<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<meta charset="ISO-8859-1">
<title>User Creation</title>
</head>
<body>
<center>
<form method="post" action="${pageContext.request.contextPath}/createation">
<div class="container">
  <h1>USER CREATION</h1>
</div>
<table class="table table-bordered table-striped">
<tr>
		<td>ID:</td>
		<td><input class="form-control" type="number" name ="id" required></td>
</tr>

<tr>
		<td>FirstName:</td>
		<td><input class="form-control" type="text" name ="FirstName" required></td>
</tr>
<tr>
		<td>LasstName:</td>
		<td><input class="form-control" type="text" name ="LastName" required></td>
</tr>
<tr>
		<td>Age:</td>
		<td><input class="form-control" type="number" name ="age" min="3" required></td>
</tr>
<tr>
	<td>Email:</td>
	<td><input class="form-control" type="text" name ="email" required></td>
</tr>

<tr>
		<td>UserName</td>
		<td><input class="form-control" type="text" name ="username" required></td>
</tr>
<tr>
		<td>Password</td>
		<td><input class="form-control" type="password" name ="password" required></td>
</tr>
<tr>
		<td>Address</td>
		<td><input class="form-control" type="text" name ="address"  required></td>
</tr>
<tr>
		<td  colspan="2" align="center"><input class="btn btn-info" type="submit" value ="CreateUser"></td>
</tr>

</table>
</form>
</center>

</body>
</html>