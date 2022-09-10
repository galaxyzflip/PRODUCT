package origin;
import java.sql.Timestamp;

public class OriginBean {
	
	private String originCode;
	private String originNa;
	private Timestamp originRegdate;
	
	
	public String getOriginCode() {
		return originCode;
	}
	public void setOriginCode(String originCode) {
		this.originCode = originCode;
	}
	public String getOriginNa() {
		return originNa;
	}
	public void setOriginNa(String originNa) {
		this.originNa = originNa;
	}
	public Timestamp getOriginRegdate() {
		return originRegdate;
	}
	public void setOriginRegdate(Timestamp originRegdate) {
		this.originRegdate = originRegdate;
	}
	
	
	
}
