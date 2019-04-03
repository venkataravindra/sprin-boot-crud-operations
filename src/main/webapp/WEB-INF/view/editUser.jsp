<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<title>EditUser</title>
</head>
<body>
	<center>
		<form action="/update" method="post" >
			<div class="container">
				<h1>Users</h1>
				<table border="5" class="table table-bordered table-striped">
					<tr>
						<th>ID</th>
						<th>FirstName</th>
						<th>LastName</th>
						<th>Age</th>
						<th>E-mail</th>
						<th>address</th>
						

					</tr>
					<c:forEach var="row" items="${user}">
						<tr>
							<td><input type="text" name="id" value="${row.id}" /></td>
							<td><input type="text" name="firstName"
								value="${row.firstName}" /></td>
							<td><input type="text" name="lastName"
								value="${row.lastName}" /></td>
							<td><input type="text" name="age" value="${row.age }" /></td>
							<td><input type="text" name="email" value="${row.email}" /></td>
							<td><input type="text" name="address" value="${row.address}" /></td>
						<tr>
							<td colspan="8" align="center"><button type="submit"
								class="btn btn-info btn-lg"><span
									class="glyphicon glyphicon-pencil"></span> </button></td>
						</tr>

				
					</c:forEach>
				 
				</table>
				
			</div>
		</form>
	</center>
</body>
</html>