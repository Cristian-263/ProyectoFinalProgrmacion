package modelo;

public class CondicionAtmosferica {
	private int id;
	private String nombre;
	
	//Constructor
	public CondicionAtmosferica(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	//getters y setters
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
	
	public int getPenalizacionAtaqueAtmosfera() {
		if(nombre.equalsIgnoreCase("lluvia")) {
			return 1;
		} else if(nombre.equalsIgnoreCase("nieve")) {
			return 2;
		} else {
			return 0;
		}
		
	}
	 @Override
	    public String toString() {
	        return nombre + " (penalización ataque: " + getPenalizacionAtaqueAtmosfera() + ")";
	    }

}
