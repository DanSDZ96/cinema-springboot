package org.schiano.cinema.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NuovoGenereDTO {

    @NotBlank(message = "Il nome del genere è obbligatorio")
    private String nome;
}
