<%@page import="com.entity.Book"%>
<%@page import="com.dao.BookDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.conn.DBConnect"%>
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
  
  <%-- Connection conn = DBConnect.getConn();
     out.print("conn");
  --%>
  
  
 <div class="container p-3">
 <div class="card"> 
 <div class="card-body">
 <p class="text-center fs-1">All Book Details</p>
 <c:if test="${ not empty sucMSG}">
 				<p class="text-center text-success">${sucMSG }</p>
 				<c:remove var="sucMSG"/>
 				</c:if>
 				
 				<c:if test="${ not empty errorMSG}">
 				<p class="text-center text-success">${errorMSG }</p>
 				<c:remove var="errorMSG"/>
 </c:if>
  <table class="table">
   <thead>
    <tr>
     <th scope="col">Name Of Book</th>
      <th scope="col">Date of Issueing</th>
       <th scope="col">Name Of Author</th>
        <th scope="col">Price</th>
        <th scope="col">Action</th>
     </tr> 
    </thead>
     
    <tbody>
    <%
    BookDAO dao= new BookDAO(DBConnect.getConn());
    List<Book> list =dao.getAllBook();
    for(Book s : list)
    {%>
     <tr>
    <th scope="row"><%=s.getBookName() %></th>
    <td><%=s.getDoi() %></td>
    <td><%=s.getAuthorName() %></td>
    <td><%=s.getPrice() %></td> 
    <td>
    <a href="edit_book.jsp?id=<%=s.getId() %>" 
       class="btn btn-sm btn-primary"> Edit </a>
    <a href="delete?id=<%=s.getId() %>" class="btn btn-sm btn-danger"> Delete </a>
    </td>
      
    </tr>
    
    	
    <%}
    %>
    
   
    <!--
     <tr>
    <th scope="row">2</th>
    <td>Mark</td>
    <td>otto</td>
    <td>@mad</td>
    </tr>
    
    <tr>
     <th scope="row">3</th>
    <td>Mark</td>
    <td>otto</td>
    <td>@mad</td>
    </tr>
    -->
    
    </tbody>  
  </table>
  </div>
 </div>
 
 </div>
</body>
</html>