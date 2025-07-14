package org.schiano.cinema.mapper;

import java.util.ArrayList;
import java.util.List;

import org.schiano.cinema.dto.AttoreDTO;
import org.schiano.cinema.dto.FilmDTO;
import org.schiano.cinema.dto.NuovoAttoreDTO;
import org.schiano.cinema.model.Attore;
import org.schiano.cinema.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AttoreMapper {
	
	@Autowired
	private FilmMapper filmMapper;
	
	public AttoreDTO toDTO(Attore attore) {
		if(attore==null) return null;
		
		AttoreDTO adto = new AttoreDTO();
		adto.setNome(attore.getNome());
		adto.setCognome(attore.getCognome());
	
		//VERSIONE BASIC
		List<Film> listaFilm = attore.getFilm();
		List<FilmDTO> filmDTO = new ArrayList<>();
		FilmDTO fdto;
		for (Film f : listaFilm) {
			fdto = filmMapper.toDTO(f);
			filmDTO.add(fdto);
		}
		adto.setFilms(filmDTO);
		
		
		
		//VERSIONE PRO
//		dto.setFilms(
//				attore.getFilm().stream()
//				.map(filmMapper::toDTO)		//film -> filmMapper.toDTO(film) //METHOD REFERENCE
//
//				.toList()
//		);
//				
		return adto;
	}
	
	public Attore fromNuovoDTO(NuovoAttoreDTO dto) {
		if (dto==null) { return null; }
		
		Attore a = new Attore();
		a.setNome(dto.getNome());
		a.setCognome(dto.getCognome());
		
		return a;
	}
	
	
	public Attore fromDTO(AttoreDTO dto) {
	    if (dto == null) return null;
	    Attore a = new Attore();
	    a.setId(dto.getId());
	    a.setNome(dto.getNome());
	    a.setCognome(dto.getCognome());
	    return a;
	}

}
