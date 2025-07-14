package org.schiano.cinema.dto;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UtenteDTO {

    private Long id;

    @NotBlank(message = "Il nome è obbligatorio")
    private String nome;

    @NotBlank(message = "Il cognome è obbligatorio")
    private String cognome;

    @NotBlank(message = "Lo username è obbligatorio")
    private String username;

    @NotBlank(message = "L'email è obbligatoria")
    @Email(message = "Email non valida")
    private String email;

    private List<BigliettoDTO> biglietti;
}
