

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
	html,body{
	width:100%;
	height:100%;
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
<body style="background-image: url('image/car2.png'); width: 100%; background-size: cover; background-repeat: no-repeat; background-attachment: fixed;">

	<header>
		
		
		<h1 align="center">Mr.Car Doctor</h1><hr><br>
		<span class="uh"><a href="<%=request.getContextPath()%>/list"
					class="d"> Users History </a></span>
		
		
	</header>
	<br>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit User
            		</c:if>
						<c:if test="${user == null}">
            			Add New User
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Customer Name </label> <input type="text"
						value="<c:out value='${user.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label> Customer Car Number </label> <input type="text"
						value="<c:out value='${user.vehicleNumber}' />" class="form-control"
						name="vehicleNumber">
				</fieldset>

				<fieldset class="form-group">
					<label>Car Model(with brand) </label> <input type="text"
						value="<c:out value='${user.vehicleModel}' />" class="form-control"
						name="vehicleModel">
				</fieldset>
				<fieldset class="form-group">
					<label>Customer Phone Number </label> <input type="text"
						value="<c:out value='${user.phone}' />" class="form-control"
						name="phone">
				</fieldset>
				<fieldset class="form-group">
					<label>Our Pickup Date </label> <input type="text"
						value="<c:out value='${user.date}' />" class="form-control"
						name="date">
				</fieldset>
				<fieldset class="form-group">
					<label>Our Delivery Date </label> <input type="text"
						value="<c:out value='${user.pickUpDate}' />" class="form-control"
						name="pickUpDate">
				</fieldset>
				<fieldset class="form-group">
					<label>What type of Services they want? </label> <input type="text"
						value="<c:out value='${user.serviceType}' />" class="form-control"
						name="serviceType">
				</fieldset>

				<button type="submit" class="btn btn-success">Submit</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>