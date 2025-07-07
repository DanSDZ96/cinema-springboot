package org.schiano.cinema.mapper;

import org.schiano.cinema.dto.BigliettoDTO;
import org.schiano.cinema.model.Biglietto;
import org.springframework.stereotype.Component;

@Component
public class BigliettoMapper {

    public BigliettoDTO toDto(Biglietto b) {
//        if (b == null || b.getSpettacolo() == null) {
//            return null;
//        }

        BigliettoDTO dto = new BigliettoDTO();
        dto.setId(b.getId());
        dto.setPrezzo(b.getPrezzo());
        dto.setSpettacoloId(b.getSpettacolo().getId()); // Espone solo l'ID dello spettacolo
        return dto;
    }
}
