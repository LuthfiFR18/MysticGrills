package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connect {
    
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    private final String DATABASE = "mysticgrills";
    private final String HOST = "localhost:3306";
    private final String CONNECTION = String.format("jdbc:mysql://%s/%s?serverTimezone=UTC", HOST, DATABASE);

    private Connection con;
    private Statement st;
    private static Connect connect;

    public static Connect getInstance() {
        if (connect == null)
            return new Connect();
        return connect;
    }

    private Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
            st = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to connect the database, the system is terminated!");
			System.exit(0);
        }
    }

    public void insertUser(String username, String email, String password, String confirm_password) {
        try {
            String query = String.format("INSERT INTO users (username, email, password, confirm_password) VALUES ('%s', '%s', '%s', '%s')",
                    username, email, password, confirm_password);
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
 

	public boolean validateUser(String email, String password) {
		try {
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                	System.out.println("Query executed");
                    return resultSet.next();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return false;
	}
}
