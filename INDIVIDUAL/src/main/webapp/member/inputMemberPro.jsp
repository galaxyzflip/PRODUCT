<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.MemberDAO" %>
<%@ page import="java.sql.Timestamp" %>
<%  request.setCharacterEncoding("utf-8");%>


<jsp:useBean id="member" class="member.MemberBean"> 
	<jsp:setProperty name="member" property="*"/>
</jsp:useBean>

	<%
		member.setMemberRegdate(new Timestamp(System.currentTimeMillis()));
		MemberDAO dao = MemberDAO.getInstance();
		dao.inputMember(member);
		
		response.sendRedirect("memberMain.jsp");		
		
	%>
