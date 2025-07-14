package org.schiano.cinema.service.definition;

import java.util.List;

import org.schiano.cinema.model.Film;

public interface FilmService extends GeneralService<Film> {

	public List<Film> getByGenere(String nome);
	public List<Film> getByTitolo(String titolo);

}
