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
<title>Time</title>
</head>
<body>
	<div class="container">
		<div class="row">
		<div class="col-3">
				<form:form action="/admin/time/cancel" method="GET" modelAttribute="filter">
					<div class="form-group row">
						<div class="col-12">
							<form:input class="form-control" path="search" placeholder="Search"/>
						</div>
					</div>
				</form:form>
			</div>
			<div class="col-9">
				<form:form action="/admin/time" method="POST" modelAttribute="time">
					<c:if test="${isErrors}">
					<div class="alert alert-danger" role="alert">
						<form:errors path="time" cssClass="text-danger mr-3"/>
					</div>
				</c:if>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="time">Time:</label>
						<div class="col-5">
							<form:input class="form-control" id="time" path="time"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 mr-left">
							<button class="btn btn-sm btn-outline-success">Save</button>
							<a href="/admin/time/cancel" class="btn btn-sm btn-outline-warning">Cancel</a>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
		
			<div class="col-9">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Time</th>
						<th class="text-center">Options</th>
					</tr>
					<c:forEach var="time" items="${times.content}">
						<tr>
							<td>${time.time}</td>
							<td class="text-center">
								<a href="/admin/time/update/${time.id}" class="btn btn-outline-warning btn-sm">Update</a>
								<!-- <a href="/admin/time/delete/${time.id}" class="btn btn-outline-danger btn-sm">Delete</a> -->
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="col-3">
			<div class="row">
				<div class="col text-right pr-0">
					<button class="dropdown-toggle btn btn-outline-secondary btn-sm" type="button" data-toggle="dropdown">Sort</button>
					<div class="dropdown-menu">
						<custom:sort innerHtml="Time asc" paramValue="time"/>
						<custom:sort innerHtml="Time desc" paramValue="time,desc"/>
					</div>
				</div>
				<div class="col text-right pl-0">
					<custom:size posibleSizes="1,2,5,10" size="${times.size}"/>
				</div>
			</div>
		</div>
		</div>
		<div class="row mt-3">
			<div class="col-12 text-center">
				<custom:pageable page="${times}"/>
			</div>
		</div>
	</div>
</body>
</html>