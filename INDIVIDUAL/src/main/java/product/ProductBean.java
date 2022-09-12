//작성자 : 최창선
//작성일 : 2022-09-12
//목적 : 상품정보 Bean 파일


package product;
import java.sql.Timestamp;

public class ProductBean {

	private String productCode;
	private String productName;
	private String classCode;
	private String originCode;
	private String price;
	private Timestamp regDate;
	private String regMember;
	
	
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
	public String getClassCode() {
		return classCode;
	}
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
	public String getOriginCode() {
		return originCode;
	}
	public void setOriginCode(String originCode) {
		this.originCode = originCode;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
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
	
	
	
}
