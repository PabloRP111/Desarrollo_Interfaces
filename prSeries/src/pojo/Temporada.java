package pojo;

public class Temporada {

	private int id;
	
	private int num_temporada;
	
	private String titulo;
	
	private Serie serie;
	
	

	public Temporada(int num_temporada, String titulo, Serie serie) {
		super();
		this.num_temporada = num_temporada;
		this.titulo = titulo;
		this.serie = serie;
	}

	public Temporada(int id, int num_temporada, String titulo, Serie serie) {
		super();
		this.id = id;
		this.num_temporada = num_temporada;
		this.titulo = titulo;
		this.serie = serie;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getNum_temporada() {
		return num_temporada;
	}



	public void setNum_temporada(int num_temporada) {
		this.num_temporada = num_temporada;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public Serie getSerie() {
		return serie;
	}



	public void setSerie(Serie serie) {
		this.serie = serie;
	}



	@Override
	public String toString() {
		return "Temporada id=" + id + ", num_temporada=" + num_temporada + ", titulo=" + titulo + ", serie=" + serie.getTitulo();
	}
	
	
	
}
