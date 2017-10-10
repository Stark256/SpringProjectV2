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
		
		<table class="table table-bordered">
						<tr>
							<td><img src="/img/${meal.photoUrl}?version=${meal.version}" width="150" height="100" class="img-fluid"></td>
							<td>${meal.title}</td>
							<td><a href="/cafedesc/${meal.cafe.id}">${meal.cafe.name}</a></td>
							<td>${meal.description}</td>
							<td>${meal.price}</td>
							<td>${meal.cuisine.name}</td>
							<td>${meal.weight}</td>
							<td>
								<c:forEach var="ingredient" items="${meal.ingredients}">
									${ingredient.name} 
								</c:forEach>
							</td>
							</tr>
							</table>
		
	</div>
</body>
</html>