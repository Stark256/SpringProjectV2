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
</style>
</head>
<body>
	<div class="container">
		<!-- <div class="row">		
			<div class="col-12">
				<table class="table table-bordered">
						<tr>
							<th>User</th>
							<th>Comment</th>
						<tr>
						<tr>
							<td>${comment.user}</td>
							<td>${comment.comment}</td>
						<tr>
				</table>
			</div>
		</div> -->
		<form:form action="/cafedesc/${cafe.id}/tocomment/${commentId}" method="POST" modelAttribute="comment">
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
					
					 <!-- <div class="form-group row">
						<label class="col-2 col-form-label" for="rate">Rate:</label>
						<div class="col-10">
							<form:input class="form-control" id="rate" path="rate"/>
						</div>
					</div>  -->
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
	</div>
</body>
</html>