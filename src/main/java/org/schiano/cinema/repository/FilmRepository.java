package org.schiano.cinema.repository;

import java.util.List;

import org.schiano.cinema.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
	
	public List<Film> findByGenereId(Long id);
	public List<Film> findByTitoloContainingIgnoreCase(String titolo);	//anche parziale e ignore case

}
