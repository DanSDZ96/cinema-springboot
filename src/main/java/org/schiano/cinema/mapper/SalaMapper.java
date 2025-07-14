package org.schiano.cinema.mapper;

import org.schiano.cinema.dto.NuovaSalaDTO;
import org.schiano.cinema.dto.SalaDTO;
import org.schiano.cinema.model.Sala;
import org.springframework.stereotype.Component;

@Component
public class SalaMapper {

    public SalaDTO toDTO(Sala sala) {
        if (sala == null) return null;

        SalaDTO dto = new SalaDTO();
        dto.setId(sala.getId());
        dto.setNome(sala.getNome());
        dto.setCapienza(sala.getCapienza());
        return dto;
    }

    public Sala fromDTO(SalaDTO dto) {
        if (dto == null) return null;

        Sala sala = new Sala();
        sala.setId(dto.getId());
        sala.setNome(dto.getNome());
        sala.setCapienza(dto.getCapienza());
        return sala;
    }

    public Sala fromNuovaDTO(NuovaSalaDTO dto) {
        if (dto == null) return null;

        Sala sala = new Sala();
        sala.setNome(dto.getNome());
        sala.setCapienza(dto.getCapienza());
        return sala;
    }
}
