package origin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class OriginDAO {

	
	private OriginDAO() {
		
	}
	
	private static OriginDAO instance = new OriginDAO();
	
	public static OriginDAO getInstance() {
		return instance;
	}
	
	private Connection getConnection() throws SQLException {
		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}
}
