/*
작성자 : 최창선
작성일 : 2022-09-12
목적 : 제품 원산지 관리 DAO
*/


package origin;
import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class OriginDAO {

	
	private OriginDAO() {
		
	}
	
	private static OriginDAO instance = new OriginDAO();
	
	public static OriginDAO getInstance() {
		return instance;
	}
	
	private Connection getConnection() throws SQLException {
		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	
	public Connection getConnection2() throws SQLException {
		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	
	// inputOrigin
	// modifyOrigin
	// deleteOrigon
	// getOrigin
	// originList
	
	public void inputOrigin(OriginBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into product_origin values(?,?,?)");
			pstmt.setString(1, bean.getOriginCode());
			pstmt.setString(2, bean.getOriginNation());
			pstmt.setTimestamp(3, bean.getOriginRegdate());
			pstmt.executeUpdate();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}finally {
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn != null) try {conn.close();} catch(SQLException ex) {}
			
		}
		
		
		
	}
	
	public void modifyOrigin(OriginBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("update product_origin set origin_nation=? where origin_code=?");
			pstmt.setString(1, bean.getOriginNation());
			pstmt.setString(2, bean.getOriginCode());
			pstmt.executeUpdate();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}finally {
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn != null) try {conn.close();} catch(SQLException ex) {}
		}
	}
	
	public void deleteOrigin(String code) {
		
	}
	
	@SuppressWarnings("resource")
	public OriginBean[] getOriginList () {
		
		OriginBean[] list = null;
		Connection conn = null;
		PreparedStatement pstmt  = null;
		ResultSet rs = null;
		int count=0;
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("select count(1) from product_origin");
			rs = pstmt.executeQuery();

			if(rs.next()){
				count = rs.getInt("count(1)");
			}
			
			list = new OriginBean[count];
			
			pstmt = conn.prepareStatement("select * from product_origin order by origin_code asc");
			rs = pstmt.executeQuery();
			
			for(int i=0;i<list.length;i++) {
				if(rs.next()) {
					list[i] = new OriginBean();
					list[i].setOriginCode(rs.getString("origin_code"));
					list[i].setOriginNation(rs.getString("origin_nation"));
					list[i].setOriginRegdate(rs.getTimestamp("reg_date"));
					
				}
			}
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}finally {
			if(rs != null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn != null) try {conn.close();} catch(SQLException ex) {}
		}
		
		return list;
		
	}
	
	public OriginBean getOrigin(String code) {
		OriginBean bean = new OriginBean();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from product_origin where origin_code = ?");
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bean.setOriginCode(rs.getString("origin_code"));
				bean.setOriginNation(rs.getString("origin_nation"));
				bean.setOriginRegdate(rs.getTimestamp("reg_date"));
				
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}finally {
			if(rs != null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn != null) try {conn.close();} catch(SQLException ex) {}
		}
		
		return bean;
	}
	
	
}
