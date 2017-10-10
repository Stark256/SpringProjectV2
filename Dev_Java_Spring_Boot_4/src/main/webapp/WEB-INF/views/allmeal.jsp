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
		<div class="col pt-3">
				<form:form action="/all/allmeal" method="GET" modelAttribute="mealFilter">
					<span class="text-secondary">PRICE</span>
					<div class="form-group row">
						<div class="col pr-1">
							<form:input path="minPrice" class="form-control form-control-sm" placeholder="Min"/>
						</div>
						<div class="col pl-1">
							<form:input path="maxPrice" class="form-control form-control-sm" placeholder="Max"/>
						</div>
					</div>
					<div class="form-group row">
					<div class="col-6">
						<span class="text-secondary">CUISINE</span>
						<div class="form-group ">
							<form:checkboxes items="${cuisines}" path="cuisinesIds" element="div" itemLabel="name" itemValue="id"/>
						</div>
					</div>
					<div class="col-6">
						<span class="text-secondary">INGRIDIENT</span>
						<div class="form-group ">
								<form:checkboxes items="${ingredients}" path="ingredientsIds" element="div" itemLabel="name" itemValue="id"/>
						</div>
					</div>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-success btn-block mt-3">Search</button>
			    	</div>
				    
				</form:form>
			</div>
			</div>
		<div class="row">
			<div class="col-3">
				<div class="row">
					<div class="col-12 ">
						<form:form action="/all/allmeal" method="GET" modelAttribute="mealFilter">
							<div class="form-group">
								<form:input path="search" class="form-control form-control-sm" placeholder="Search"/>
							</div>
						</form:form>
					</div>
				</div>
				<div class="row">
					<!-- <div class="col-6 ">
						<button class="dropdown-toggle btn btn-outline-secondary btn-sm" type="button" data-toggle="dropdown">Sort</button>
						<div class="dropdown-menu">
							<custom:sort innerHtml="Title asc" paramValue="title"/>
							<custom:sort innerHtml="Title desc" paramValue="title,desc"/>
							<custom:sort innerHtml="Cuisine asc" paramValue="cuisine"/>
							<custom:sort innerHtml="Cuisine desc" paramValue="cuisine,desc"/>
						</div>
					</div> -->
					<div class="col-12 ">
						<custom:size posibleSizes="1,2,5,10" size="${meals.size}"/>
					</div>
				</div>
			</div>
			<div class="col-9">
				<table class="table table-bordered">
					<tr>
						
						<th class="text-center">Photo</th>
						<th class="text-center">Title</th>
						<th class="text-center">Description</th>
						<th class="text-center">Price</th>
						<th class="text-center">Cuisine</th>
						<th class="text-center">Weight</th>
					</tr>
					<c:forEach var="meal" items="${meals.content}">
						<tr>
							<td><img src="/img/${meal.photoUrl}?version=${meal.version}" width="150" height="100" class="img-fluid"></td>
							<td><a href="/mealdesc/${meal.id}">${meal.title}</a></td>
							<td>${meal.description}</td>
							<td>${meal.price}</td>
							<td>${meal.cuisine}</td>
							<td>${meal.weight}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<c:if test="${meals!=null}">
		<div class="row mt-3">
			<div class="col-12 text-center">
				<custom:pageable page="${meals}"/>
			</div>
		</div>
	</c:if>
	</div>
</body>
</html>