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
<title>Add table</title>
</head>
<body>
  <div class="container">
  	<div class="row">
      <div class="col-12">
      		<a href="/profile/cafe/addtable/${cafeId}"  class="btn btn-success btn-block mt-3">Tables</a>
      </div>
     </div>
 	 <div class="row">
      <div class="col-12">
        <table class="table table-bordered">
          <tr>
         	 <th class="text-center">Number of Chair</th>
            <th class="text-center">Meals</th>
            <th class="text-center">Status</th>
            <th class="text-center">Options</th>
          </tr>
          <c:forEach var="order" items="${orders}">
            <tr>
             <td>№${order.table}</td>
             <td>
             	<c:forEach var="meal" items="${order.meals}">
						${meal} 
				</c:forEach>
              </td>
              <td>${order.status}</td>
               <td class="text-center">
           		 <c:if test="${order.status.equals(accepted)}">
                	 <a  href="/order/${cafeId}/${order.tableId}/completed/${order.id}"  class="btn btn-outline-success btn-sm">Completed</a>
                 </c:if>
                 <c:if test="${order.status.equals(completed)}">
                	 <a href="/order/${cafeId}/${order.tableId}/paid/${order.id}"  class="btn btn-outline-info btn-sm">Paid</a>
                 </c:if>
                 <c:if test="${order.status.equals(paid)}">
                	  <p class="text-danger font-italic">Order is paid!</p>
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