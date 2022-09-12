package origin;
import java.sql.Timestamp;

public class OriginBean {
	
	private String originCode;
	private String originNation;
	private Timestamp originRegdate;
	
	
	public String getOriginCode() {
		return originCode;
	}
	public void setOriginCode(String originCode) {
		this.originCode = originCode;
	}

	public String getOriginNation() {
		return originNation;
	}
	public void setOriginNation(String originNation) {
		this.originNation = originNation;
	}
	public Timestamp getOriginRegdate() {
		return originRegdate;
	}
	public void setOriginRegdate(Timestamp originRegdate) {
		this.originRegdate = originRegdate;
	}
	
	
	
}
