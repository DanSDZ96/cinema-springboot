package org.schiano.cinema.controller;

import java.util.List;

import org.schiano.cinema.model.Film;
import org.schiano.cinema.service.definition.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmController {
	
	@Autowired
	private FilmService filmService;
	
	@GetMapping("/film")
	public ResponseEntity<List<Film>> getFilm() {
		List<Film> listaFilm = filmService.getAll();
		
		if(listaFilm == null) {
			//errore cod500 perché NULL
			return ResponseEntity.internalServerError().build();
		}else {
			//restituisco cod200 e come body la lista dei film
			return ResponseEntity.ok().body(listaFilm);
		}
		
	}

}
