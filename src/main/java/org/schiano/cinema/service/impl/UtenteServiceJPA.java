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
@RequiredArgsConstructor
public class UtenteServiceJPA implements UtenteService {

    private final UtenteRepository utenteRepository;
    private final UtenteMapper utenteMapper;
    private final PasswordEncoder passwordEncoder;

    public UtenteDTO save(NuovoUtenteDTO utenteDTO) {
        Utente temp = utenteMapper.fromInsertUtenteDTO(utenteDTO);
        temp.setNome(utenteDTO.getNome());
        temp.setCognome(utenteDTO.getCognome());
        temp.setUsername(utenteDTO.getUsername());
        temp.setRuolo(Ruolo.UTENTE);
        temp.setPassword(passwordEncoder.encode(utenteDTO.getPassword()));
        temp.setEmail(utenteDTO.getEmail());
        temp = utenteRepository.save(temp);
        return utenteMapper.toUtenteDTO(temp);
    }

	@Override
	public void create(Utente u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        //u.setRuolo(Ruolo.UTENTE);
        utenteRepository.save(u);
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

}
