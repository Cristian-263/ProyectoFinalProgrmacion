package modelo;

public class HistoriaGoku {

	   private Protagonista protagonista;
		  
	   private Juego juego;


	   public HistoriaGoku(Protagonista protagonista, Juego juego) {
		    this.protagonista = protagonista;
		    this.juego = juego;
		}


	    public void iniciar() {
	        System.out.println("🌟 Comienza la historia de Goku...");
	        
	    }
}
