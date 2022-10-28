package principal;

import pojo.Serie;
import pojo.SerieDAO;
import pojo.Temporada;
import pojo.TemporadaDao;

public class Main {

	public static void main(String[] args) {
		
		Serie serie = new Serie("Los Simpsons",7,"DisneyPlus");
		SerieDAO serieDao = new SerieDAO(); 
		//serieDao.insertar(serie);
		System.out.println(serieDao.buscarPorId(1));
		
		
		Temporada t1= new Temporada(1,"Primera Temporada",serie);
		TemporadaDao temporadaDao = new TemporadaDao();
		temporadaDao.insertar(t1);
		System.out.println(t1);
		
	}

}
