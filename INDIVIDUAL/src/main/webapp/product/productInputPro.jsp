<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="product.*" %>
<%@ page import="java.sql.Timestamp" %>
<% request.setCharacterEncoding("utf-8");%>

<jsp:useBean id="member" class="product.ProductBean">
	<jsp:setProperty name="member" property="*"/>
</jsp:useBean>

<%
	member.setRegDate(new Timestamp(System.currentTimeMillis()));
	member.setRegMember((String)session.getAttribute("memberId"));
	ProductDAO manager = ProductDAO.getInstance();
	manager.inputProduct(member);
	
	response.sendRedirect("productList.jsp");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>