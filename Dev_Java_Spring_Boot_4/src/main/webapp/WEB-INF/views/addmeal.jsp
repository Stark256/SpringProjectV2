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
			<div class="col-6 mr-auto ml-auto">
				<form:form action="/addmeal" method="POST" modelAttribute="addmeal" enctype="multipart/form-data">
					<div class="form-group row">
						<label class="col-2 col-form-label" for="cafe">Cafe:</label>
						<div class="col-10">
							<form:select path="cafe" items="${cafes}" class="form-control"/>
						</div>
					</div>
					<c:if test="${emptyTitle}">
						<div class="row">
							<div class="col-10 ml-auto">
								<span class="text-danger">This field must be filled</span>
							</div>
						</div>
					</c:if>
					<div class="row">
						<div class="col-10 ml-auto" style="color:red;">
							<form:errors path="title"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="title">Title:</label>
						<div class="col-10">
							<form:input class="form-control" id="title" path="title"/>
						</div>
					</div>
					<c:if test="${emptyDesc}">
						<div class="row">
							<div class="col-10 ml-auto">
								<span class="text-danger">This field must be filled</span>
							</div>
						</div>
					</c:if>
					<div class="row">
						<div class="col-10 ml-auto" style="color:red;">
							<form:errors path="description"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="description">Description:</label>
						<div class="col-10">
							<form:textarea class="form-control" id="description" path="description" rows="5"/>
						</div>
					</div>
					<c:if test="${emptyPrice}">
						<div class="row">
							<div class="col-10 ml-auto">
								<span class="text-danger">This field must be filled</span>
							</div>
						</div>
					</c:if>
					<div class="row">
						<div class="col-10 ml-auto" style="color:red;">
							<form:errors path="price"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="price">Price:</label>
						<div class="col-10">
							<form:input class="form-control" id="price" path="price"/>
						</div>
					</div>
					<c:if test="${emptyWeight}">
						<div class="row">
							<div class="col-10 ml-auto">
								<span class="text-danger">This field must be filled</span>
							</div>
						</div>
					</c:if>
					<div class="row">
						<div class="col-10 ml-auto" style="color:red;">
							<form:errors path="weight"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="weight">Weight:</label>
						<div class="col-10">
							<form:input class="form-control" id="weight" path="weight"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="cuisine">Cuisine:</label>
						<div class="col-10">
							<form:select path="cuisine" items="${cuisines}" class="form-control"/>
						</div>
					</div>
					<c:if test="${emptyIngredient}">
						<div class="row">
							<div class="col-10 ml-auto">
								<span class="text-danger">This field must be filled</span>
							</div>
						</div>
					</c:if>
					<div class="row">
						<div class="col-10 ml-auto" style="color:red;">
							<form:errors path="ingredients"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="ingredients">Ingredients:</label>
						<div class="col-10">
							<form:select path="ingredients" items="${ingredients}" class="form-control" multiple="multiple"/>
						</div>
					</div>
					<c:if test="${emptyPhoto}">
						<div class="row">
							<div class="col-10 ml-auto">
								<span class="text-danger">Choose something</span>
							</div>
						</div>
					</c:if>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="photo">Photo:</label>
						<div class="col-10">
							<input name="photo" type="file" id="photo">
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 mr-left">
							<button class="btn btn-sm btn-outline-success">Save</button>
							<a href="/addmeal/cancel" class="btn btn-sm btn-outline-warning">Cancel</a>
						</div>
					</div>
					
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>