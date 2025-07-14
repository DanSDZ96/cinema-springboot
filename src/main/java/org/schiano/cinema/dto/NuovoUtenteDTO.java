package org.schiano.cinema.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class NuovoUtenteDTO {

    @NotBlank(message = "Il nome è obbligatorio")
    private String nome;

    @NotBlank(message = "Il cognome è obbligatorio")
    private String cognome;

    @NotBlank(message = "Lo username è obbligatorio")
    private String username;

    @NotBlank(message = "L'email è obbligatoria")
    @Email(message = "Formato email non valido")
    private String email;

    @NotBlank(message = "La password è obbligatoria")
    @Size(min = 6, message = "La password deve contenere almeno 6 caratteri")
    private String password;
}
