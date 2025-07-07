package org.schiano.cinema.model;

public class Attore {
	
	private Long id;
	private String nome;
	private String cognome;
	
	public Attore() {};
	
	public Attore(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public Attore(Long id, String nome, String cognome) {
		this(nome,cognome);
		this.id = id;
	}

	
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCognome() {
		return cognome;
	}

	
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	
	
	@Override
	public String toString() {
		return "Attore [id=" + id + ", nome=" + nome + ", cognome=" + cognome + "]";
	}


	
}
