<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed"
	rel="stylesheet" />
</head>
<body>
	<div class="container mt-5">
		<h1 class="text-center text-md-left text-light display-4">${message}</h1>
		<c:if test="${title == 'Success'}">
			<p class="text-light">You can now use this website</p>
			<p>
				<a href="add-car" class="btn btn-outline customBtn">Add a car</a> <a
					href="show-cars" class="btn btn-outline customBtn">Display all
					cars</a>
		</c:if>

		</p>
	</div>

</body>
</html>