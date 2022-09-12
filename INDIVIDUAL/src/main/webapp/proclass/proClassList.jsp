<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="proclass.ProClassDAO" %>
<%@ page import="proclass.ProClassBean" %>

<%
	ProClassDAO manager = ProClassDAO.getInstance();
	ProClassBean[] list = manager.proClassList();
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 분류 리스트</title>
</head>
<body>


<table border="1">

	<tr>
		<th colspan="3">상품 분류 리스트</th><br>
	</tr>
	<tr>
	<th>코드</th><th>이름</th><th>설명</th>
	</tr>
<%
		for(int i=0; i<list.length;i++){
%>	
		<tr>
			<td><%=list[i].getProClassCode() %>	</td>
			<td><a href="proClassModifyForm.jsp?classCode=<%=list[i].getProClassCode()%>">
   			<%= list[i].getProClassName() %></a></td>
			<td><%=list[i].getProClassDescription() %></td>
		</tr>	
			
			
<% 		
		}

	%>
	
	


</table>

</body>
</html>