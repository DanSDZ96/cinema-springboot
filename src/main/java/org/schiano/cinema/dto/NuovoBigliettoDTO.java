package org.schiano.cinema.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NuovoBigliettoDTO {

    @NotNull(message = "Prezzo obbligatorio")
    private Double prezzo;

    @NotNull(message = "ID dello spettacolo obbligatorio")
    private Long spettacoloId;
}
