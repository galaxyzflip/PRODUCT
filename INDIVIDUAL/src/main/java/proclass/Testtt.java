package proclass;
import proclass.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Testtt {

	public static void main(String[] args) {

		ProClassDAO manager = ProClassDAO.getInstance();
		
		
		
		ProClassBean[] classList = null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count = 0;
		
		String jdbcDriver = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUser = "pigcs";
		String dbPass = "oracle";
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			pstmt = conn.prepareStatement("select count(1) from product_class");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				count = rs.getInt("count(1)");
			}
			
			System.out.println(count);
			
			ProClassBean[] list = new ProClassBean[count];
			
			System.out.println(list.length);
			
			pstmt = conn.prepareStatement("select * from product_class");
			rs = pstmt.executeQuery();
			int i=0;
			while(rs.next()) {
				list[i] = new ProClassBean();
				list[i].setProClassCode(rs.getString("class_code"));
				list[i].setProClassName(rs.getString("class_name"));
				list[i].setProClassRegdate(rs.getTimestamp("reg_date"));
				list[i].setProClassDescription(rs.getString("class_description"));
				i++;
				
			}
			
			
			
			
			/*
			 * ProClassDAO manager = ProClassDAO.getInstance(); ProClassBean[] list =
			 * manager.proClassList(); System.out.println(list.length);
			 */
			
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(rs != null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn != null) try {conn.close();} catch(SQLException ex) {}
		}
		
		
		
		
		
		
	}

}
