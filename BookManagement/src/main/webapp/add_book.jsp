<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <%@include file="all_css.jsp" %>
</head>
<body class="bg-light">

 <%@include file="navbar.jsp" %>
 
 <div class="container p-4">
 	<div class=row>
 		<div class="col-md-6 offset-md-3">
 			<div class="card">
 				<div class="card-body">
 				
 				<p class "fs-3 text-center"> Add Book</p>
 				<c:if test="${ not empty sucMSG}">
 				<p class="text-center text-success">${sucMSG }</p>
 				<c:remove var="sucMSG"/>
 				</c:if>
 				
 				<c:if test="${ not empty errorMSG}">
 				<p class="text-center text-success">${errorMSG }</p>
 				<c:remove var="errorMSG"/>
 				</c:if>
 				<form action="register" method="post">
 				
   <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Name Of Book</label>
    <input type="text" name="name" class="form-control" >
    </div>
    <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Date of Issueing</label>
    <input type="date" name="doi" class="form-control" >
    </div>
    <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Name Of Author</label>
    <input type="text" name="author" class="form-control" >
    </div>
     <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Price</label>
    <input type="text" name="price" class="form-control" >
    </div>
     
  </div>
  
  <button type="submit" class="btn btn-primary col-md-12">Submit</button>
</form>
 	    		</div>
 	 	   </div>
   		 </div>
 	 </div>
</div>
 
</body>
</html>