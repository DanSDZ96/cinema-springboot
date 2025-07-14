package org.schiano.cinema.service.impl;

import java.util.List;

import org.schiano.cinema.model.Sala;
import org.schiano.cinema.repository.SalaRepository;
import org.schiano.cinema.service.definition.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaServiceJPA implements SalaService {

    @Autowired
    private SalaRepository salaRepository;

    @Override
    public List<Sala> getAll() {
        return salaRepository.findAll();
    }

    @Override
    public Sala getById(Long id) {
        return salaRepository.findById(id).orElse(null);
    }

    @Override
    public void create(Sala sala) {
        salaRepository.save(sala);
    }

    @Override
    public void update(Sala sala) {
        salaRepository.save(sala);
    }

    @Override
    public void delete(Long id) {
        salaRepository.deleteById(id);
    }

    @Override
    public boolean exists(Long id) {
        return salaRepository.existsById(id);
    }

    @Override
    public boolean existsByNome(String nome) {
        return salaRepository.existsByNome(nome);
    }
}
