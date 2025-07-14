package org.schiano.cinema.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SpettacoloDTO {

    private Long id;
    private LocalDateTime dataOra;
    private Double prezzo;

    private Long filmId;
    private String filmTitolo;

    private Long salaId;
    private String salaNome;
}
