package org.schiano.cinema.controller;

import java.util.List;

import org.schiano.cinema.dto.AttoreDTO;
import org.schiano.cinema.dto.NuovoAttoreDTO;
import org.schiano.cinema.mapper.AttoreMapper;
import org.schiano.cinema.model.Attore;
import org.schiano.cinema.service.definition.AttoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class AttoreController {
	
	@Autowired
	private AttoreService attoreService;
	
	@Autowired
	private AttoreMapper attoreMapper;
	
	@GetMapping("/attori")
	public ResponseEntity<List<AttoreDTO>> getAttore() {

		List<Attore> attori = attoreService.getAll();
		List<AttoreDTO> dto = attori.stream()
				.map(attore -> attoreMapper.toDTO(attore))
				.toList();
		
		return ResponseEntity.ok().body(dto);
			
	}

	
	@PostMapping("/attori")
	public ResponseEntity<Void> aggiungi(@RequestBody @Valid NuovoAttoreDTO attore) {
		
		attoreService.create(attoreMapper.fromNuovoDTO(attore));
		
		return ResponseEntity.status(201).build();	//201 = created
	}
	
	
	@DeleteMapping("/attori/{id}")
	public ResponseEntity<Void> rimuovi(@PathVariable Long id){
		if(!attoreService.exists(id)) {
			return ResponseEntity.notFound().build();
		}
		
		attoreService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	
	@PutMapping("/attori/{id}")
	public ResponseEntity<Void> modifica(@PathVariable Long id, @Valid @RequestBody AttoreDTO attoreDTO){
		if(!attoreService.exists(id)) {
			return ResponseEntity.notFound().build();
		}
		
		Attore attore = attoreMapper.fromDTO(attoreDTO);
		
		attore.setId(id);
		attoreService.update(attore);
		return ResponseEntity.ok().build();
	}
	
}
	

