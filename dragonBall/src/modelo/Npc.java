package modelo;

import java.util.List;

public class Npc extends Personaje {
	List<String> frases;
	
	//Constructor
	public Npc () {
		
	}
	public Npc (String nombre, List<String> frases) {
		super(nombre);
		this.frases = frases;
	}
	
	//getters y setters
	public List<String> getFrase() {
		return frases;
	}
	public void setFrase(List<String> frases) {
		this.frases = frases;
	}
	
}
