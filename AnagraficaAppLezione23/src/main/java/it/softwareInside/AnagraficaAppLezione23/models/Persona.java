package it.softwareInside.AnagraficaAppLezione23.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Persona {
	
	@Id
	@Size(min = 5, max = 5, message = "{validation.name.size}")
	private String codFiscale;
	
	@Min(15)
	private int eta;
	
	@NotEmpty(message=" non puo essere vuoto")
	@NotNull(message=" non puo essere nullo")
	private String nome;
	
	@NotEmpty(message=" non puo essere vuoto")
	@NotNull(message=" non puo essere nullo")
	private String cognome;
}
