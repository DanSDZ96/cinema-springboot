package org.schiano.cinema.model;

public class Film {
	
	private Long id;
	private String titolo;
	private Integer durata;
	private String genere;
	
	public Film() {};
	
	public Film(String titolo, String genere, Integer durata) {
		this.titolo = titolo;
		this.genere = genere;
		this.durata = durata;
	}
	
	public Film(Long id, String titolo, String genere, Integer durata) {
		this(titolo,genere,durata);
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getTitolo() {
		return titolo;
	}

	public Integer getDurata() {
		return durata;
	}

	public String getGenere() {
		return genere;
	}

	
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public void setDurata(Integer durata) {
		this.durata = durata;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", titolo=" + titolo + ", durata=" + durata + ", genere=" + genere + "]";
	}
	
	
	
	
	

}
