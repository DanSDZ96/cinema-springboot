package org.schiano.cinema.service.impl;

import java.util.List;

import org.schiano.cinema.model.Attore;
import org.schiano.cinema.service.definition.AttoreService;
import org.schiano.cinema.utility.DBInit;

public class AttoreServiceJPA implements AttoreService {
	
	private final List<Attore> listaAttori = DBInit.listaAttori ;
	
	@Override
	public void create(Attore attore) {
		listaAttori.add(attore);
	}
	
	@Override
	public List<Attore> getAll() {
		return listaAttori;
	}
	
	@Override
	public Attore getById(Long id) {
		for (Attore a : listaAttori) {
			if (a.getId().equals(id)) {
				return a;
			}
		}
		return null;
	}
	
	@Override
	public void update (Attore attore) {
		for (Attore a : listaAttori) {
			if (a.getId().equals(attore.getId())) {
				a.setNome(attore.getNome());
				a.setCognome(attore.getCognome());
				return;
			}
		}
	}
	
	@Override
	public void delete (Long id) {
		listaAttori.removeIf(a -> a.getId().equals(id));
		
	}

}
