package member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;



public class MemberDAO {

		private static MemberDAO instance = new MemberDAO();
		
		public static MemberDAO getInstance() {
			return instance;
		}
		
		private MemberDAO() {
			
		}
		
		//DB 커넥션 및 풀
		private Connection getConnection() throws SQLException {
			Connection conn = null;
			String jdbcDriver="jdbc:apache:commons:dbcp:/pool";
			return conn = DriverManager.getConnection(jdbcDriver);
					
		}
		
	
		
		//회원가입
		public void inputMember(MemberBean member) {
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("insert into member_tbl values(?,?,?,?)");
				pstmt.setString(1, member.getMemberId());
				pstmt.setString(2, member.getMemberPasswd());
				pstmt.setString(3, member.getMemberName());
				pstmt.setTimestamp(4, member.getMemberRegdate());
				pstmt.executeUpdate();
				
				
			}catch(Exception ex) {
				ex.printStackTrace();
			
			}finally {
				if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
				if(conn != null) try {conn.close();} catch(SQLException ex) {}
			}
			
			
			
		}
		
		
		//중복된 아이디인지 검사
		public int confirmId(String id) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int x = -1;
			
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select * from member_tbl where member_id = ?");
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					 x=1;
					
				}else
					x = -1;
				
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				if(rs != null)try {rs.close();} catch(SQLException ex) {}
				if(pstmt != null)try {pstmt.close();} catch(SQLException ex) {}
				if(conn != null)try {conn.close();} catch(SQLException ex) {}
			}
			return x;
	
		}
		
		//정보 수정
		public void modifyMember(MemberBean member) throws Exception {
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("update member_tbl set member_pw = ?, member_name = ? where member_id = ?");
				pstmt.setString(1, member.getMemberPasswd());
				pstmt.setString(2, member.getMemberName());
				pstmt.setString(3, member.getMemberId());
				pstmt.executeUpdate();
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
				if(conn != null) try {conn.close();} catch(SQLException ex) {}
			}
			
		}

		//탈퇴
		@SuppressWarnings("resource")
		public int deleteMember(String id, String passwd) {
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String dbPasswd = "";
			int x = -1;
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select * from member_tbl where member_id = ?");
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				dbPasswd = rs.getString("member_pw");
				if(dbPasswd.equals(passwd)) {
					conn = getConnection();
					pstmt = conn.prepareStatement("delete from member_tbl where member_id=?");
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					x = 1;
				}else {
					x = 0; // 비번이 맞지 않습니다.
				}
			
			} catch(Exception ex) {
				ex.printStackTrace();
				
			} finally {
				if(rs != null) try {rs.close();} catch(SQLException ex) {}
				if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
				if(conn != null) try {conn.close();} catch(SQLException ex) {}
			}
			
			
			
			return x;
		}
		
		//회원정보 객체 리턴해주는건데 수정화면에서 값 뿌려줄때
		public MemberBean getMember(String id) {
			MemberBean member = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select * from member_tbl where member_id = ?");
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPasswd(rs.getString("member_pw"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberRegdate(rs.getTimestamp("member_reg_date"));
			
			
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				if(rs != null) try {rs.close();} catch(SQLException ex) {}
				if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
				if(conn != null) try {conn.close();} catch(SQLException ex) {}
			}
			
			return member;
		}
		
		public int loginCheck(String id, String passwd) {
			int x = -1;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String dbPass = "";
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select member_pw from member_tbl where member_id = ?");
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					dbPass = (String)rs.getString("member_pw");
					if(dbPass.equals(passwd)) {
						x = 1; // 아이디도 있고 패스워드도 맞음 > 로그인
					}else
						x = -1; // 패스워드 틀림
				}else
					x = 0; //아이디 없음
			
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				if(rs != null)try {rs.close();} catch(SQLException ex) {}
				if(pstmt != null)try {pstmt.close();} catch(SQLException ex) {}
				if(conn != null)try {conn.close();} catch(SQLException ex) {}
			}
			
			
			return x;
		}
		
		
}

// 