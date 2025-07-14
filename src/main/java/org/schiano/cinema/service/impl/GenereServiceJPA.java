package org.schiano.cinema.service.impl;

import java.util.List;

import org.schiano.cinema.model.Genere;
import org.schiano.cinema.repository.GenereRepository;
import org.schiano.cinema.service.definition.GenereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenereServiceJPA implements GenereService {

    @Autowired
    private GenereRepository genereRepository;

    @Override
    public void create(Genere genere) {
        genereRepository.save(genere);
    }

    @Override
    public List<Genere> getAll() {
        return genereRepository.findAll();
    }

    @Override
    public Genere getById(Long id) {
        return genereRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Genere genere) {
        genereRepository.save(genere);
    }

    @Override
    public void delete(Long id) {
        genereRepository.deleteById(id);
    }

    @Override
    public boolean exists(Long id) {
        return genereRepository.existsById(id);
    }
}
