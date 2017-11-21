<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>IT QnA</title>
<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/header.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
	
	<div class="jumbotron">
      <div class="container">
        <h1>Hello, world!</h1>
        <p>test project!</p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more »</a></p>
      </div>
    </div>
    
	<div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h2>Heading</h2>
          <p>qna week best </p>
          <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
        </div>
        <div class="col-md-4">
          <h2>Heading</h2>
          <p>tip week best </p>
          <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
       </div>
        <div class="col-md-4">
          <h2>Heading</h2>
          <p>forum week best</p>
          <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
        </div>
      </div>
      <hr>
	  <div class="row">
        <div class="col-md-4">
          <h2>Heading</h2>
          <p>chat best room </p>
          <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
        </div>
        <div class="col-md-4">
          <h2>Heading</h2>
          <p>free best week </p>
          <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
       </div>
        <div class="col-md-4">
          <h2>Heading</h2>
          <p>notice</p>
          <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
        </div>
      </div>
      <footer>
        <p>devsepark@gmail.com</p>
      </footer>
    </div> <!-- /container -->
	
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/bootstrap.js"></script>
</body>
</html>