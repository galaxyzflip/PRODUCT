<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>
<body>


<%
	if(session.getAttribute("memberID") == null){
	
%>

<table border="1">

<tr>
	<td colspan="2"> <b>관리자 페이지</b> </td>
</tr>

<form action = "memberLoginPro.jsp" method="post" name="member">

<tr>
	<td>아이디</td>
	<td><input type="text" name = "memberId" ></td>
</tr>

<tr>
	<td>비밀번호</td>
	<td><input type="password" name ="memberPasswd"></td>
</tr>
<tr>
	<td><input type="submit" value="로그인"></td>
	<td>
	<input type="button" value="회원가입" onclick="javascript:window.location='inputMemberForm.jsp'">	</td>
</tr>

</form>

<%} else{
%>

	<table border="1">
		<tr>
			<td>상품 관리</td>
		</tr>
		<tr>
			<td>원산지 관리</td>
		</tr>
		<tr>
			<td>상품 분류 관리</td>
		</tr>
		<tr>
			<td><a href="memberLogout.jsp">로그아웃</a></td>
		</tr>
	</table>



<% }%>




</table>

</body>
</html>