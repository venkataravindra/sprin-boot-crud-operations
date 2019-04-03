<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users Display</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>
	<center>
		<form action="/create" method="GET">
			<div class="container">
				<h1>Users Display</h1>
				<table border="5" class="table table-bordered table-striped">
					<tr>
						<th>ID</th>
						<th>FirstName</th>
						<th>LastName</th>
						<th>Age</th>
						<th>E-mail</th>
						<th>address</th>
						<th>Delete</th>
						<th>Edit</th>
					</tr>
					<c:forEach var="row" items="${data}">
						<tr>
							<td>${row.id}</td>
							<td>${row.firstName}</td>
							<td>${row.lastName}</td>
							<td>${row.age }</td>
							<td>${row.email}</td>
							<td>${row.address}</td>
							<td><a href="deleteUser?id=${row.id}"
								class="btn btn-info btn-lg"><span
									class="glyphicon glyphicon-trash"></span></a></td>
							<td><a href="editUser?id=${row.id}"
								class="btn btn-info btn-lg"><span
									class="glyphicon glyphicon-pencil"></span> </a></td>

						</tr>
					</c:forEach>
					<tr>
						<td colspan="8" align="center"> <button type="submit" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-plus"></span> Create User</button></td>
					</tr>

				</table>
			</div>
		</form>
	</center>
</body>
</html>