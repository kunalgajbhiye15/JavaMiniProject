<%@page import="com.entity.Book"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
 				
 				<p class "fs-3 text-center"> Edit Details of Book</p>
 				
 				<%
 				int id=Integer.parseInt(request.getParameter("id"));
 				BookDAO dao =new BookDAO(DBConnect.getConn());
 				Book s=dao.getBookById(id);
 				%>
 				
 				<form action="update" method="post">
   <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Name Of Book</label>
    <input type="text" value="<%=s.getBookName()%>" name="name" class="form-control" >
    </div>
    <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Date of Issueing</label>
    <input type="date" value="<%=s.getDoi() %>" name="doi" class="form-control" >
    </div>
    <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Name Of Author</label>
    <input type="text" value="<%=s.getAuthorName() %>" name="author" class="form-control" >
    </div>
     <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Price</label>
    <input type="text" value="<%=s.getPrice() %>" name="price" class="form-control" >
    </div>
     
  </div>
  
  <input type="hidden" name="id" value="<%=s.getId()%>">
  
  <button type="submit" class="btn btn-primary col-md-12">Update</button>
</form>
 	    		</div>
 	 	   </div>
   		 </div>
 	 </div>
</div>
</body>
</html>