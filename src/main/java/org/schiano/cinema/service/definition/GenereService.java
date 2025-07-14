package org.schiano.cinema.service.definition;


import org.schiano.cinema.model.Genere;

public interface GenereService extends GeneralService<Genere> {
	 boolean exists(Long id);
}
