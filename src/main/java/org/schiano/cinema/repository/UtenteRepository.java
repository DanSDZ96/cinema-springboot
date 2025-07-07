package org.schiano.cinema.repository;

import org.schiano.cinema.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

	Utente findByUsername(String username);

}
