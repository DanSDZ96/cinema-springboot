package org.schiano.cinema.model;

public class Biglietto {
	private Long id;
	private Spettacolo spettacolo;
	private Double prezzo;
	
	
	public Biglietto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
		
	public Biglietto(Long id, Spettacolo spettacolo, Double prezzo) {
		super();
		this.id = id;
		this.spettacolo = spettacolo;
		this.prezzo = prezzo;
	}





	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Spettacolo getSpettacolo() {
		return spettacolo;
	}
	public void setSpettacolo(Spettacolo spettacolo) {
		this.spettacolo = spettacolo;
	}
	public Double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}


	@Override
	public String toString() {
		return "Biglietto [id=" + id + ", spettacolo=" + spettacolo + ", prezzo=" + prezzo + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
