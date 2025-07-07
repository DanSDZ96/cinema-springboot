package org.schiano.cinema.controller;

import java.util.List;

import org.schiano.cinema.model.Attore;
import org.schiano.cinema.service.definition.AttoreService;
import org.schiano.cinema.utility.DBInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttoreController {
	
	@Autowired
	private AttoreService attoreService;
	
	@GetMapping("/VisualizzaAttori")
	public ResponseEntity<List<Attore>> getAttore() {
	//	List<Attore> attori = Database.listaAttori;	//non interagisco più col DB ma col layer intermedio
		List<Attore> attori = attoreService.getAll();
		
		if(attori==null) {
			//errore codice 500 perché ritorna un NULL
			return ResponseEntity.internalServerError().build();
		}
		else {
			//altrimenti, restituisco codice 200 e come body la lista di utenti
			return ResponseEntity.ok().body(attori);
		}
		
	}

	
	@PostMapping("/AggiungiAttore")
	public ResponseEntity<Void> aggiungi(@RequestBody Attore attore) {
		if(attore.getNome() == null || attore.getNome().isBlank() ||
		   attore.getCognome() == null || attore.getCognome().isBlank())
		{
			return ResponseEntity.badRequest().build();
		}
		
		attore = new Attore(attore.getNome(), attore.getCognome());
		
		DBInit.listaAttori.add(attore);
		return ResponseEntity.ok().build();
		
	}
	
	
	@DeleteMapping("/RimuoviAttore")
	public ResponseEntity<Void> rimuovi(@RequestBody Attore attore){
		return ResponseEntity.badRequest().build();
		
		
	}
	
	
	@PutMapping("/ModificaAttore")
	public ResponseEntity<Void> modifica(@RequestBody Attore attore){
		return ResponseEntity.badRequest().build();
	}
	
}
	

