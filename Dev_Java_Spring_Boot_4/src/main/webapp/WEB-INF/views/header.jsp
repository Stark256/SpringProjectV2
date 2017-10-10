<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
  uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="custom" uri="/WEB-INF/tags/implicit.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
  integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
  crossorigin="anonymous"></script>
<script
  src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
  integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
  crossorigin="anonymous"></script>
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
  integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
  crossorigin="anonymous">
<script
  src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
  integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
  crossorigin="anonymous"></script>

<link
  href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
  rel="stylesheet"
  integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
  crossorigin="anonymous">
<title>Reserve Service</title>
</head>
<body>
  <header>
    <nav class="navbar navbar-expand-lg navbar-light"
      style="background-color: darkgreen">
      <button class="navbar-toggler" type="button" data-toggle="collapse"
        data-target="#navbarTogglerDemo02"
        aria-controls="navbarTogglerDemo02" aria-expanded="false"
        aria-label="Toggle navigation">
        <i class="fa fa-bars" aria-hidden="true"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
        <div class="navbar-nav">
          <a class="nav-item nav-link text-white" href="/"><i class="fa fa-home" aria-hidden="true"> Main Page</i></a>
          <a class="nav-item nav-link text-white" href="/all/allcafe"><i class="" aria-hidden="true">All Cafe</i> </a>
          <a class="nav-item nav-link text-white" href="/all/allmeal"><i class="" aria-hidden="true">All Meal</i> </a>

          <sec:authorize access="hasRole('ROLE_CAFE')">
            <a class="nav-item nav-link text-white" href="/profile"><i
              class="fa fa-address-card" aria-hidden="true"></i> Profile</a>
          </sec:authorize>
          <sec:authorize access="hasRole('ROLE_ADMIN')">
            <a class="nav-item nav-link text-white" href="/admin"><i
              class="fa fa-address-card" aria-hidden="true"></i>Admin</a>
          </sec:authorize>
        </div>

        <div class="navbar-nav ml-auto">
          <sec:authorize access="isAnonymous()">
            <a class="nav-item nav-link text-white" href="/registration">Registration</a>
            <a class="nav-item nav-link text-white" href="/login"><i
              class="fa fa-sign-in" aria-hidden="true"></i> Login</a>
          </sec:authorize>

          <sec:authorize access="isAuthenticated()">
            <form:form action="/logout">
              <button class="nav-item nav-link btn btn-link text-white fa fa-times">Logout</button>
            </form:form>
          </sec:authorize>
        </div>
      </div>
    </nav>
  </header>