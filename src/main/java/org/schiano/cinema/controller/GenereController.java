package org.schiano.cinema.controller;

import java.util.List;

import org.schiano.cinema.model.Genere;
import org.schiano.cinema.service.definition.GenereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/generi")
public class GenereController {

    @Autowired
    private GenereService genereService;

    @GetMapping
    public ResponseEntity<List<Genere>> getAll() {
        List<Genere> generi = genereService.getAll();
        return ResponseEntity.ok(generi);
    }

    @PostMapping
    public ResponseEntity<Void> addGenere(@Valid @RequestBody Genere genere) {
        genereService.create(genere);
        return ResponseEntity.status(201).build();
    }
}
