<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="origin.*" %>
<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="member" class="origin.OriginBean">
	<jsp:setProperty name="member" property="*"/>
</jsp:useBean>

<%
	OriginDAO manager = OriginDAO.getInstance();
	manager.modifyOrigin(member);
	response.sendRedirect("originList.jsp");
	%>





<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>