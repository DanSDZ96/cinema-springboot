package org.schiano.cinema.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NuovoAttoreDTO {
	
	@NotBlank(message="Nome obbligatorio")
	public String nome;
	
	@NotBlank(message="Cognome obbligatorio")
	public String cognome;

}
