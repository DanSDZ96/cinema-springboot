package org.schiano.cinema.service.definition;

import java.util.List;

public interface GeneralService<T> {
	
	//Metodi CRUD
	void create(T entity);	//CREATE
	List<T> getAll();		//READ ALL
	T getById(Long id);		//READ by ID
	void update(T entity); 	//UPDATE
	void delete(Long id);	//DELETE
}
