<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품분류 등록 폼</title>
</head>
<body>


<table border="1">
<form action="proClassRegPro.jsp" method="post">
	<tr>
		<td>분류코드</td>
		<td><input type="text" name="proClassCode"></td>
		
	</tr>
	<tr>
		<td>분류명</td>
		<td><input type="text" name="proClassName"></td>
	</tr>
	
	<tr>
		<td>분류설명</td>
		<td><input type="text" name="proClassDescription"></td>
	</tr>
	
	<tr>
		<td align="center"><input type="submit" value="등록" ></td>
		<td><input type="reset" value="다시작성"></td>
	</tr>
</form>

</table>







</body>
</html>