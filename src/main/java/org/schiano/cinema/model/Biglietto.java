package org.schiano.cinema.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Biglietto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double prezzo;

	@ManyToOne
	@JoinColumn(name = "spettacolo_id")
//@JSONIgnore
	private Spettacolo spettacolo;
	
	@ManyToOne
	@JoinColumn(name = "utente_id")
	private Utente utente;
	
}
