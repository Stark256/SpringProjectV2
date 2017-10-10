<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<title>User</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<form action="/admin/user" method="POST">
					<div class="form-group row">
						<label class="col-2 col-form-label" for="name">First name:</label>
						<div class="col-4">
							<input class="form-control" id="name" name="firstName">
						</div>
						<label class="col-2 col-form-label" for="name">Last name:</label>
						<div class="col-4">
							<input class="form-control" id="name" name="lastName">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="login">Login:</label>
						<div class="col-4">
							<input class="form-control" id="login" name="login">
						</div>
						<label class="col-2 col-form-label" for="password">Password:</label>
						<div class="col-4">
							<input class="form-control" id="password" name="password">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-1 col-form-label" for="date">Date:</label>
						<div class="col-3">
							<input class="form-control" id="date" name="date">
						</div>
						<label class="col-1 col-form-label" for="month">Month:</label>
						<div class="col-3">
							<input class="form-control" id="month" name="month">
						</div>
						<label class="col-1 col-form-label" for="year">Year:</label>
						<div class="col-3">
							<input class="form-control" id="year" name="year">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="email">Email:</label>
						<div class="col-4">
							<input class="form-control" id="email" name="email">
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 mr-left">
							<button class="btn btn-sm btn-outline-success">Save</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">User name</th>
						<th class="text-center">User data</th>
						<th class="text-center">User data</th>
						<th class="text-center">Options</th>
					</tr>
					<c:forEach var="user" items="${users}">
						<tr>
							<td>${user.firstName} ${user.lastName}</td>
							<td>${user.login} ${user.password}</td>
							<td>${user.birthday} ${user.email}</td>
							<td class="text-center"><a
								href="/admin/user/update/${user.id}"
								class="btn btn-outline-warning btn-sm">Update</a> <a
								href="/admin/user/delete/${user.id}"
								class="btn btn-outline-danger btn-sm">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>