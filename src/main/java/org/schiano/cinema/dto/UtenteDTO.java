package org.schiano.cinema.dto;

import java.util.List;

import lombok.Data;

@Data
public class UtenteDTO {

    private Long id;
    private String nome;
    private String cognome;
    private String username;
    private String email;

    //lista di biglietti associati
    private List<BigliettoDTO> biglietti;
}
