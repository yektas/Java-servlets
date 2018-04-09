<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car details</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed"
	rel="stylesheet" />
</head>
<body>
	<div class="container">
		<h3 class="text-center text-md-left text-light display-4">Car details</h3>
		<div class="col-md-12">
			<div class="card text-center mt-5">
				<div class="card-body">
					<h3>${car.manufacturer} - ${car.model}</h3>
					<p class="card-text">
					<table class="table">
						<tbody>
							<tr>
								<th scope="row">Id:</th>
								<td>${car.id}</td>
							</tr>
							<tr>
								<th scope="row">Manufacturer:</th>
								<td>${car.manufacturer}</td>
							</tr>
							<tr>
								<th scope="row">Model:</th>
								<td>${car.model}</td>
							</tr>
							<tr>
								<th scope="row">Year:</th>
								<td>${car.modelYear}</td>
							</tr>
							<tr>
								<th scope="row">Description:</th>
								<td>${car.description}</td>
							</tr>
							<tr>
								<th scope="row">Expire Date:</th>
								<td>${car.expireDate}</td>
							</tr>
						</tbody>
					</table>
					<a href="add-car" class="btn btn-outline purpleBtn">Add new car</a>
					<a href="show-cars" class="btn btn-outline purpleBtn">Display all cars</a>
				</div>
			</div>
		</div>
	</div>


</body>
</html>