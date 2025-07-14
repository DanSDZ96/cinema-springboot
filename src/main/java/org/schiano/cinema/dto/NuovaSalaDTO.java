package org.schiano.cinema.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NuovaSalaDTO {
    @NotBlank
    private String nome;

    @Min(1)
    private Integer capienza;
}
