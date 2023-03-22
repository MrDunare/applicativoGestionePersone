package it.softwareInside.AnagraficaAppLezione23.restController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import it.softwareInside.AnagraficaAppLezione23.models.Persona;
import it.softwareInside.AnagraficaAppLezione23.service.PersonaService;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	
	@Autowired
	PersonaService personaService;
	
	@PostMapping("/add")
	public boolean addPersona(@RequestBody Persona persona) {
		return personaService.addPersona(persona);
	}
	
	@PostMapping("/update")
	public boolean update(@RequestBody Persona persona) {
		return personaService.update(persona);
	}
	
	@GetMapping("/find")
	public Optional<Persona> getPersona(@RequestParam ("codFiscale") String codFiscale) {
		return personaService.getPersona(codFiscale);
	}
	
	@GetMapping("/findAll")
	public Iterable<Persona> getAll(){
		return personaService.getAll();
	}
	
	@DeleteMapping("/delete")
	public boolean delete(@RequestParam ("codFiscale") String codFiscale) {
		return personaService.delete(codFiscale);
	}
	
	@DeleteMapping("/deleteAll")
	public boolean deleteAll() {
		return personaService.deleteAll();
	}
	
	@GetMapping("/over")
	public Iterable<Persona> persona(){
		return personaService.over25(getAll());
	}
	
	
	
}
