<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Mr.Car Doctor</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<style>
	body{
	}
	.uh{
	color: white;
  	background-color: black;
  	opacity: 0.8;
  	width: 40px;
  	padding: 10px;
  	margin-left: 20px;
	}
	</style>
</head>
<body style="background-image: url('Image/car2.jpg');">

	<header>
		<h1 align="center">Mr.Car Doctor</h1><hr><br>
		<span class="uh"><a href="<%=request.getContextPath()%>/list"
					class="d"> Users History </a></span>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Users</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New User</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Car Number</th>
						<th>Car Model</th>
						<th>Customer Phone Number</th>
						<th>Our Pickup Date</th>
						<th>Customer Pickup Date</th>
						<th>Service Type</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="user" items="${listUser}">

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.name}" /></td>
							<td><c:out value="${user.vehicleNumber}" /></td>
							<td><c:out value="${user.vehicleModel}" /></td>
							<td><c:out value="${user.phone}" /></td>
							<td><c:out value="${user.date}" /></td>
							<td><c:out value="${user.pickUpDate}" /></td>
							<td><c:out value="${user.serviceType}" /></td>
							
							<td><a href="edit?id=<c:out value='${user.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${user.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>