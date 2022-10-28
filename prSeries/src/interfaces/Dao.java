package interfaces;

import java.util.ArrayList;

public interface Dao<T> {

	public ArrayList <T> buscarTodos();
	
	public void insertar(T t);

	public void modificar(T t);
	
	public void borrar(T t);
	
	
}
