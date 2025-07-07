package org.schiano.cinema.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cognome;
	
	@ManyToMany(mappedBy = "attori")
	@JsonIgnore
	@ToString.Exclude
	private List<Film> film;
	
	
	public Attore(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}
	

	
}
