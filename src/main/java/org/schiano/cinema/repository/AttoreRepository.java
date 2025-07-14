package org.schiano.cinema.repository;

import org.schiano.cinema.model.Attore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttoreRepository extends JpaRepository<Attore, Long>{
	boolean existsById(Long id);

}
