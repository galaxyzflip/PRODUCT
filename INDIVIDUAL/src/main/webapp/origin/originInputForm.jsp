<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>원산지 입력</title>
</head>
<body>

<table border="1" >
	<form action="originInputPro.jsp" method="post">
		<tr>
			<td>원산지코드</td>
			<td><input type="text" name="originCode"></td>
		</tr>
	
		<tr>
			<td>원산지명</td>
			<td><input type="text" name="originNation"></td>
		</tr>

		<tr>
			<td><input type="submit" value="등록"></td>
			<td><input type="reset" value="다시입력"></td>	
		</tr>
	</form>

</table>






</body>
</html>