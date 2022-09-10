/* 작성자 : 최창선
 * 목적 : 상품분류 Bean
 * 작성일 : 2022-09-11
*/

package proclass;
import java.sql.Timestamp;

public class ProClassBean {
	
	private String proClassCode;
	private String proClassName;
	private Timestamp proClassRegdate;
	private String proClassDescription;
	
	
	public String getProClassCode() {
		return proClassCode;
	}
	public void setProClassCode(String proClassCode) {
		this.proClassCode = proClassCode;
	}
	public String getProClassName() {
		return proClassName;
	}
	public void setProClassName(String proClassName) {
		this.proClassName = proClassName;
	}
	public Timestamp getProClassRegdate() {
		return proClassRegdate;
	}
	public void setProClassRegdate(Timestamp proClassRegdate) {
		this.proClassRegdate = proClassRegdate;
	}
	public String getProClassDescription() {
		return proClassDescription;
	}
	public void setProClassDescription(String proClassDescription) {
		this.proClassDescription = proClassDescription;
	}
	

	
}
