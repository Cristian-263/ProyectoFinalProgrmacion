package modelo;

import java.util.Scanner;

public class HistoriaBoo {

	private Protagonista protagonista;
	private Juego juego;
	private Scanner sc = new Scanner(System.in);

	public HistoriaBoo(Protagonista protagonista, Juego juego) {
		this.protagonista = protagonista;
		this.juego = juego;
	}

	public void iniciar() {
		escenaInicialBoo();
		decision1();

	}
	
	//ESCENA INICIAL DE LA HISTORIA DE BOO
	private void escenaInicialBoo() {
		System.out.println("🌪️ Majin Boo se despierta tras siglos de encierro...");
		System.out.println("""
				Durante años, el universo ha respirado en paz...
				pero esa paz está a punto de romperse.
				Desde lo más profundo del abismo mágico, un ser de poder ilimitado abre sus ojos por primera vez en milenios.
				Majin Boo, una criatura tan impredecible como destructiva, ha despertado bajo las órdenes del malvado Babidi.
				¿Seguirás sus mandatos sin cuestionarlos... o forjarás tu propio destino?
				El universo contiene el aliento. La historia de Boo comienza...
				""");
	}
	//DECISION 1: BABIDI
	private void decision1() {
		
	    System.out.println("🤔 ¿Obedecerás a Babidi?");
	    System.out.println("1. Sí, obedeceré sus órdenes sin dudar");
	    System.out.println("2. No, seguiré mi propio camino");

	    int eleccion = sc.nextInt(); 
	    sc.nextLine();

	    if (eleccion == 1) {
	        System.out.println("\n🔥 Has decidido obedecer a Babidi. Te conviertes en una máquina de destrucción...");
	        ramaDestructora();
	    } else {
	        System.out.println("\n🕊️ Has decidido ignorar a Babidi. Tu camino será incierto, pero tuyo.");
	        ramaPacifica();
	    }
	}
	
	//OBEDECES A BABIDI -- RAMA DESTRUCTORA
	private void ramaDestructora() {
		escenaDestruirCiudad();
		
	}
	
	private void escenaDestruirCiudad() {
		System.out.println("\n🛡️ Babidi te ordena destruir una ciudad.");
        System.out.println("¿Cómo quieres hacerlo?");
        System.out.println("1. Desde el cielo (pierdes 10 de vida)");
        System.out.println("2. Convirtiendo a sus habitantes en chocolate (ganas 10 de vida)");
        
        String eleccion = "";
        while (!eleccion.equals("1") && !eleccion.equals("2")) {
            eleccion = sc.nextLine();
            if (!eleccion.equals("1") && !eleccion.equals("2")) {
                System.out.println("Opción no válida. Por favor, introduce 1 o 2.");
            }
        } 
        if(eleccion.equals("1")) {
        	protagonista.setVida(protagonista.getVida()-10);
        	System.out.println();
        } else if (eleccion.equals("2")) {
        	protagonista.setVida(protagonista.getVida()+10);
        	System.out.println();
        }
	}

	private void escenaDabra(){
	    System.out.println("\n⚔️ Dabra, celoso de tu poder, aparece dispuesto a enfrentarte.");
	    System.out.println("¿Combatir con Dabra?");
	    System.out.println("1. Sí, lucharé contra él");
	    System.out.println("2. No, lo ignoro y ahorro energía");
	    
	    String eleccion = "";
	    while (!eleccion.equals("1") && !eleccion.equals("2")) {
	        eleccion = sc.nextLine();
	        if (!eleccion.equals("1") && !eleccion.equals("2")) {
	            System.out.println("Opción no válida. Por favor, introduce 1 o 2.");
	        }
	    }
	    
//	    if (eleccion.equals("1")) {
//	    	minijuegoCombateDabra();
//	    } else {
//	    	protagonista.setVida(protagonista.getVida() + 10);
//	        System.out.println(" Ignoras a Dabra y aprovechas para recuperar 10 de vida. Vida actual: " + protagonista.getVida());
//	    }
//	    }
//	  escenaCombateGohan();  
	}
	
	private void escenaCombateGohan(){
		
	}
	
	//IGNORAS A BABIDI -- RAMA PACIFICA
	private void ramaPacifica() {
		 
	 }
}
