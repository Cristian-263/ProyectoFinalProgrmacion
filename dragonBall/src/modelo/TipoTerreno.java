package modelo;

public class TipoTerreno {
	private int id;
	private String nombre;
	

	//Constructor
	public TipoTerreno(int id, String nombre ) {
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
	public int getPenalizacionAtaqueTerreno() {
		if(nombre.equalsIgnoreCase("rocoso")) {
			return 1;
		} else if(nombre.equalsIgnoreCase("montañoso")) {
			return 2;
		} else {
			return 0;
		}
		
	}
	public int getPenalizacionDefensaTerreno() {
		if(nombre.equalsIgnoreCase("rocoso")) {
			return 1;
		} else if(nombre.equalsIgnoreCase("montañoso")) {
			return 2;
		} else {
			return 0;
		}
		
	}
	 @Override
	    public String toString() {
	        return nombre + " (penalización ataque: " + getPenalizacionAtaqueTerreno() + ")"
	        	+ "\n" + nombre + " (penalización ataque: " + getPenalizacionDefensaTerreno() + ")";
	    }

}
