package it.softwareInside.AnagraficaAppLezione23.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.softwareInside.AnagraficaAppLezione23.models.Persona;
import it.softwareInside.AnagraficaAppLezione23.repository.PersonaRepository;
import jakarta.validation.Valid;

@Service
public class PersonaService {

	@Autowired
	PersonaRepository personaRepository;
	
	/**
	 * aggiungo una nuova persona al database
	 * 
	 * @param persona
	 * @return
	 */
	public boolean addPersona(@Valid Persona persona) {
		
		try {
			personaRepository.save(persona);
			return true;
			
		} catch (Exception e) {
			return false;
		}
		
	}
	
	/**
	 * modifico una persona nel database
	 * 
	 * @param persona
	 * @return
	 */
	public boolean update(Persona persona) {
		return addPersona(persona);
	}
	
	
	/**
	 * torno in output una persona selezionata con il codice fiscale
	 * 
	 * @param codFiscale
	 * @return
	 */
	public Optional<Persona> getPersona(String codFiscale) {
		
		try {
			return personaRepository.findById(codFiscale);
		} catch (Exception e) {
			return null;
		}
		
	}
	
	
	/**
	 * stampo tutte le persone presenti nel database
	 * 
	 * @return
	 */
	public Iterable<Persona> getAll(){
		return personaRepository.findAll();
	}
	
	/**
	 *metodo per cancellare tutte le persone 
	 * @return
	 */
	public boolean deleteAll() {
		personaRepository.deleteAll();
		return true;
	}
	
	/**
	 * metodo per cancellare una persona per codice fiscale
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(String codFiscale) {
		try {
			personaRepository.deleteById(codFiscale);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	
	/**
	 * 
	 * stampo tutte le persone con eta maggiore di 25
	 * 
	 * @param persone
	 * @return
	 */
	public Iterable<Persona> over25(Iterable<Persona>persone){
		
		ArrayList<Persona> personaGrandi = new ArrayList<>();
		
		for(Persona persona : persone)
			if(persona.getEta() >= 25)
				personaGrandi.add(persona);
				
		return personaGrandi;
	}
	
	
}
