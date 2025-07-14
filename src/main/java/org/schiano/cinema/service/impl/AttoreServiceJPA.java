package org.schiano.cinema.service.impl;

import java.util.List;

import org.schiano.cinema.error.exceptions.AttoreNonTrovatoException;
import org.schiano.cinema.error.exceptions.UpdateSenzaIdException;
import org.schiano.cinema.model.Attore;
import org.schiano.cinema.repository.AttoreRepository;
import org.schiano.cinema.service.definition.AttoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AttoreServiceJPA implements AttoreService {

    @Autowired
	private AttoreRepository attoreRepository;

	@Override
	public void create(Attore attore) {
		attoreRepository.save(attore);
	}
	
	@Override
	public List<Attore> getAll() {
		return attoreRepository.findAll();
	}
	
	@Override
	public Attore getById(Long id) {
		return attoreRepository.findById(id).orElse(null);
	}
	
	@Override
	public void update (Attore attore) {
		if(attore.getId() == null) {
			throw new UpdateSenzaIdException("ID mancante");
		}
		
		if(!attoreRepository.existsById(attore.getId())) {
			throw new AttoreNonTrovatoException("Attore non trovato");
		}
		
		attoreRepository.save(attore);

	}
	
	@Override
	public void delete (Long id) {
		if(!attoreRepository.existsById(id)) {
			throw new AttoreNonTrovatoException("Attore non trovato");
		}
		attoreRepository.deleteById(id);
	}
	
	
	public boolean exists(Long id) {
	    return attoreRepository.existsById(id);
	}

}
