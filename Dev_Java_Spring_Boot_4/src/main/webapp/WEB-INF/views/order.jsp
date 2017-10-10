<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>Order</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6 mr-auto ml-auto">
				<form:form action="/order/someth/${cafeId}/table/${tableId}" method="POST" modelAttribute="order">
					<c:if test="${emptyMeals}">
						<div class="row">
							<div class="col-10 ml-auto">
								<span class="text-danger">This field must be filled</span>
							</div>
						</div>
					</c:if>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="meals">Meals:</label>
						<div class="col-10">
							<form:select path="meals" items="${meals}" class="form-control" multiple="multiple"/>
						</div>
					</div>
					
					<div class="form-group row">
						<div class="col-10 ml-auto">
							<button class="btn btn-sm btn-outline-success">Save</button>
							<a href="/order/someth/${cafeId}/table/${tableId}/cancel" class="btn btn-sm btn-outline-warning">Cancel</a>
						</div>
					</div>
				</form:form>
				
			</div>
		</div>
	</div>
</body>
</html>