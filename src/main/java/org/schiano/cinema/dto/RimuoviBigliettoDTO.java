package org.schiano.cinema.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RimuoviBigliettoDTO {

    @NotNull(message = "L'id del biglietto è obbligatorio per la rimozione")
    private Long id;
}
