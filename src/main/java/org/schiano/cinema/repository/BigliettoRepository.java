package org.schiano.cinema.repository;

import org.schiano.cinema.model.Biglietto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository		//Superfluo dato che estende JpaRepository
public interface BigliettoRepository extends JpaRepository<Biglietto, Long> {
	boolean existsById(Long id);
}
