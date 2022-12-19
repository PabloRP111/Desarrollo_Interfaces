package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Artista {
	private int id;
	private SimpleStringProperty nombre;
	private SimpleStringProperty discografica;
	private SimpleStringProperty nacionalidad;
	private SimpleIntegerProperty edad;
	
	public Artista(int id, String nombre, String discografica,
			String nacionalidad, int edad) {
		super();
		this.id =  id;
		this.nombre =  new SimpleStringProperty(nombre);
		this.discografica =  new SimpleStringProperty(discografica);
		this.nacionalidad =  new SimpleStringProperty(nacionalidad);
		this.edad = new SimpleIntegerProperty(edad);
	}

	public Artista(String nombre, String discografica, String nacionalidad,
			int edad) {
		super();
		this.nombre =  new SimpleStringProperty(nombre);
		this.discografica =  new SimpleStringProperty(discografica);
		this.nacionalidad =  new SimpleStringProperty(nacionalidad);
		this.edad = new SimpleIntegerProperty(edad);
	}

	public String getNombre() {
		return nombre.get();
	}

	public void setNombre(String nombre) {
		this.nombre = new SimpleStringProperty(nombre);
	}

	public String getDiscografica() {
		return discografica.get();
	}

	public void setDiscografica(String discografica) {
		this.discografica = new SimpleStringProperty(discografica);
	}

	public String getNacionalidad() {
		return nacionalidad.get();
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = new SimpleStringProperty(nacionalidad);
	}

	public int getEdad() {
		return edad.get();
	}

	public void setEdad(int edad) {
		this.edad = new SimpleIntegerProperty(edad);;
	}

	public int getId() {
		return id;
	}
	
	
	
	
	
	
	
	
	
}
