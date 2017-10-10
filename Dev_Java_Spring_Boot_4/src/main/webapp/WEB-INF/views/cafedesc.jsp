<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<title>CafeDesc</title>
<style>
.one{
border:2px solid green;
border-radius:18px;
}
.myTable{
 background-color: #f1f1f1;
}
</style>
</head>
<body>
	<div class="container">
			<div class="row">
				<table class="table table-bordered one">
					<tr>
						<td><img src="/img/${cafe.photoUrl}?version=${cafe.version}" width="150" height="100" class="img-fluid"></td>
						<td><a href="/cafedesc/${cafe.id}">${cafe.name}</a></td>
						<td>${cafe.address}</td>
						<td>${cafe.shortDescription}</td>
						<td>${cafe.rate}</td>
						<td>${cafe.type}</td>
						<td>${cafe.open}</td>
						<td>${cafe.close}</td>
					</tr>
				</table>
				
		</div>
		<div class="row">		
			<div class="col-12">
				<a href="/clientRes/addtable/${cafe.id}/client"  class="btn btn-info btn-block mt-3">Reserve Table</a>
			</div>
			</div>
		<div class="row">		
			<div class="col-12">
				<table class="table table-bordered">
						<tr>
							<th class="text-center">Meal photo</th>
							<th class="text-center">Meal title</th>
							<th class="text-center">Meal cuisine</th>
							<th class="text-center">Meal weight</th>
							<th class="text-center">Meal price</th>
							<th class="text-center">Meal description</th>
							<th class="text-center">Meal ingredients</th>
						<tr>
					<c:forEach var="meal" items="${meals}">
						<tr>
							<td><img src="/img/${meal.photoUrl}?version=${meal.version}" width="150" height="100" class="img-fluid"></td>
							<td><a href="/mealdesc/${meal.id}">${meal.title}</a></td>
							<td>${meal.cuisine.name}</td>
							<td>${meal.weight}</td>
							<td>${meal.price}</td>
							<td>${meal.description}</td>
							<td>
								<c:forEach var="ingredient" items="${meal.ingredients}">
									${ingredient.name} 
								</c:forEach>
							</td>
						<tr>
					</c:forEach>
				</table>
			</div>
		</div>
		
		<form:form action="/cafedesc/${cafe.id}" method="POST" modelAttribute="comment">
					<c:if test="${emptyUser}">
						<div class="row">
							<div class="col-10 ml-auto">
								<span class="text-danger">This field must be filled</span>
							</div>
						</div>
					</c:if>
					<div class="row">
						<div class="col-10 ml-auto" style="color:red;">
							<form:errors path="user"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="user">User:</label>
						<div class="col-10">
							<form:input class="form-control" id="user" path="user"/>
						</div>
					</div>
					<div class="row">
						<div class="col-10 ml-auto" style="color:red;">
							<form:errors path="rate"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="rate">Rate:</label>
						<div class="col-10">
							<form:input class="form-control" id="rate" path="rate"/>
						</div>
					</div>
					<c:if test="${emptyComment}">
						<div class="row">
							<div class="col-10 ml-auto">
								<span class="text-danger">This field must be filled</span>
							</div>
						</div>
					</c:if>
					<div class="row">
						<div class="col-10 ml-auto" style="color:red;">
							<form:errors path="comment"/>
						</div>
					</div>
					 <div class="form-group row">
						<label class="col-2 col-form-label" for="comment">Comment:</label>
						<div class="col-10">
							<form:textarea class="form-control" id="comment"
								path="comment" rows="5"></form:textarea>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 mr-left">
							<button class="btn btn-sm btn-outline-success">Save</button>
							<a href="/cafedesc/${cafe.id}/cancel" class="btn btn-sm btn-outline-warning">Cancel</a>
						</div>
					</div>
				</form:form>
		
		
		<!--<div class="row">		
			<div class="col-12">
				<table class="table table-bordered">
						<tr>
							<th>User</th>
							<th>Comment</th>
							<th>Comment to Comment</th>
						<tr>
					<c:forEach var="comment" items="${comments}">
						<tr>
							<td>${comment.user}</td>
							<td>${comment.comment}</td>
							<td><a href="/cafedesc/${id}/tocomment/${comment.id}"  class="btn btn-info ">Comment</a></td>
						<tr>
					</c:forEach>
				</table>
			</div>
		</div>-->
		
		
		<div class="row  mr-auto">		
			<div class="col-12">
				<table class="table table-bordered">
							<tr>
								<th>User</th>
								<th>Comment</th>
								<th>Comment to Comment</th>
							</tr>
				<c:forEach var="comment" items="${comments}">
							
					<c:if test="${comment.parentComment==null}">
								<tr>
									<td>${comment.user}</td>
									<td>${comment.comment}</td>
									<td><a href="/cafedesc/${id}/tocomment/${comment.id}"  class="btn btn-info ">Comment</a></td>
								</tr>
					</c:if>
					<c:if test="${comment.parentComment!=null}">
								<tr class="myTable">
									<td>${comment.user}</td>
									<td>${comment.comment}</td>
								</tr>
							
					</c:if>
				</c:forEach>
				</table>
			</div>
		</div>
		
		
		
		
		
	</div>
</body>
</html>