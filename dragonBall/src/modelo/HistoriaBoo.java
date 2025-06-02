package modelo;

public class HistoriaBoo {

	   private Protagonista protagonista;
	  
	   private Juego juego;


	   public HistoriaBoo(Protagonista protagonista, Juego juego) {
		    this.protagonista = protagonista;
		    this.juego = juego;
		}


	    public void iniciar() {
	        System.out.println("🌟 Comienza la historia de Majin Boo...");
	        
	    }
	    
}
