<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Car</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed"
	rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div class="col-md-6 mt-5">
			<div class="card">
				<div class="card-body p-5">
					<h3 class="pb-3 ">Edit this car</h3>
					<form action="add-car" method="post">
						<input type="hidden" name="id" value="${car.id}" />
						<div class="form-group">
							<label class="font-weight-bold">Manufacturer:<br></label> <input
								class="form-control" name="manufacturer"
								value="${car.manufacturer}">
						</div>
						<div class="form-group">
							<label class="font-weight-bold">Model:<br></label> <input
								type="text" class="form-control" name="model"
								value="${car.model}">
						</div>
						<div class="form-group">
							<label class="font-weight-bold">Year:</label> <input
								type="number" class="form-control" name="year"
								value="${car.modelYear}">
						</div>

						<div class="form-group">
							<label class="font-weight-bold">Description:</label>
							<textarea type="textfield" class="form-control"
								name="description">${car.description}</textarea>
						</div>
						<div class="form-group">
							<label class="font-weight-bold">Expiring At:</label> <input
								type="date" class="form-control" name="expire_date"
								value="${car.expireDate}">
						</div>
						<button type="submit" class="btn btn-primary purpleBtn">Update</button>
						<a href="show-cars" class="btn btn-primary purpleBtn">Show all
							the cars</a>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>