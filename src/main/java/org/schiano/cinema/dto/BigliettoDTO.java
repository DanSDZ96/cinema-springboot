package org.schiano.cinema.dto;

import lombok.Data;

@Data
public class BigliettoDTO {

    private Long id;
    private Double prezzo;

    // Info sullo spettacolo (solo id)
    private Long spettacoloId;
}
