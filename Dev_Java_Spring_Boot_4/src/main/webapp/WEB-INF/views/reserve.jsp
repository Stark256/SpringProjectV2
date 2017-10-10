<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
  integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
  crossorigin="anonymous">
<title>Reserve</title>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="col-6 mr-auto ml-auto">
        <form:form action="/profile/cafe/addtable/${cafeId}/reserve/${_table.id}" method="POST" modelAttribute="_table">
          <c:if test="${emptyName}">
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
            <label class="col-2 col-form-label" for="user">Name :</label>
            <div class="col-10">
              <form:input class="form-control" id="user" path="user" />
            </div>
          </div>
          <!--  <c:if test="${emptyPhone}">
				<div class="row">
					<div class="col-10 ml-auto">
							<span class="text-danger">Це поле має бути заповненим</span>
					</div>
				</div>
			</c:if>
          <div class="form-group row">
            <label class="col-2 col-form-label" for="userPhone">Phone :</label>
            <div class="col-10">
              <form:input class="form-control" id="userPhone" path="userPhone" />
            </div>
          </div>-->
          <div class="form-group row">
			<label class="col-2 col-form-label" for="timeReserv">Time :</label>
			<div class="col-10">
				<form:select class="form-control"  items="${times}" path="timeReserv" />
			</div>
		</div>
          <div class="form-group row">
            <div class="col-10 ml-auto">
              <button class="btn btn-sm btn-outline-success">Save</button>
              <a href="/profile/cafe/addtable/${cafeId}"
                class="btn btn-sm btn-outline-warning">Cancel</a>
            </div>
          </div>
        </form:form>
      </div>
    </div>
  </div>
</body>
</html>