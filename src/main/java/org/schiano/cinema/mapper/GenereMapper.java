package org.schiano.cinema.mapper;

import org.schiano.cinema.dto.GenereDTO;
import org.schiano.cinema.dto.NuovoGenereDTO;
import org.schiano.cinema.model.Genere;
import org.springframework.stereotype.Component;

@Component
public class GenereMapper {

    public GenereDTO toDTO(Genere genere) {
        if (genere == null) return null;
        GenereDTO dto = new GenereDTO();
        dto.setId(genere.getId());
        dto.setNome(genere.getNome());
        return dto;
    }

    public Genere fromDTO(GenereDTO dto) {
        if (dto == null) return null;
        Genere g = new Genere();
        g.setId(dto.getId());
        g.setNome(dto.getNome());
        return g;
    }

    public Genere fromNuovoDTO(NuovoGenereDTO dto) {
        if (dto == null) return null;
        Genere g = new Genere();
        g.setNome(dto.getNome());
        return g;
    }
}
