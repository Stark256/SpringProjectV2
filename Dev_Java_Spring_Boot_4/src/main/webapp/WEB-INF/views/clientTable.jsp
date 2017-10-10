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
<title>Tables</title>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="col-12">
        <table class="table table-bordered">
          <tr>
            <th class="text-center">Number</th>
            <th class="text-center">Count of chairs</th>
            <th class="text-center">Is Free</th>
            <th class="text-center">Cafe</th>
            <th class="text-center">Time</th>
            <th class="text-center">Reservation</th>
          </tr>
          <c:forEach var="table" items="${tables}">
            <tr>
              <td>№${table.number}</td>
              <td>${table.countOfPeople}</td>
              <td>${table.isFree}</td>
              <td>${table.cafe}</td>
              <td>${table.timeReserv}</td>
                <td class="text-center">
           		 <c:if test="${table.isFree.equals(true)}">
                	 <a  href="/clientRes/addtable/${cafeId}/client/${table.id}"  class="btn btn-outline-success btn-sm">Book</a>
                 </c:if>
                <c:if test="${table.isFree.equals(false)}">
                	 <p class="text-danger font-italic">Table is reserved!</p>
                	<!--  <span class="text-danger font-italic"> The table is reserved!</span>  -->
                 </c:if>
                </td>
            </tr>
          </c:forEach>
        </table>
      </div>
    </div>
  </div>
</body>
</html>