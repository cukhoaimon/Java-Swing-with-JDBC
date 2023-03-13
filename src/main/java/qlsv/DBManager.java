package qlsv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	private static DBManager instance = null;
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	
	public static DBManager getInstance() throws SQLException {
		if (instance == null) {
			instance = new DBManager();
			connection = getConnection();
			
			if (connection != null) {
				statement = connection.createStatement();
				System.out.println("Successful connect to database!");
			}
		}
		
		return instance;
	}
	
	private static Connection getConnection() throws SQLException {
		final String DB_USERNAME = "root";
		final String DB_PASSWORD = "fit@HCMUS123";
		final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
		final String SERVER_NAME = "localhost";
		final String DB_NAME = "QLSV";
		final String URL = "jdbc:mysql://" + SERVER_NAME + "/" + DB_NAME;

		try {
			Class.forName(DRIVER_NAME);
			connection = DriverManager.getConnection(URL, DB_USERNAME, DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public void runAndPrintQuery(String query) {
		try {
			resultSet = statement.executeQuery(query); 
			
			String rs = "";
			while (resultSet.next()) {
				for (int i = 1; i<= 4; i++) {
					rs += resultSet.getString(i) + " ";
				}
								
				System.out.println(rs);
				rs = "";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet runQuery(String query) {
		try {
			resultSet = statement.executeQuery(query); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultSet;
	}
}
