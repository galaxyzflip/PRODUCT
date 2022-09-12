<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="proclass.*" %>

<%
	request.setCharacterEncoding("utf-8");
	String classCode = (String)request.getParameter("classCode");
	ProClassDAO manager = ProClassDAO.getInstance();
	ProClassBean bean = manager.getProClass(classCode);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품분류 수정 폼</title>
</head>
<body>


<table border="1">
<form action="proClassModifyPro.jsp?classCode=<%=classCode %>" method="post">
	<tr>
		<td>분류코드</td>
		<td><%=bean.getProClassCode() %></td>
		
	</tr>
	<tr>
		<td>분류명</td>
		<td><input type="text" name="proClassName" value="<%=bean.getProClassName()%>"></td>
	</tr>
	
	<tr>
		<td>분류설명</td>
		<td><input type="text" name="proClassDescription" value="<%=bean.getProClassDescription()%>"></td>
	</tr>
	
	<tr>
		<td align="center"><input type="submit" value="수정" ></td>
		<td align="center"><input type="button" value="삭제" onclick="location.href='proClassDeletePro.jsp?classCode=<%=classCode%>'"></td>
	</tr>
</form>

</table>



</body>
</html>