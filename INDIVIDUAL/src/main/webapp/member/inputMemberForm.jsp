<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>회원가입</h2>

<table border="1">
	<tr>
		<td colspan="2"> 사용자 정보를 입력해주세요 </td>
	</tr>
	
	<form action = "inputMemberPro.jsp" method="post">
	<tr>
		<td> 아이디 </td>
		<td><input type="text" name="memberId"> </td> 
	</tr>
		
	<tr>
		<td> 비밀번호 </td>
		<td><input type="password" name="memberPasswd"></td>
	</tr>
		
	<tr>
		<td> 비번확인 </td>
		<td><input type="password" name="memberPasswd2"></td>
	</tr>

	<tr>
		<td> 이름 </td>
		<td><input type="text" name="memberName"></td>
	</tr>
	<tr>
		<td><input type="submit" value="가입"></td>
		<td><input type="reset" value="초기화"></td>
	</form>

</table>




</body>
</html>