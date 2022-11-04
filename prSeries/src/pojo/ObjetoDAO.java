package pojo;

import java.sql.Connection;
import java.sql.SQLException;

import util.DatabaseConnection;

public class ObjetoDAO {
	private static Connection connection;

	protected static Connection openConnection() {
		DatabaseConnection dbConnection = new DatabaseConnection();
		connection = dbConnection.getConnection();
		return connection;
	}
	
	protected static void closeConnection() {
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
