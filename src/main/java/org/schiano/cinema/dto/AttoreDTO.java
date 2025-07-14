package org.schiano.cinema.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AttoreDTO {
	
	
    private Long id;
	
    @NotBlank(message= "Nome obbligatorio")
	private String nome;
	
	@NotBlank(message= "Cognome obbligatorio")
	private String cognome;
	private List<FilmDTO> films;

}
