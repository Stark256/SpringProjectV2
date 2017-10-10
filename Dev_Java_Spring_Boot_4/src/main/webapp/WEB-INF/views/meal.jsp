<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>Meal</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<a href="/addmeal"  class="btn btn-success btn-block mt-3">Add Meal</a>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Photo</th>
						<th class="text-center">Title</th>
						<th class="text-center">Cafe</th>
						<th class="text-center">Description</th>
						<th class="text-center">Price</th>
						<th class="text-center">Cuisine</th>
						<th class="text-center">Weight</th>
						<th class="text-center">Ingredients</th>
						<th class="text-center">Options</th>
					</tr>
					<c:forEach var="meal" items="${meals}">
						<tr>
							<td><img src="/img/${meal.photoUrl}?version=${meal.version}" width="150" height="100" class="img-fluid"></td>
							<td><a href="/mealdesc/${meal.id}">${meal.title}</a></td>
							<td>${meal.cafe}</td>
							<td>${meal.description}</td>
							<td>${meal.price}</td>
							<td>${meal.cuisine}</td>
							<td>${meal.weight}</td>
							<td>
								<c:forEach var="ingredient" items="${meal.ingredients}">
									${ingredient} 
								</c:forEach>
							</td>
							<td class="text-center">
								<a href="/addmeal/update/${meal.id}" class="btn btn-outline-warning btn-sm">Update</a>
								<!-- <a href="/meal/delete/${meal.id}" class="btn btn-outline-danger btn-sm">Delete</a> -->
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>