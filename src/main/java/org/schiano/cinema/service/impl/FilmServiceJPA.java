package org.schiano.cinema.service.impl;

import java.util.List;

import org.schiano.cinema.model.Film;
import org.schiano.cinema.service.definition.FilmService;
import org.schiano.cinema.utility.DBInit;

public class FilmServiceJPA implements FilmService {
	
	List<Film> listaFilm = DBInit.listaFilm;

	@Override
	public void create(Film entity) {
		listaFilm.add(entity);
	}

	@Override
	public List<Film> getAll() {
		return listaFilm;
	}

	@Override
	public Film getById(Long id) {
		for (Film f : listaFilm) {
			if (f.getId().equals(id)) {
				return f;
			}
		}
		return null;
	}

	@Override
	public void update(Film entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
