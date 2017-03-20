<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<!DOCTYPE html>
<html>
<head>
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<title>Cart</title>
</head>
<body>
<%@ include file="header.jsp" %>

<div> 
<table class="table table-bordered table-condensed"   style="width:70%;">  
<tr><th>Name</th><th>Product Id</th><th>Category Name</th><th>Product Price</th></tr>  
   <c:forEach var="content" items="${cartContent}">   
   <tr>  
   
   <td  width="20%">${content.product.productName}</td>  
   <td>${content.product.productId}</td>
   <td> ${content.product.productCategory.categoryName} </td>
   <td>${content.subTotal}</td>
  
     
   
   </tr>
   </c:forEach>  
   <tr><td colspan="4">Total:  ${grandTotal}</td> </tr>
   </table>  
   
   
   
   
   
   </div>
</body>
</html>