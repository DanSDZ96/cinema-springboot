package org.schiano.cinema.mapper;

import org.schiano.cinema.dto.FilmDTO;
import org.schiano.cinema.model.Film;

public class FilmMapper {
	public FilmDTO toDTO(Film film) {
        FilmDTO dto = new FilmDTO();
        dto.setId(film.getId());
        dto.setTitolo(film.getTitolo());
        dto.setDurata(film.getDurata());
        dto.setGenere(film.getGenere().getNome());
       
        return dto;
    }

}
