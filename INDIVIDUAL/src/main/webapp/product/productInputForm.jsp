<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="origin.*" %>
<%@ page import="proclass.*" %>

<%
	ProClassDAO classManager = ProClassDAO.getInstance();
	ProClassBean[] classList = classManager.getProClassList();
	
	OriginDAO originManager = OriginDAO.getInstance();
	OriginBean[] originList = originManager.getOriginList();
	
	//임시 세션 저장 이후엔 로그인했을때 생성된 세션으로 할거임...
	String id = "pigcs11";
	session.setAttribute("memberId", id);
	
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="productInputPro.jsp" method="post">
<table border="1">
	
	
		<tr>
			<th colspan="2">제품등록</th>
		</tr>
		
		<tr>
			<td>제품명</td>
			<td><input type="text" name="productName"></td>
		</tr>
	
		<tr>
			<td>분류</td>
			
			<td><select name="productClass">
			
			<% for(int i=0;i<classList.length;i++){%>
				<option value="<%=classList[i].getProClassCode() %>">
					<%=classList[i].getProClassName() %>
				</option>
			<%	}	%>
			
			</select></td>
		</tr>
		
		
		
	
		<tr>
			<td>원산지</td>
			
			<td><select name="productOrigin">
			
			<% for(int i=0;i<originList.length;i++){%>
				<option value="<%=originList[i].getOriginCode() %>">
					<%=originList[i].getOriginNation() %>
				</option>
			<%	}	%>
			
			</select></td>
		</tr>
	
		<tr>
			<td>가격</td>
			<td><input type="text" name="productPrice"></td>
		</tr>
		
		<tr>
			<td>재고</td>
			<td><input type="text" name="productStock"></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="등록"></td>
			<td><input type="reset" value="다시작성"></td>
		</tr>

</table>
</form>


</body>
</html>

