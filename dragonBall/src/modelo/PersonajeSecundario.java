package modelo;

import java.util.List;

public class PersonajeSecundario extends PersonajeCombatiente{
	
	List<String> frases;
	
	//Constructor
	public PersonajeSecundario() {
		
	}
	public PersonajeSecundario(String nombre, int vida,List<Ataque> listaAtaques, List<String> frases) {
		super(nombre, vida, listaAtaques);
		this.frases = frases;
	}
}


