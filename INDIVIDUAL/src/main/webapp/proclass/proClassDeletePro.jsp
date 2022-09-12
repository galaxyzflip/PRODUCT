<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="proclass.*" %>
<%
	request.setCharacterEncoding("utf-8");
	String code = request.getParameter("classCode");
	ProClassDAO manager = ProClassDAO.getInstance();
	manager.deleteProClass(code);
	response.sendRedirect("proClassList2.jsp");
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