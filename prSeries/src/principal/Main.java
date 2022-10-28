package principal;

import pojo.Serie;
import pojo.SerieDAO;

public class Main {

	public static void main(String[] args) {
		
		Serie serie = new Serie("Los Simpsons",7,"DisneyPlus");
		SerieDAO serieDao = new SerieDAO(); 
		serieDao.insertar(serie);
		
	}

}
