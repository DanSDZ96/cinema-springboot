package org.schiano.cinema.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Sala {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (nullable = false, unique = true)
	private String nome;
	
	@Column (nullable = false)
	private int capienza;
	
	
	@OneToMany(mappedBy = "sala")
	@JsonIgnore
	@ToString.Exclude
	private List<Spettacolo> spettacoli;
	
	 public Sala(String nome, int capienza) {
	        this.nome = nome;
	        this.capienza = capienza;
	    }
	}
