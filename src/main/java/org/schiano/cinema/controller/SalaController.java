package org.schiano.cinema.controller;

import java.util.List;

import org.schiano.cinema.dto.NuovaSalaDTO;
import org.schiano.cinema.dto.SalaDTO;
import org.schiano.cinema.mapper.SalaMapper;
import org.schiano.cinema.model.Sala;
import org.schiano.cinema.service.definition.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sale")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @Autowired
    private SalaMapper salaMapper;

    @GetMapping
    public ResponseEntity<List<SalaDTO>> getAll() {
        List<Sala> sale = salaService.getAll();
        List<SalaDTO> saleDTO = sale.stream()
            .map(salaMapper::toDTO)
            .toList();
        return ResponseEntity.ok(saleDTO);
    }

    @PostMapping
    public ResponseEntity<Void> crea(@RequestBody @Valid NuovaSalaDTO dto) {
        salaService.create(salaMapper.fromNuovaDTO(dto));
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> aggiorna(@PathVariable Long id, @RequestBody @Valid SalaDTO dto) {
        if (!salaService.exists(id)) {
            return ResponseEntity.notFound().build();
        }
        Sala sala = salaMapper.fromDTO(dto);
        sala.setId(id);
        salaService.update(sala);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> elimina(@PathVariable Long id) {
        if (!salaService.exists(id)) {
            return ResponseEntity.notFound().build();
        }
        salaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
