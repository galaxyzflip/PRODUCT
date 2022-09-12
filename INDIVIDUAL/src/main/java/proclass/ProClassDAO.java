/* 작성자 : 최창선
 * 파일이 하는 역할 : 상품분류 DAO 파일
 * 작성날짜 : 2022-09-11
 * */

package proclass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.Statement;



public class ProClassDAO {

	private ProClassDAO() {
		
	}
	
	private static ProClassDAO instance = new ProClassDAO();
	
	public static ProClassDAO getInstance() {
		return instance;
	}
	
	
	private Connection getConnection() throws SQLException{
		Connection conn = null;
		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		return conn = DriverManager.getConnection(jdbcDriver);
	}
	
	//테스트용
	public Connection getConnection2() throws SQLException{
		Connection conn = null;
		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		return conn = DriverManager.getConnection(jdbcDriver);
	}
	

	
	// 입력 메소드 - 등록 inputProClass
	// 출력 메소드 - 수정할때 getProClass
	// 수정 메소드 - modifyProClass
	// 삭제 메소드 = deleteProClass
	// 리스트 메소드 - proClassList
	
	public void inputProClass(ProClassBean proClass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String proCode = proClass.getProClassCode();
		String proName = proClass.getProClassName();
		String proDes = proClass.getProClassDescription();
		Timestamp reg_date = proClass.getProClassRegdate();
				
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into product_class values(?,?,?,?)");
			pstmt.setString(1, proClass.getProClassCode());
			pstmt.setString(2, proClass.getProClassName());
			pstmt.setTimestamp(3, proClass.getProClassRegdate());
			pstmt.setString(4, proClass.getProClassDescription());
			pstmt.executeQuery();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn != null) try {conn.close();} catch(SQLException ex) {}
			
		}
		
	}

	//수정시 상품분류 정보 표시를 위한 클래스
	//수정은 있는 상품분류 상세에서 진행되기 때문에 결과확인 필요없음
	
	public ProClassBean getProClass(String classCode) {
		ProClassBean para = new ProClassBean();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from product_class where class_code = ?");
			pstmt.setString(1, classCode);
			rs = pstmt.executeQuery();
			if(rs.next()) {

				para.setProClassCode(rs.getString("class_code"));
				para.setProClassName(rs.getString("class_name"));
				para.setProClassRegdate(rs.getTimestamp("reg_date"));
				para.setProClassDescription(rs.getString("class_description"));
					
			}
				
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}finally {
			if(rs != null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn != null) try {conn.close();} catch(SQLException ex) {}
		}
		
		return para;
	}
	
	//상품정보 수정 작업을 위한 클래스
	//update 쿼리
	public void modifyProClass(ProClassBean bean) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("update product_class set class_name = ?, class_description = ? where class_code = ? ");
			pstmt.setString(1, bean.getProClassName());
			pstmt.setString(2, bean.getProClassDescription());
			pstmt.setString(3, bean.getProClassCode());
			pstmt.executeUpdate();
		
		}catch(Exception ex) {
			ex.printStackTrace();
		
		}finally {
			if( pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if( conn != null) try {conn.close();} catch(SQLException ex) {}
		}
		
		
	}
	
	//상품분류를 삭제하는 클래스
	public void deleteProClass(String code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("delete from product_class where class_code=?");
			pstmt.setString(1, code);
			pstmt.executeUpdate();
			
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}finally {
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn != null) try {conn.close();} catch(SQLException ex) {}
		}
		
	}
	
	public ProClassBean[] proClassList() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement row = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ProClassBean[] classList = null;
		int count = 0;
		
		
		try {
			conn = getConnection();
			row = conn.prepareStatement("select count(1) from product_class");
			rs = row.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count(1)");
			}
			
			pstmt = conn.prepareStatement("select * from product_class");
			
			rs2 = pstmt.executeQuery();
			
			
			
			classList = new ProClassBean[count];
			int i = 0;

			while(rs2.next()) {
				classList[i] = new ProClassBean();
				classList[i].setProClassCode(rs2.getString("class_code"));
				classList[i].setProClassName(rs2.getString("class_name"));
				classList[i].setProClassRegdate(rs2.getTimestamp("reg_date"));
				classList[i].setProClassDescription(rs2.getString("class_description"));
				i++;
				
			}
			
			
		}catch(Exception ex) {
			ex.printStackTrace();  
			   
		}finally {
			if(rs != null) try {rs.close();} catch(SQLException ex) {}
			if(rs2 != null) try {rs2.close();} catch(SQLException ex) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(row != null) try {row.close();} catch(SQLException ex) {}
			if(conn != null) try {conn.close();} catch(SQLException ex) {}
			
		}
		return classList ;
		
	}
	
	
}
