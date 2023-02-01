<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.onion.home.product.ProductDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Product List Page</h1>
	<%
         List<ProductDTO> productDTOs  = (List<ProductDTO>)request.getAttribute("list");
	
		for(ProductDTO productDTO : productDTOs) {
					
	%>
	<h1><%= productDTO.getProductNum() %></h1>
	<h1><a href="./detail.do?productNum=<%= productDTO.getProductNum() %>"><%= productDTO.getProductName( )%></a></h1>	

	<%} %>
	
	<h1>
	
	</h1>
	


	
	
	
	
	
</body>
</html>