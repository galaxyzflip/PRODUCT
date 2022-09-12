<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="proclass.*" %>
<% request.setCharacterEncoding("utf-8");
String classCode = request.getParameter("classCode");
%>

<jsp:useBean id="member" class="proclass.ProClassBean">
	<jsp:setProperty name="member" property="*"/>	
</jsp:useBean>

<%
	
	ProClassDAO manager = ProClassDAO.getInstance();
	member.setProClassCode(classCode);
	manager.modifyProClass(member);
	response.sendRedirect("proClassList.jsp");
%>

