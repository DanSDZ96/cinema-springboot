package org.schiano.cinema.controller;

import java.util.ArrayList;
import java.util.List;

import org.schiano.cinema.dto.FilmDTO;
import org.schiano.cinema.mapper.FilmMapper;
import org.schiano.cinema.model.Film;
import org.schiano.cinema.service.definition.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class FilmController {
	
	@Autowired
	private FilmMapper filmMapper;

	//@Autowired NO -- Iniezione tramite costruttore
    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/film")
    public ResponseEntity<List<Film>> getAll() {
        List<Film> films = filmService.getAll();
        List<FilmDTO> filmsDTO = new ArrayList<>();
        
        for(Film f : films) {
        	FilmDTO fDTO = filmMapper.toDTO(f);
        	filmsDTO.add(fDTO);
        }
        
        return ResponseEntity.ok(films);
    }
    
    
    @GetMapping("/film/{titolo}")
    public ResponseEntity<List<Film>> getByTitolo(@PathVariable String titolo){
    	List<Film> filmList = filmService.getByTitolo(titolo);
    	
    	if (filmList.isEmpty()) {
    		return ResponseEntity.noContent().build();
    	}
    	
    	return ResponseEntity.ok(filmList);
    	
    }
    
    @GetMapping("/film/{genere}")
    public ResponseEntity<List<Film>> getByGenere(@PathVariable String genere) {
    	List<Film> filmList = filmService.getByGenere(genere);
		
    	if (filmList.isEmpty()) {
    		return ResponseEntity.noContent().build();
    	}
    	
    	return ResponseEntity.ok(filmList);
    }
    
    //FUNZIONALITA' ADMIN
    //TODO In futuro, inserire SECURITY
    
    
    
    @GetMapping("/admin/film/{id}")
    public ResponseEntity<Film> getById(@PathVariable Long id) {
        Film film = filmService.getById(id);
        if(film == null) {
        	return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(film);
    }
    
    @PostMapping("/admin/film")
    public ResponseEntity<Void> aggiungiFilm(@RequestBody @Valid Film film) {
        filmService.create(film);
        return ResponseEntity.ok().build(); // oppure .created(...).build()
    }

    @PutMapping("/admin/film")
    public ResponseEntity<Void> modificaFilm(@RequestBody @Valid Film film) {
        filmService.update(film);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/admin/film/{id}")
    public ResponseEntity<Void> rimuoviFilm(@PathVariable Long id) {
        filmService.delete(id);
        return ResponseEntity.ok().build();
    }
    
}
