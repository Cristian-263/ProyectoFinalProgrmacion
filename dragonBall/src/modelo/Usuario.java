package modelo;

public class Usuario {

	private String nombreUsuario;
    private String password;
    private int puntuacion;
    
    //Constructor
    public Usuario (String nombreUsuario, String password) {
    	
    	this.nombreUsuario = nombreUsuario;
    	this.password = password;
    	this.puntuacion = 0;
    }

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

    
}
