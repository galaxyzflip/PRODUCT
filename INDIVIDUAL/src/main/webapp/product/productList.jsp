<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="product.*" %>

<%
	ProductDAO manager = ProductDAO.getInstance();
	ProductBean[] list = manager.getProductList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품목록</title>
</head>
<body>



<table border="1">
	<tr>
		<th>상품명</th>
		<th>분류</th>
		<th>원산지</th>
		<th>가격</th>
		<th>등록자</th>
		<th>등록일</th>
		<th>재고</th>
	</tr>
<%
		for(int i=0;i<list.length;i++){
%>
	<tr>
		<td>
			<a href="productModify.jsp?productCode=<%=list[i].getProductCode()%>"><%=list[i].getProductName() %></a>
		</td>
		<td><%=list[i].getProductClass() %></td>
		<td><%=list[i].getProductOrigin() %></td>
		<td><%=list[i].getProductPrice() %></td>
		<td><%=list[i].getRegDate() %></td>
		<td><%=list[i].getRegMember() %></td>
		<td><%=list[i].getProductStock() %></td>
	</tr>
	
	
	
<%		
		}
%>
	

</table>

</body>
</html>