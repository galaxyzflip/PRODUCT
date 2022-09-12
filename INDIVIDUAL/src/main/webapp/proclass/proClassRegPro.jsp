<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="proclass.ProClassDAO" %>
<%@ page import="java.sql.Timestamp" %>
<%  request.setCharacterEncoding("utf-8");%>


<jsp:useBean id="classparam" class="proclass.ProClassBean">
	<jsp:setProperty name="classparam" property="*"/>
</jsp:useBean>
    
<% 
	classparam.setProClassRegdate(new Timestamp(System.currentTimeMillis()));
	ProClassDAO manager = ProClassDAO.getInstance();
	manager.inputProClass(classparam);
	
	response.sendRedirect("proClassList2.jsp");

%>
