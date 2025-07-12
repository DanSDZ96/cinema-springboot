package org.schiano.cinema.controller;

import java.util.List;

import org.schiano.cinema.dto.BigliettoDTO;
import org.schiano.cinema.dto.NuovoBigliettoDTO;
import org.schiano.cinema.mapper.BigliettoMapper;
import org.schiano.cinema.model.Biglietto;
import org.schiano.cinema.service.definition.BigliettoService;
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
public class BigliettoController {

	@Autowired
    private BigliettoMapper bigliettoMapper;
	
	@Autowired
	private BigliettoService bigliettoService;


	@GetMapping("/admin/biglietti")
	public List<Biglietto> getAll() {
	    return bigliettoService.getAll();
	}
	
	@GetMapping("admin/biglietti/{id}")
	public ResponseEntity<Biglietto> getById(@PathVariable Long id) {
	    Biglietto b = bigliettoService.getById(id);
	    if(b == null) {
	    	return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok(b);
	}
	
	@DeleteMapping("/biglietti/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
	    bigliettoService.delete(id);
	    return ResponseEntity.ok().build();
	}

	
	@PutMapping("/biglietti")
	public ResponseEntity<Void> update(@RequestBody @Valid BigliettoDTO dto) {
	    bigliettoService.update(bigliettoMapper.fromDto(dto));
	    return ResponseEntity.ok().build();
	}


	@PostMapping("/biglietti")
	public ResponseEntity<Void> aggiungiBiglietto(@RequestBody @Valid NuovoBigliettoDTO dto) {
	    bigliettoService.create(bigliettoMapper.fromDto(dto));
	    return ResponseEntity.ok().build();
	}

	
	
	
	
	
	
	

}
