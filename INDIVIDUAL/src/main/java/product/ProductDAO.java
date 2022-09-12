//작성자 : 최창선
//작성일 : 2022-09-12
//목적 : 상품정보 DAO 서블렛


package product;
import java.sql.*;

public class ProductDAO {

	private ProductDAO () {
		
	}
	
	private static ProductDAO instance = new ProductDAO();
	
	public static ProductDAO getInstance() {
		return instance;
	}
	
	
	private Connection getConnection() throws SQLException {
		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	
	
	public void inputProduct(ProductBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into product_info values"
					+ "(product_seq.nextval,?,?,?,?,?,?,?)");
			pstmt.setString(1, bean.getProductName());
			pstmt.setString(2, bean.getProductClass());
			pstmt.setString(3, bean.getProductOrigin());
			pstmt.setString(4, bean.getProductPrice());
			pstmt.setTimestamp(5, bean.getRegDate());
			pstmt.setString(6, bean.getRegMember());
			pstmt.setInt(7, bean.getProductStock());
			pstmt.executeUpdate();
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}finally {
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn != null) try {pstmt.close();} catch(SQLException ex) {}
		}
		
	}
	
	
	public int checkProduct(String code, String name) {
		int x= -1;
		return x;
	}
	
	//modifyPro 에서 처리
	public void modifyProduct(ProductBean bean) {
		
	}
	
	public void deleteProduct(String code) {
		
	}
	
	public ProductBean getProduct(String code) {
		ProductBean bean = new ProductBean();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from product_info where product_code = ?");
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bean.setProductCode(rs.getString("product_code"));
				bean.setProductName(rs.getString("product_name"));
				bean.setProductClass(rs.getString("class_code"));
				bean.setProductOrigin(rs.getString("origin_code"));
				bean.setRegDate(rs.getTimestamp("reg_date"));
				bean.setRegMember(rs.getString("reg_member"));
				bean.setProductStock(rs.getInt("stock"));
				
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
	
	public ProductBean[] getProductList() {
		ProductBean[] productList = null;
		Connection conn = null;
		PreparedStatement pstmtCount = null;
		
		PreparedStatement pstmtSelect = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		int row = 0;
		
		try {
			conn = getConnection();
			pstmtCount = conn.prepareStatement("select count(1) from product_info");
			rs = pstmtCount.executeQuery();
			if(rs.next()) {
				row = rs.getInt("count(1)");
			}
			
			productList = new ProductBean[row];
			
			pstmtSelect = conn.prepareStatement("select * from product_info");
			rs2 = pstmtSelect.executeQuery();
			int i=0;
			
			while(rs2.next()) {
				productList[i] = new ProductBean();
				productList[i].setProductName(rs.getString("product_name"));
				productList[i].setProductClass(rs.getString("class_code"));
				productList[i].setProductOrigin(rs.getString("origon_code"));
				productList[i].setProductPrice(rs.getString("price"));
				productList[i].setRegMember(rs.getString("reg_member"));
				productList[i].setRegDate(rs.getTimestamp("reg_date"));
				productList[i].setProductStock(rs.getInt("stock"));
				
				i++;
			}
			
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}finally {
			if(rs != null) try {rs.close();} catch(SQLException ex) {}
			if(rs2 != null) try {rs2.close();} catch(SQLException ex) {}
			if(pstmtCount != null) try {pstmtCount.close();} catch(SQLException ex) {}
			if(pstmtSelect != null) try {pstmtSelect.close();} catch(SQLException ex) {}
			if(conn != null) try {conn.close();} catch(SQLException ex) {}
		}
		
		
		return productList;
	}
	
	
	
	//inputProduct
	//modifyProduct
	//deleteProduct
	//getProduct
	//productList
	//checkProduct
	
	
	
	
	
}
