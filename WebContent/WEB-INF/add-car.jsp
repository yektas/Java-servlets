<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet" href="css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>

<body>
	<div class="py-5">
		<div class="container">
			<div class="row">
				<div class="align-self-center col-md-6  h-50">
					<h1 class="text-center text-md-left text-light display-4">Welcome
						to the Shop</h1>
					<p class="text-light">Fill the form to add a new
						car to your shop!</p>
				</div>
				<div class="col-md-6">
					<div class="card">
						<div class="card-body p-5">
							<h3 class="pb-3 ">Add a new car</h3>
							<form class="carForm" action="add-car" method="post">
								<div class="form-group">
									<label class="font-weight-bold">Manufacturer:<br></label>
									<c:if test="${not empty errorManufacturer}">
										<div class="alert alert-danger" role="alert">${errorManufacturer}</div>
									</c:if>
									<input class="form-control" name="manufacturer">
								</div>
								<div class="form-group">
									<label class="font-weight-bold" >Model:<br></label>
									<c:if test="${not empty errorModel}">
										<div class="alert alert-danger" role="alert">${errorModel}</div>
									</c:if>
									<input type="text" class="form-control" name="model">
								</div>
								<div class="form-group">
									<label class="font-weight-bold">Year:</label>
									<c:if test="${not empty errorYear}">
										<div class="alert alert-danger" role="alert">${errorYear}</div>
									</c:if>
									<input type="number" class="form-control" name="year">
								</div>

								<div class="form-group">
									<label class="font-weight-bold">Description:</label>
									<c:if test="${not empty errorDescription}">
										<div class="alert alert-danger" role="alert">${errorDescription}</div>
									</c:if>
									<textarea type="textfield" class="form-control" name="description"></textarea>
								</div>
								<div class="form-group">
									<label class="font-weight-bold">Expiring At:</label>
									<c:if test="${not empty errorExpireDate}">
										<div class="alert alert-danger" role="alert">${errorExpireDate}</div>
									</c:if>
									<input type="date" class="form-control" name="expire_date">
								</div>
								<button type="submit" class="btn btn-outline purpleBtn">Add Car</button>
								<a href="show-cars" class="btn btn-outline purpleBtn">Show all the cars</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>