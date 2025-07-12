package org.schiano.cinema.mapper;

import org.schiano.cinema.dto.BigliettoDTO;
import org.schiano.cinema.dto.NuovoBigliettoDTO;
import org.schiano.cinema.model.Biglietto;
import org.schiano.cinema.model.Spettacolo;
import org.springframework.stereotype.Component;

@Component
public class BigliettoMapper {

    public Biglietto fromDto(BigliettoDTO dto) {
        if (dto == null) {
            return null;
        }

        Biglietto b = new Biglietto();
        b.setId(dto.getId());
        b.setPrezzo(dto.getPrezzo());

        Spettacolo s = new Spettacolo();
        s.setId(dto.getSpettacoloId());
        b.setSpettacolo(s);

        return b;
    }

    public Biglietto fromDto(NuovoBigliettoDTO dto) {
        if (dto == null) {
            return null;
        }

        Biglietto b = new Biglietto();
        b.setPrezzo(dto.getPrezzo());

        Spettacolo s = new Spettacolo();
        s.setId(dto.getSpettacoloId());
        b.setSpettacolo(s);

        return b;
    }

    public BigliettoDTO toDto(Biglietto b) {
        if (b == null || b.getSpettacolo() == null) {
            return null;
        }

        BigliettoDTO dto = new BigliettoDTO();
        dto.setId(b.getId());
        dto.setPrezzo(b.getPrezzo());
        dto.setSpettacoloId(b.getSpettacolo().getId());
        return dto;
    }
}
