package org.schiano.cinema.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SalaDTO {

    @NotNull(message = "ID obbligatorio")
    private Long id;

    @NotBlank(message = "Nome della sala obbligatorio")
    private String nome;

    @NotNull(message = "Capienza obbligatoria")
    private Integer capienza;
}
