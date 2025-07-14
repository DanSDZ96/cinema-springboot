package org.schiano.cinema.service.impl;

import java.util.List;

import org.schiano.cinema.model.Spettacolo;
import org.schiano.cinema.repository.SpettacoloRepository;
import org.schiano.cinema.service.definition.SpettacoloService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SpettacoloServiceJPA implements SpettacoloService {

    private final SpettacoloRepository spettacoloRepository;

    @Override
    public void create(Spettacolo entity) {
        spettacoloRepository.save(entity);
    }

    @Override
    public List<Spettacolo> getAll() {
        return spettacoloRepository.findAll();
    }

    @Override
    public Spettacolo getById(Long id) {
        return spettacoloRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Spettacolo entity) {
        spettacoloRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        spettacoloRepository.deleteById(id);
    }

    @Override
    public boolean exists(Long id) {
        return spettacoloRepository.existsById(id);
    }
}
