<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="proclass.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>


<%
	ProClassDAO manager = ProClassDAO.getInstance();

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try{
		String query = "select * from product_class";
		conn = manager.getConnection2();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(query);
		
		%>
		
		
<input type=button value="메인" onclick="location.href='proClassMain.jsp'" />
<input type=button value="등록" onclick="location.href='proClassRegForm.jsp'" />

<table border="1" width ="400">
<th colspan="6" align="center">상품 분류 리스트</th>	

<tr>
		<td>코드</td>
		<td>이름</td>
		<td>설명</td>
	<tr>	
		
		<%
		while(rs.next()){
%>			

	<tr>
		<td><%=rs.getString("class_code") %></td>
		<td>
		<a href="proClassModifyForm.jsp?classCode=<%=rs.getString("class_code")%>">
   			<%= rs.getString("class_name") %></a>
		</td>
		<td><%=rs.getString("class_description") %></td>
	<tr>

	
<%		
	} 
}catch(SQLException ex){
	out.println(ex.getMessage());
	ex.printStackTrace();
}finally{
	if(rs != null) try{rs.close();} catch(SQLException es) {};
	if(stmt != null) try{stmt.close();} catch(SQLException ex){};
	if(conn != null) try{conn.close();} catch(SQLException ex){};
}
%>
</table>

</body>
</html>