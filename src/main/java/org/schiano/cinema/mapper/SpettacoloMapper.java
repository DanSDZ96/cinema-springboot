package org.schiano.cinema.mapper;

import org.schiano.cinema.dto.NuovoSpettacoloDTO;
import org.schiano.cinema.dto.SpettacoloDTO;
import org.schiano.cinema.model.Film;
import org.schiano.cinema.model.Sala;
import org.schiano.cinema.model.Spettacolo;
import org.springframework.stereotype.Component;

@Component
public class SpettacoloMapper {

    public SpettacoloDTO toDTO(Spettacolo s) {
        if (s == null) return null;

        SpettacoloDTO dto = new SpettacoloDTO();
        dto.setId(s.getId());
        dto.setDataOra(s.getDataOra());
        dto.setPrezzo(s.getPrezzo());

        if (s.getFilm() != null) {
            dto.setFilmId(s.getFilm().getId());
            dto.setFilmTitolo(s.getFilm().getTitolo());
        }

        if (s.getSala() != null) {
            dto.setSalaId(s.getSala().getId());
            dto.setSalaNome(s.getSala().getNome());
        }

        return dto;
    }

    public Spettacolo fromDTO(SpettacoloDTO dto, Film film, Sala sala) {
        if (dto == null) return null;

        Spettacolo s = new Spettacolo();
        s.setId(dto.getId());
        s.setDataOra(dto.getDataOra());
        s.setPrezzo(dto.getPrezzo());
        s.setFilm(film);
        s.setSala(sala);
        return s;
    }

    public Spettacolo fromNuovoDTO(NuovoSpettacoloDTO dto, Film film, Sala sala) {
        if (dto == null) return null;

        Spettacolo s = new Spettacolo();
        s.setDataOra(dto.getDataOra());
        s.setPrezzo(dto.getPrezzo());
        s.setFilm(film);
        s.setSala(sala);
        return s;
    }
}
