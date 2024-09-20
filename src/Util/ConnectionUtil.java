package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private String url = "jdbc:sqlserver://localhost:1433;databaseName=firstEverProject;encrypt=false";
	private String username = "sa";
	private String password = "P@ssw0rd";

	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;

	}
}
