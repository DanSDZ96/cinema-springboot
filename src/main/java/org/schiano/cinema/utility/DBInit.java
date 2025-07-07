package org.schiano.cinema.utility;
import java.util.ArrayList;
import java.util.List;

import org.schiano.cinema.model.Attore;
import org.schiano.cinema.model.Film;
import org.schiano.cinema.model.Sala;
import org.schiano.cinema.model.Spettacolo;



public class DBInit {
	
	
	public static final List<Attore> listaAttori = new ArrayList<Attore> (List.of( 
			new Attore(1L, "morgan", "freeman"),
			new Attore(2L, "leonardo", "dicaprio"),
			new Attore(3L, "jim", "carrey")
			)
			);
	
	
	public static final List<Sala> listaSale = new ArrayList<Sala> (List.of(
			new Sala(1L, "aurora", 200),
			new Sala(2L, "daniel", 100)
			)
			);
	
	public static final List<Spettacolo> listaSpettacoli =new ArrayList<Spettacolo> ();
	
	public static final List<Film> listaFilm = new ArrayList<Film> (List.of( 
			new Film(1L, "LOTR", "Avventura", 300),
			new Film(2L, "Eternal Sunshine", "Romantico", 100),
			new Film(3L, "Interstellar", "Fantascienza", 200)
			));


	
			
	
	
	
	
	
	
}
