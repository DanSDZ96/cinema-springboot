package org.schiano.cinema.mapper;

import java.util.ArrayList;
import java.util.List;

import org.schiano.cinema.dto.BigliettoDTO;
import org.schiano.cinema.dto.NuovoUtenteDTO;
import org.schiano.cinema.dto.UtenteDTO;
import org.schiano.cinema.model.Biglietto;
import org.schiano.cinema.model.Utente;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UtenteMapper {
	
	private final BigliettoMapper bigliettoMapper;

	public Utente fromInsertUtenteDTO(NuovoUtenteDTO dto) {
	    if (dto == null) return null;

	    Utente u = new Utente();
	    u.setNome(dto.getNome());
	    u.setCognome(dto.getCognome());
	    u.setUsername(dto.getUsername());
	    u.setEmail(dto.getEmail());
	    u.setPassword(dto.getPassword());  // da codificare nel service
	    return u;
	}

    public UtenteDTO toUtenteDTO(Utente utente) {
        UtenteDTO dto = new UtenteDTO();
        dto.setId(utente.getId());
        dto.setNome(utente.getNome());
        dto.setCognome(utente.getCognome());
        dto.setUsername(utente.getUsername());
        dto.setEmail(utente.getEmail());

        if (utente.getBiglietti() != null) {
            List<BigliettoDTO> lista = new ArrayList<>();
            for (Biglietto b : utente.getBiglietti()) {
                lista.add(bigliettoMapper.toDto(b));
            }
            dto.setBiglietti(lista);
        }


        return dto;
    }
}
