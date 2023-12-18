
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connect {
	
	private final String USERNAME = "root";
	private final String PASSWORD = "";
	private final String DATABASE = "register";
	private final String HOST = "localhost:3306";
	private final String CONNECTION = String.format("jdbc:mysql://%s/%s", HOST, DATABASE);

	
	
	private Connection con;
	private Statement st;
	private static Connect connect;
	
	public static Connect getInstance() {
		if(connect == null) return new Connect();
		return connect;
	}
	
	private Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
			st = con.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
