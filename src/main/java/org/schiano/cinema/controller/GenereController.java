package org.schiano.cinema.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.schiano.cinema.dto.GenereDTO;
import org.schiano.cinema.dto.NuovoGenereDTO;
import org.schiano.cinema.mapper.GenereMapper;
import org.schiano.cinema.model.Genere;
import org.schiano.cinema.service.definition.GenereService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/generi")
@RequiredArgsConstructor
public class GenereController {

    private final GenereService genereService;
    private final GenereMapper genereMapper;

    @GetMapping
    public ResponseEntity<List<GenereDTO>> getAll() {
        List<GenereDTO> lista = genereService.getAll()
            .stream()
            .map(genereMapper::toDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<Void> addGenere(@Valid @RequestBody NuovoGenereDTO nuovoGenere) {
        Genere g = genereMapper.fromNuovoDTO(nuovoGenere);
        genereService.create(g);
        return ResponseEntity.status(201).build();
    }
}
