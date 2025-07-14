package org.schiano.cinema.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FilmDettaglioDTO {		//questo lo si usa quando si seleziona un singolo film, si mostrano ATTORI e SPETTACOLI


    private Long id;

    @NotBlank(message="Nome obbligatorio")
	private String titolo;
    @NotNull(message = "Prezzo obbligatorio")
    private Integer durata;
    
    @NotBlank(message="Nome obbligatorio")
	private String genere;

    // Lista di Nome Cognome degli attori
    private List<String> attori;

    // Lista di id degli spettacoli associati al film
    private List<Long> spettacoloIds;
}
