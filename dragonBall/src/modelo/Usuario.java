package modelo;

public class Usuario {

	private String nombreUsuario;
    private String password;
 
    
    //Constructor
    public Usuario (String nombreUsuario, String password) {
    	
    	this.nombreUsuario = nombreUsuario;
    	this.password = password;

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




}
