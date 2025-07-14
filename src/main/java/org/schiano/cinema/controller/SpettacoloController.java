package org.schiano.cinema.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.schiano.cinema.dto.NuovoSpettacoloDTO;
import org.schiano.cinema.dto.SpettacoloDTO;
import org.schiano.cinema.mapper.SpettacoloMapper;
import org.schiano.cinema.model.Film;
import org.schiano.cinema.model.Sala;
import org.schiano.cinema.model.Spettacolo;
import org.schiano.cinema.service.definition.FilmService;
import org.schiano.cinema.service.definition.SalaService;
import org.schiano.cinema.service.definition.SpettacoloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/spettacoli")
@RequiredArgsConstructor
public class SpettacoloController {

    private final SpettacoloService spettacoloService;
    private final FilmService filmService;
    private final SalaService salaService;
    private final SpettacoloMapper spettacoloMapper;

    @GetMapping
    public ResponseEntity<List<SpettacoloDTO>> getAll() {
        List<SpettacoloDTO> lista = spettacoloService.getAll()
                .stream()
                .map(spettacoloMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid NuovoSpettacoloDTO dto) {
        Film film = filmService.getById(dto.getFilmId());
        Sala sala = salaService.getById(dto.getSalaId());

        if (film == null || sala == null) {
            return ResponseEntity.badRequest().build();
        }

        Spettacolo s = spettacoloMapper.fromNuovoDTO(dto, film, sala);
        spettacoloService.create(s);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!spettacoloService.exists(id)) {
            return ResponseEntity.notFound().build();
        }
        spettacoloService.delete(id);
        return ResponseEntity.ok().build();
    }
}
