<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="origin.*" %>
<%@ page import="java.sql.Timestamp" %>
<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="member" class="origin.OriginBean">
	<jsp:setProperty name="member" property="*"/>
</jsp:useBean>

<%
	OriginDAO manager = OriginDAO.getInstance();
	member.setOriginRegdate(new Timestamp(System.currentTimeMillis())); 
	manager.inputOrigin(member);
	
	response.sendRedirect("originList.jsp");
%>
