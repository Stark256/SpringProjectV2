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
			<div class="col-6 mr-auto ml-auto">
				<form:form action="/addcafe" method="POST" modelAttribute="addcafe" enctype="multipart/form-data">
					<c:if test="${emptyName}">
						<div class="row">
							<div class="col-10 ml-auto">
								<span class="text-danger">This field must be filled</span>
							</div>
						</div>
					</c:if>
					<div class="row">
						<div class="col-10 ml-auto" style="color:red;">
							<form:errors path="name"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="name">Name:</label>
						<div class="col-10">
							<form:input class="form-control" id="name" path="name"/>
						</div>
					</div>
					<c:if test="${emptyAddress}">
						<div class="row">
							<div class="col-10 ml-auto">
								<span class="text-danger">This field must be filled</span>
							</div>
						</div>
					</c:if>
					<div class="row">
						<div class="col-10 ml-auto" style="color:red;">
							<form:errors path="address"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="address">Address:</label>
						<div class="col-10">
							<form:input class="form-control" id="address" path="address"/>
						</div>
					</div>
					<c:if test="${emptyFD}">
						<div class="row">
							<div class="col-10 ml-auto">
								<span class="text-danger">This field must be filled</span>
							</div>
						</div>
					</c:if>
					<div class="row">
						<div class="col-10 ml-auto" style="color:red;">
							<form:errors path="fullDescription"/>
						</div>
					</div>
					 <div class="form-group row">
						<label class="col-2 col-form-label" for="fullDescription">Full Description:</label>
						<div class="col-10">
							<form:textarea class="form-control" id="fullDescription"
								path="fullDescription" rows="5"></form:textarea>
						</div>
					</div> 
					<c:if test="${emptySD}">
						<div class="row">
							<div class="col-10 ml-auto">
								<span class="text-danger">This field must be filled</span>
							</div>
						</div>
					</c:if>
					<div class="row">
						<div class="col-10 ml-auto" style="color:red;">
							<form:errors path="shortDescription"/>
						</div>
					</div>
					 <div class="form-group row">
						<label class="col-2 col-form-label" for="shortDescription">Short Description:</label>
						<div class="col-10">
							<form:textarea class="form-control" id="shortDescription"
								path="shortDescription" rows="5"></form:textarea>
						</div>
					</div> 
					<div class="form-group row">
						<label class="col-2 col-form-label" for="type">Type:</label>
						<div class="col-10">
							<form:select class="form-control"  items="${types}" path="type" />
						</div>
					</div>
					<c:if test="${emptyPhone}">
						<div class="row">
							<div class="col-10 ml-auto">
								<span class="text-danger">This field must be filled</span>
							</div>
						</div>
					</c:if>
					<div class="row">
						<div class="col-10 ml-auto" style="color:red;">
							<form:errors path="phone"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="phone">Phone:</label>
						<div class="col-10">
							<form:input class="form-control" id="phone" path="phone"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="open">Open:</label>
						<div class="col-10">
							<form:select path="open" items="${times}" class="form-control" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="close">Close:</label>
						<div class="col-10">
							<form:select path="close" items="${times}" class="form-control"/>
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
							<a href="/addcafe/cancel" class="btn btn-sm btn-outline-warning">Cancel</a>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>