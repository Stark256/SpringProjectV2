<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<title>Cafe</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<a href="/addcafe" class="btn btn-success btn-block mt-3">Add Cafe</a>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
					<th class="text-center">Photo</th>
						<th class="text-center">Name</th>
						<th class="text-center">Address</th>
						<th class="text-center">Full description</th>
						<th class="text-center">Short description</th>
						<th class="text-center">Type</th>
						<th class="text-center">Phone</th>
						<th class="text-center">Open</th>
						<th class="text-center">Close</th>
						<th class="text-center">Options</th>
					</tr>
					<c:forEach var="cafe" items="${cafes}">
						<tr>
						<td><img src="/img/${cafe.photoUrl}?version=${cafe.version}" width="150" height="100" class="img-fluid"></td>
							<td><a href="/cafedesc/${cafe.id}">${cafe.name}</a></td>
							<td>${cafe.address}</td>
							<td>${cafe.fullDescription}</td>
							<td>${cafe.shortDescription}</td>
							<td>${cafe.type}</td>
							<td>${cafe.phone}</td>
							<td>${cafe.open}</td>
							<td>${cafe.close}</td>
							
							<td class="text-center">
								<a href="/addcafe/update/${cafe.id}" class="btn btn-outline-warning btn-sm">Update</a> 
								<!-- <a href="/cafe/delete/${cafe.id}" class="btn btn-outline-danger btn-sm">Delete</a> -->
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>