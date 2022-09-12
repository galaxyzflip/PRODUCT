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
			pstmt = conn.prepareStatement("insert into product_info values(?,?,?,?,?,?,?,)");
			pstmt.setString(1, "product_code");
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}finally {
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn != null) try {pstmt.close();} catch(SQLException ex) {}
		}
		
	}
	
	public void modifyProduct(ProductBean bean) {
		
	}
	
	public void deleteProduct(String code) {
		
	}
	
	public ProductBean getProduct(String code) {
		ProductBean bean = null;
		return bean;
	}
	
	public ProductBean[] productList() {
		ProductBean[] list = null;
		return list;
	}
	
	public int checkProduct(String code, String name) {
		int x= -1;
		return x;
	}
	
	//inputProduct
	//modifyProduct
	//deleteProduct
	//getProduct
	//productList
	//checkProduct
	
	
	
	
	
}
