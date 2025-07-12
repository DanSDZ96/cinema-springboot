package org.schiano.cinema.dto;

import java.util.List;

import lombok.Data;

@Data
public class FilmDettaglioDTO {		//questo lo si usa quando si seleziona un singolo film, si mostrano ATTORI e SPETTACOLI


    private Long id;
    private String titolo;
    private Integer durata;
    private String genere;

    // Lista di Nome Cognome degli attori
    private List<String> attori;

    // Lista di id degli spettacoli associati al film
    private List<Long> spettacoloIds;
}
