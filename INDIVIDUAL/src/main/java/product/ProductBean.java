//작성자 : 최창선
//작성일 : 2022-09-12
//목적 : 상품정보 Bean 파일


package product;
import java.sql.Timestamp;

public class ProductBean {

	private String productCode;
	private String productName;
	private String productClass;
	private String productOrigin;
	private String productPrice;
	private Timestamp regDate;
	private String regMember;
	private int productStock;
	
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductClass() {
		return productClass;
	}
	public void setProductClass(String productClass) {
		this.productClass = productClass;
	}
	public String getProductOrigin() {
		return productOrigin;
	}
	public void setProductOrigin(String productOrigin) {
		this.productOrigin = productOrigin;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public String getRegMember() {
		return regMember;
	}
	public void setRegMember(String regMember) {
		this.regMember = regMember;
	}
	public int getProductStock() {
		return productStock;
	}
	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}
	
	
}
