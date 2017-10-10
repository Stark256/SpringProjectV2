<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<title>Admin</title>
</head>
<body>
	<div class="container">
	<div class="row">
		<div class="col-6">
			<a href="/admin/cuisine" class="btn btn-info btn-block mt-3">Cuisine</a>
		  </div>
		 <div class="col-6">
		  	<a href="/admin/ingredient" class="btn btn-info btn-block mt-3">Ingredient</a> 
			 </div>
		  <!-- <div class="col-3">
			<a	href="/admin/time" class="btn btn-info btn-block mt-3">Time</a> 
			</div> -->
	</div>
	</div>
</body>
</html>