package pojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.Dao;
import util.DatabaseConnection;

public class TemporadaDao implements Dao<Temporada>{

	private static Connection connection;
	
	@Override
	public ArrayList<Temporada> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public TemporadaDao() {
		
	}
	
	@Override
	public void insertar(Temporada t) {
		connection = openConnection();
		
		String query ="insert into temporadas (num_temporada, titulo, serie_id) value(?,?,?)";
		
		try{
		PreparedStatement ps= connection.prepareStatement(query);		
		
		ps.setInt(1, t.getNum_temporada());
		
		ps.setString(2, t.getTitulo());
		
		ps.setInt(3, t.getSerie().getId());
		
		ps.executeUpdate();
		}catch(SQLException e) {
			System.err.println(e);
		}
		
		closeConnection();
		
	}

	@Override
	public void modificar(Temporada t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Temporada t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Serie buscarPorId(int i) {
		// TODO Auto-generated method stub
		
		
		return null;
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
