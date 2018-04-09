<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car List</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed"
	rel="stylesheet" />
</head>
<body>
	<div class="container mt-5">
		<h1 class="text-center text-md-left text-light display-4">Car
			List</h1>
		<table class="table">
			<thead>
				<tr class="header">
					<p class="text-light">To sort the list please click the header you want to sort
						by!</p>
					<td><a href="sort?by=manufacturer" class="text-purple">Manufacturer</a></td>
					<td><a href="sort?by=model" class=" text-purple">Model</a></td>
					<td><a href="sort?by=modelYear" class="text-purple">Year</a></td>
					<td><a href="sort?by=expire_date" class="text-purple">Expiring At</a></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</thead>
			<tbody class="tableBody">
				<c:if test="${empty cars }">
						<p class="text-light display-4"> There is no car available!</p>
				</c:if>
				<c:if test="${not empty cars }">
					<c:forEach var="c" items="${cars}">
					<tr>
						<td class="font-weight-bold">${c.manufacturer}</td>
						<td class="font-weight-bold">${c.model}</td>
						<td class="font-weight-bold">${c.modelYear}</td>
						<td class="font-weight-bold">${c.expireDate}</td>
						<td><a href="detail?id=${c.id}" class="btn btn-success">Show</a></td>
						<td><a href="edit-car?id=${c.id}" class="btn btn-warning text-white">Edit</a></td>
						<td><a href="delete-car?id=${c.id}" class="btn btn-danger">Delete</a></td>
					</tr>
				</c:forEach>
				</c:if>
				
				<caption><a class="btn btn-outline customBtn" href="add-car">Add new car</a></caption>
			</tbody>
		</table>
		
	</div>

</body>
</html>