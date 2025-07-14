package org.schiano.cinema.service.definition;

import org.schiano.cinema.model.Sala;

public interface SalaService extends GeneralService<Sala> {

	boolean existsByNome(String nome);
	
}
