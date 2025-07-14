package org.schiano.cinema.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class NuovoSpettacoloDTO {

    @NotNull(message = "La data e ora dello spettacolo è obbligatoria")
    private LocalDateTime dataOra;

    @NotNull(message = "Il prezzo è obbligatorio")
    @Positive(message = "Il prezzo deve essere positivo")
    private Double prezzo;

    @NotNull(message = "L'ID del film è obbligatorio")
    private Long filmId;

    @NotNull(message = "L'ID della sala è obbligatorio")
    private Long salaId;
}
