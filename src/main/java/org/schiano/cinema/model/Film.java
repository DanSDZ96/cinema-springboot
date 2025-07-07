package org.schiano.cinema.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.persistence.JoinColumn;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titolo;
	private Integer durata;
	
	
	@ManyToMany
	@JoinTable(
			name= "film_attore",
			joinColumns = @JoinColumn (name = "film_id"),
			inverseJoinColumns = @JoinColumn (name = "attore_id")
			)
	@JsonIgnore
	@ToString.Exclude
	private List<Attore> attori;
	
	@ManyToOne
	@JoinColumn(name = "genere_id")
	private Genere genere;
	
	@OneToMany(mappedBy = "film")
	 @JsonIgnore
    @ToString.Exclude
	private List<Spettacolo> spettacoli;
	
	
	
	public Film(String titolo, Integer durata, Genere genere) {
		this.titolo = titolo;
		this.durata = durata;
		this.genere = genere;
	}
	

	
	
	
}
