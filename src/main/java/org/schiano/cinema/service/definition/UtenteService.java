package org.schiano.cinema.service.definition;

import org.schiano.cinema.dto.NuovoUtenteDTO;
import org.schiano.cinema.dto.UtenteDTO;
import org.schiano.cinema.model.Utente;

public interface UtenteService extends GeneralService<Utente> {
    UtenteDTO create(NuovoUtenteDTO utenteDTO);
}
