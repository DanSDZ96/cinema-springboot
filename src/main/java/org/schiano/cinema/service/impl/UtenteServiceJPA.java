package org.schiano.cinema.service.impl;

import java.util.List;

import org.schiano.cinema.dto.NuovoUtenteDTO;
import org.schiano.cinema.dto.UtenteDTO;
import org.schiano.cinema.mapper.UtenteMapper;
import org.schiano.cinema.model.Ruolo;
import org.schiano.cinema.model.Utente;
import org.schiano.cinema.repository.UtenteRepository;
import org.schiano.cinema.service.definition.UtenteService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //+final = AUTOWIRED moderno
public class UtenteServiceJPA implements UtenteService {
	

    private final UtenteRepository utenteRepository;
    private final UtenteMapper utenteMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UtenteDTO create(NuovoUtenteDTO utenteDTO) {
        Utente ut = utenteMapper.fromInsertUtenteDTO(utenteDTO);

        ut.setRuolo(Ruolo.UTENTE);
        ut.setPassword(passwordEncoder.encode(utenteDTO.getPassword()));

        ut = utenteRepository.save(ut);
        return utenteMapper.toUtenteDTO(ut);
    }

	@Override
	public List<Utente> getAll() {
		 return utenteRepository.findAll();
	}

	@Override
	public Utente getById(Long id) {
		 return utenteRepository.findById(id).orElse(null);
	}

	@Override
	public void update(Utente nuovo) {
	    // Recupero utente dal DB
	    Utente utente = utenteRepository.findById(nuovo.getId())
	        .orElseThrow(() -> new IllegalArgumentException("Utente non trovato con ID: " + nuovo.getId()));

	    // Aggiornamento campi solo se non nulli
	    if (nuovo.getNome() != null) 
	    	utente.setNome(nuovo.getNome());
	    
	    if (nuovo.getCognome() != null) 
	    	utente.setCognome(nuovo.getCognome());
	    
	    if (nuovo.getUsername() != null) 
	    	utente.setUsername(nuovo.getUsername());
	    
	    if (nuovo.getEmail() != null) 
	    	utente.setEmail(nuovo.getEmail());

	    if (nuovo.getPassword() != null && !nuovo.getPassword().isBlank()) {
	        utente.setPassword(passwordEncoder.encode(nuovo.getPassword()));
	    }

	    utenteRepository.save(utente);
	}


	@Override
	public void delete(Long id) {
        if (utenteRepository.existsById(id)) {
            utenteRepository.deleteById(id);
        }
    }

	@Override
	public boolean exists(Long id) {
	    return utenteRepository.existsById(id);
	}

	@Override
	public void create(Utente entity) {
	    if (entity.getPassword() != null && !entity.getPassword().isBlank()) {
	        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
	    }

	    // Imposta il ruolo di default se non presente
	    if (entity.getRuolo() == null) {
	        entity.setRuolo(Ruolo.UTENTE);
	    }

	    utenteRepository.save(entity);
	}



}
