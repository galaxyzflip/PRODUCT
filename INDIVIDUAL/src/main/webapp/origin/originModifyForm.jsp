<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="origin.*" %>
<%
	request.setCharacterEncoding("utf-8");
	String code = (String)request.getParameter("originCode");
	OriginDAO manager = OriginDAO.getInstance();
	OriginBean bean = manager.getOrigin(code);

%>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<table border="1">
<form action="originModifyPro.jsp?originCode=<%=code%>" method="post">
	<tr>
		<td>코드</td>
		<td><%=bean.getOriginCode() %></td>
	</tr>
	
	<tr>
		<td>나라명</td>
		<td><input type="text" name="originNation" value="<%=bean.getOriginNation() %>"></td>
	</tr>
	
	<tr>
		<td>등록일</td>
		<td><%=bean.getOriginRegdate() %></td>
	</tr>

	<tr>
		<td align="center"><input type="submit" value="수정" ></td>
		<td align="center"><input type="button" value="삭제" onclick="location.href='proClassDeletePro.jsp?classCode=<%=code%>'"></td>
	</tr>

</form>

</table>




</body>
</html>