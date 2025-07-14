package org.schiano.cinema.controller;

import org.schiano.cinema.dto.NuovoUtenteDTO;
import org.schiano.cinema.dto.UtenteDTO;
import org.schiano.cinema.service.definition.UtenteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/utenti")
@RequiredArgsConstructor
public class UtenteController {

    private final UtenteService utenteService; // final è iniettato da RequiredArgsConstructor

    @PostMapping
    public ResponseEntity<UtenteDTO> registra(@RequestBody @Valid NuovoUtenteDTO nuovoUtente) {
        UtenteDTO creato = utenteService.create(nuovoUtente); 
        return ResponseEntity.status(201).body(creato);
    }
}
