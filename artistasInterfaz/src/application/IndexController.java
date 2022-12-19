package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class IndexController {
	
	@FXML
	private TextField txtNombre;
	
	@FXML
	private ChoiceBox cbDiscografica;
	
	@FXML
	private TextField txtNacionalidad;
	
	@FXML
	private TextField txtEdad;
	
	@FXML
	private TableView <Artista> tableArtista;
	
	@FXML
	private TableColumn <Artista, String> columnNombre;
	
	@FXML
	private TableColumn <Artista, String> columnDiscografica;
	
	@FXML
	private TableColumn <Artista, String> columnNacionalidad;
	
	@FXML
	private TableColumn <Artista, Integer> columnEdad;
	
	@FXML
	private Button btnAnadir;
	
	@FXML
	private Button btnBorrar;
	
	private ObservableList<Artista> listaArtista =
		FXCollections.observableArrayList();
	
	public ObservableList<String> listaDiscograficas = 
		FXCollections.observableArrayList(
			"SONY",
			"WARNER",
			"UNIVERSAL",
			"TDE" 
		);
	
	@FXML
	private void initialize() {
		
		cbDiscografica.setItems(listaDiscograficas);
		
		columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		columnDiscografica.setCellValueFactory(new PropertyValueFactory<>("discografica"));
		columnNacionalidad.setCellValueFactory(new PropertyValueFactory<>("nacionalidad"));
		columnEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
		
		ObservableList listaArtistaBD = getArtistaBD();
		
		tableArtista.setItems(listaArtistaBD); 
	}
	
	private ObservableList<Artista> getArtistaBD () {
		
		/*
		 * Creamos la ObservableList donde almacenaremos
		 * los artistas obtenidos de la BD
		 */
		ObservableList<Artista> listaArtistaBD = 
				FXCollections.observableArrayList();
		
		//	Nos conectamos a la BD
		DatabaseConnection dbConnection = new DatabaseConnection();
		Connection connection = dbConnection.getConnection();
		
		String query = "select * from artistas";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Artista artista = new Artista(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("discografica"),
						rs.getString("nacionalidad"),
						rs.getInt("edad") 
				);
				listaArtistaBD.add(artista);
			}
			
			//	Cerramos la conexion
			connection.close();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return listaArtistaBD;
	}
	
	@FXML
	public void anadirArtista(ActionEvent event) {
		
		if (txtNombre.getText().isEmpty() ||
				cbDiscografica.getSelectionModel().isEmpty() ||
				txtNacionalidad.getText().isEmpty() ||
				txtEdad.getText().isEmpty()) {
				
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setTitle("Informacion incompleta");
			alerta.setHeaderText("Falta informacion del artista");
			alerta.setContentText("Por favor, introduce todos los campos");
			alerta.showAndWait();
			
		} else {
			if (esNumero(txtEdad.getText())) {
				Artista artista = new Artista(
						txtNombre.getText(),
						cbDiscografica.getValue().toString(),
						txtNacionalidad.getText(),
						Integer.parseInt(txtEdad.getText())
				);
				
				txtNombre.clear();
				cbDiscografica.getSelectionModel().clearSelection();
				txtNacionalidad.clear();
				txtEdad.clear();
				
				//	Nos conectamos a la BD
				DatabaseConnection dbConnection = new DatabaseConnection();
				Connection connection = dbConnection.getConnection();
				
				try {
					//	Aqui insertaremos en la BD
					String query = "insert into artistas "
							+ "(nombre, edad, discografica, nacionalidad) "
							+ "VALUES (?, ?, ?, ?)";
					PreparedStatement ps = connection.prepareStatement(query);
					ps.setString(1, artista.getNombre()); 
					ps.setInt(2, artista.getEdad());
					ps.setString(3, artista.getDiscografica());
					ps.setString(4, artista.getNacionalidad()); 
					ps.executeUpdate();
					
					//	Cerramos la sesion
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//	Despues de insertar actualizamos la tabla
				ObservableList listaArtistaBD = getArtistaBD();
				tableArtista.setItems(listaArtistaBD); 
				
			} else {
				
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setTitle("Error al insertar");
				alerta.setHeaderText
					("No se ha introducido un numero en la edad");
				alerta.setContentText
					("Por favor, introduzca un numero en la edad");
				alerta.showAndWait();
			}
		}
	}
	
	@FXML
	public void borrarArtista(ActionEvent event) { 
		
		int indiceSeleccionado = tableArtista
									.getSelectionModel()
									.getSelectedIndex();
		
		System.out.println
			("Indice a borrar: " + indiceSeleccionado);
		
		if (indiceSeleccionado <= -1) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Error al borrar");
			alerta.setHeaderText("No se ha seleccionado ningún artista a borrar");
			alerta.setContentText("Por favor, selecciona un artista para borrarlo");
			alerta.showAndWait();
		} else {
			//tableArtista.getItems().remove(indiceSeleccionado);
			//tableArtista.getSelectionModel().clearSelection();
			
			//	Nos conectamos a la BD
			DatabaseConnection dbConnection = new DatabaseConnection();
			Connection connection = dbConnection.getConnection();
			
			try {
				String query = "delete from artistas where id = ?";
				PreparedStatement ps = connection.prepareStatement(query);
				Artista artista = tableArtista.getSelectionModel().getSelectedItem();
				ps.setInt(1, artista.getId());
				ps.executeUpdate();
				
				tableArtista.getSelectionModel().clearSelection();
				
				//	Actualizamos la tabla
				ObservableList listaArtistaBD = getArtistaBD();
				tableArtista.setItems(listaArtistaBD); 
				
				//	Cerramos la sesion
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean esNumero (String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
