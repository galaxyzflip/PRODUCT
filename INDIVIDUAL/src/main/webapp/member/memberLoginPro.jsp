<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.MemberDAO" %>
<% request.setCharacterEncoding("utf-8"); %>



<%
	String id = request.getParameter("memberId");
	String passwd = request.getParameter("memberPasswd");
	MemberDAO manager = MemberDAO.getInstance();
	int check = manager.loginCheck(id, passwd);
	
	

	if(check == 1){
		session.setAttribute("memberID", id);
		response.sendRedirect("memberMain.jsp");
		
		
	 
	}else if(check == -1){
	
%>
	<script>
		alert("비밀번호가 맞지 않습니다."):
			history.go(-1));
	</script>

<% 		
	} else{
%>
	<script>
		alert("아이디가 존재하지 않습니다.");
			history.go(-1));
	</script>

<%
	}
		
		 %>



</body>
</html>