package polaczenie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLPolaczenie {
	public static Connection polaczZBaza() throws ClassNotFoundException, SQLException {
		String hostname = "localhost";
		String database = "restauracja";
		String username = "root";
		String rootPassword = "SQLRoot";

		return polaczZBaza(hostname, database, username, rootPassword);
	}

	public static Connection polaczZBaza(String hostname, String database, String username, String rootPassword)
			throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connectionURL = "jdbc:mysql://" + hostname + ":3306/" + database + "?characterEncoding=UTF-8";
			conn = DriverManager.getConnection(connectionURL, username, rootPassword);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void zamknijPolaczenie(Connection conn) {
		try {
			conn.close();
			System.out.println("po³¹czenie zamkniête");
		} catch (Exception e) {
		}
	}

	public static void myRollback(Connection conn) {
		try {
			conn.rollback();
		} catch (Exception e) {
		}
	}
}
