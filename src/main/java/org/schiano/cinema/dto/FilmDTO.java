package org.schiano.cinema.dto;

import lombok.Data;

@Data
public class FilmDTO {	//viene fuori dal DB, quindi già validato
	private Long id;
	private String titolo;
	private Integer durata;
	private String genere;

}
