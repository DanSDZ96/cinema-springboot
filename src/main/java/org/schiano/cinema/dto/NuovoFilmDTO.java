package org.schiano.cinema.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NuovoFilmDTO {
	@NotBlank(message = "Il titolo non può essere vuoto")
	private String titolo;
	
	@NotNull(message="Inserisci una durata")
	private Integer durata;
	
	@NotBlank(message = "Il genere è obbligatorio")
	private String genere;

	
}
