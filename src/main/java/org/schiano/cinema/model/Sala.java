package org.schiano.cinema.model;

public class Sala {
	private Long id;
	private String nome;
	private int capienza;
	public Sala() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sala(Long id, String nome, int capienza) {
		super();
		this.id = id;
		this.nome = nome;
		this.capienza = capienza;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCapienza() {
		return capienza;
	}
	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}
	@Override
	public String toString() {
		return "Sala [id=" + id + ", nome=" + nome + ", capienza=" + capienza + "]";
	}
	
	
	
	
	

}
