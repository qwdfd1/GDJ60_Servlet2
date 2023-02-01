<%@page import="com.onion.home.product.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Product Detail Page</h1>
	<hr>
	<% 
		ProductDTO productDTO = (ProductDTO)request.getAttribute("product"); 
	%>
	
	<h1><%= productDTO.getProductName() %></h1>
	<hr>
	<h2>상세설명</h2>
	<h3><%= productDTO.getProductDetail() %></h3><br>
	<hr>
	<h4>평점 : <%= productDTO.getProductJumsu() %></h4>
		
	
</body>
</html>