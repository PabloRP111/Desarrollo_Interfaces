package pojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.Dao;
import util.DatabaseConnection;

public class SerieDAO implements Dao<Serie> {

	private static Connection connection;
	
	@Override
	public ArrayList<Serie> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Serie t) {
		connection = openConnection();
		
		String query ="insert into series (titulo, edad, plataforma) value(?,?,?)";
		
		
		try{
		PreparedStatement ps= connection.prepareStatement(query);		
		
		ps.setString(1, t.getTitulo());
		
		ps.setInt(2, t.getEdad());
		
		ps.setString(3, t.getPlataforma());
		}catch(SQLException e) {
			System.err.println(e);
		}
		
		closeConnection();
	}

	@Override
	public void modificar(Serie t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Serie t) {
		// TODO Auto-generated method stub
		
	}
	private static Connection openConnection() {
		DatabaseConnection dbConnection = new DatabaseConnection();
		connection = dbConnection.getConnection();
		return connection;
	}
	
	private static void closeConnection() {
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
