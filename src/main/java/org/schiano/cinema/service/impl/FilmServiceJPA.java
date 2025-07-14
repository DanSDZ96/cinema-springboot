package org.schiano.cinema.service.impl;

import java.util.List;

import org.schiano.cinema.model.Film;
import org.schiano.cinema.model.Genere;
import org.schiano.cinema.repository.FilmRepository;
import org.schiano.cinema.repository.GenereRepository;
import org.schiano.cinema.service.definition.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceJPA implements FilmService {

	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private GenereRepository genereRepository;

	@Override
	public void create(Film film) {
		filmRepository.save(film);
	}
	
	@Override
	public List<Film> getAll() {
		return filmRepository.findAll();
	}
	
	@Override
	public Film getById(Long id) {
		return filmRepository.findById(id).orElseThrow();
	}

	@Override
	public void update(Film film) {
		if (film.getId() != null && filmRepository.existsById(film.getId())) {
			filmRepository.save(film);
		}
	}

	@Override
	public void delete(Long id) {
		filmRepository.deleteById(id);
	}

	
	@Override
	public List<Film> getByGenere(String nome) {
		Genere genere = genereRepository.findByNomeIgnoreCase(nome);
	   
		if(genere == null) {	//Da FrontEnd ipotizziamo un menu a tendina
			return List.of();	//ma per sicurezza meglio prevedere anche NullPoint
		}
				
		return filmRepository.findByGenereId(genere.getId());
	}
	
	 @Override
	    public List<Film> getByTitolo(String titolo) {
	        return filmRepository.findByTitoloContainingIgnoreCase(titolo);
	    }

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	



}
