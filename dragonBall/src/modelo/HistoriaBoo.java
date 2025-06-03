package modelo;

import java.util.Scanner;

public class HistoriaBoo {

	private Protagonista protagonista;
	private Juego juego;
	private int puntuacionUsuario;
	private Scanner sc = new Scanner(System.in);

	public HistoriaBoo(Protagonista protagonista, Juego juego) {
		this.protagonista = protagonista;
		this.juego = juego;
		this.puntuacionUsuario = 0;
	}

	public void iniciar() {
		escenaInicialBoo();
		decision1();

	}

	// ESCENA INICIAL DE LA HISTORIA DE BOO
	private void escenaInicialBoo() {
		System.out.println("🌪️ Majin Boo se despierta tras siglos de encierro...");
		System.out.println(
				"""
						Durante años, el universo ha respirado en paz...
						pero esa paz está a punto de romperse.
						Desde lo más profundo del abismo mágico, un ser de poder ilimitado abre sus ojos por primera vez en milenios.
						Majin Boo, una criatura tan impredecible como destructiva, ha despertado bajo las órdenes del malvado Babidi.
						¿Seguirás sus mandatos sin cuestionarlos... o forjarás tu propio destino?
						El universo contiene el aliento. La historia de Boo comienza...
						""");
	}

	// DECISION 1: BABIDI
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

	// OBEDECES A BABIDI -- RAMA DESTRUCTORA
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
		if (eleccion.equals("1")) {
			protagonista.setVida(protagonista.getVida() - 10);
			System.out.println("Destruyes la ciudad desde el cielo, para lo cual usas demasiada energía.\n"
					+ "Pierdes 10 puntos de vida. Vida actual: " + protagonista.getVida());
			escenaDabra();
		} else if (eleccion.equals("2")) {
			protagonista.setVida(protagonista.getVida() + 10);
			System.out.println("Caminas por la ciudad destruyendo edificios y devorando chocolatinas (lo que antes eran habitantes)\n"
					+ "Ganas 10 puntos de vida");
			escenaDabra();
		}
	}

	private void escenaDabra() {
		System.out.println("\n⚔️ Dabra, celoso de tu poder, aparece dispuesto a enfrentarte.");
		System.out.println("¿Combatir con Dabra?");
		System.out.println("1. Sí, lucharé contra él");
		System.out.println("2. No, lo ignoro y ahorro energía");

		String eleccion = "";
		while (!eleccion.equals("1") && !eleccion.equals("2")) {
			System.out.println("Opción no válida. Por favor, introduce 1 o 2.");
			eleccion = sc.nextLine();
			if (!eleccion.equals("1")) {
				Minijuegos minijuego = new Minijuegos();
				boolean victoria = minijuego.piedraPapelTijerasZ();
				if (victoria) {
					protagonista.setVida(protagonista.getVida() + 5);
					puntuacionUsuario = +10;
					System.out.println("¡Has ganado el combate contra Dabra! Ganas 10 de vida. Vida actual: "
							+ protagonista.getVida());
					System.out
							.println("Has ganado 10 puntos de partida. Puntuación de la partida: " + puntuacionUsuario);
				} else {
					protagonista.setVida(protagonista.getVida() - 5);
					puntuacionUsuario = -10;
					System.out.println("Has perdido el combate con Dabra. Pierdes 10 puntos de vida");
					System.out.println(
							"Has perdido 10 puntos de partida. Puntuación de la partida: " + puntuacionUsuario);
				}

			} else {
		        protagonista.setVida(protagonista.getVida() + 15);
		        System.out.println("Ignoras a Dabra y aprovechas para recuperar 15 de vida. Vida actual: " 
		                           + protagonista.getVida());
			}
			
		}
		obedecerABabidi();

	}
	
	private void obedecerABabidi() {
		
		escenaCombateGohan();
	}

	private void escenaCombateGohan() {
	    System.out.println("Desde lejos, Gohan percibe una oleada de ki inmenso…");
	    System.out.println("""
	Gohan corre a toda velocidad, preocupado. Siente el poder de Majin Boo creciendo con cada paso.
	Su determinación arde: “No permitiré que este monstruo destruya más inocentes”.
	Ahora, Gohan aparece frente a ti, serio y firme, preparado para proteger la Tierra.

	Gohan: “¡Boo! He venido a detenerte. ¡No tendrás oportunidad!”
	""");
	    
	    PersonajeCombatiente gohan = juego.buscarEnemigoPorNombre("Gohan");
	    if (gohan == null) {
	        System.out.println("⚠️ ¡Error: Gohan no está entre los enemigos registrados!");   
	    }
	    Combate combate = new Combate(protagonista, gohan, juego);
	    combate.combatir();
	    if (protagonista.getVida() <= 0) {
	        System.out.println("\n Majin Boo ha sido derrotado por Gohan. Fin de la historia destructora.");
	    } else {
	        System.out.println("\n ¡Has derrotado a Gohan! Puedes moverte al siguiente paso.");
	        escenaAbsorberBabidi();
	}
	}

	private void escenaAbsorberBabidi() {
		
		
	}

	// IGNORAS A BABIDI -- RAMA PACIFICA
	private void ramaPacifica() {

	}
}
