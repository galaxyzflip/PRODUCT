package member;

import java.sql.Timestamp;

public class MemberBean {
	private String memberId;
	private String memberPasswd;
	private String memberName;
	private Timestamp memberRegdate;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPasswd() {
		return memberPasswd;
	}

	public void setMemberPasswd(String memberPasswd) {
		this.memberPasswd = memberPasswd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Timestamp getMemberRegdate() {
		return memberRegdate;
	}

	public void setMemberRegdate(Timestamp memberRegdate) {
		this.memberRegdate = memberRegdate;
	}
}
