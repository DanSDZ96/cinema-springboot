package org.schiano.cinema.utility;

import java.util.List;

import org.schiano.cinema.model.Attore;
import org.schiano.cinema.model.Film;
import org.schiano.cinema.model.Genere;
import org.schiano.cinema.model.Sala;
import org.schiano.cinema.repository.AttoreRepository;
import org.schiano.cinema.repository.FilmRepository;
import org.schiano.cinema.repository.SalaRepository;
import org.schiano.cinema.repository.GenereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DBInit {

	@Autowired
	private GenereRepository genereRepository;

	@Autowired
	private AttoreRepository attoreRepository;

	@Autowired
	private SalaRepository salaRepository;

	@Autowired
	private FilmRepository filmRepository;

	
	@PostConstruct
	public void init() {
		//ATTORI
		attoreRepository.saveAll(
			List.of(
				new Attore("morgan", "freeman"),
				new Attore("leonardo", "dicaprio"),
				new Attore("jim", "carrey")
			)
		);
		
		salaRepository.saveAll(
			List.of(
				new Sala("Aurora", 200),
				new Sala("Daniel", 150),
				new Sala("Cecilia", 50)
			)
		);
		
		Genere avventura = new Genere("Avventura");
		Genere romantico = new Genere("Romantico");
		Genere fantascienza = new Genere("Fantascienza");

		genereRepository.saveAll(List.of(avventura, romantico, fantascienza));
		
		
		filmRepository.saveAll(
			List.of(
				new Film("LOTR", 300, avventura),
				new Film("Eternal Sunshine", 150, romantico),
				new Film("Interstellar", 200, fantascienza)
			)
			);
}
}