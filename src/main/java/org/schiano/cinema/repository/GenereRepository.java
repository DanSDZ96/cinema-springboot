package org.schiano.cinema.repository;

import org.schiano.cinema.model.Genere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenereRepository extends JpaRepository<Genere, Long> {

	Genere findByNomeIgnoreCase(String nome);

}
