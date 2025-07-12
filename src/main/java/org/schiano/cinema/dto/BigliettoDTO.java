package org.schiano.cinema.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BigliettoDTO {

    @NotNull(message = "ID obbligatorio per l'aggiornamento")
    private Long id;

    @NotNull(message = "Prezzo obbligatorio")
    private Double prezzo;

    @NotNull(message = "ID dello spettacolo obbligatorio")
    private Long spettacoloId;
}
