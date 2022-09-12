<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="origin.*" %>

<% 
	request.setCharacterEncoding("utf-8");
	OriginDAO manager = OriginDAO.getInstance();
	OriginBean[] bean = manager.getOriginList();
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>원산지 목록</title>
</head>
<body>
<table border="1">

	<tr>
		<th>코드</th>
		<th>원산지 명</th>
	</tr>
	

<%
	
	for(int i=0;i<bean.length;i++){
%>	
		<tr>
			<td><%=bean[i].getOriginCode() %>	</td>
			<td><a href="originModifyForm.jsp?originCode=<%=bean[i].getOriginCode()%>">
   			<%= bean[i].getOriginNation() %></a></td>
		</tr>	

<% 
	}
		%>

</table>

<input type=button value="메인" onclick="location.href='originMain.jsp'" />
<input type=button value="등록" onclick="location.href='originInputForm.jsp'" />


</body>
</html>