package modelo;

import java.util.Scanner;

public class Combate {

	private Protagonista protagonista;
	private PersonajeCombatiente enemigo;
	private CondicionAtmosferica condicionAtmos;
	private TipoTerreno terreno;
	private MomentoDia momentoDia;

	// Constructor
	public Combate(Protagonista protagonista, PersonajeCombatiente enemigo) {
		this.protagonista = protagonista;
		this.enemigo = enemigo;
		this.condicionAtmos = DatosJuego.condicionesAtmosfericas.get((int) (Math.random() * DatosJuego.condicionesAtmosfericas.size()));
		this.terreno = DatosJuego.tiposTerreno.get((int) (Math.random() * DatosJuego.tiposTerreno.size()));
		this.momentoDia = DatosJuego.momentosDia.get((int) (Math.random() * DatosJuego.momentosDia.size()));
	}

	private int calcularBonusAtaque() {
		return condicionAtmos.getBonusAtaque() + terreno.getBonusAtaque() + momentoDia.getBonusAtaque();
	}

	private int calcularBonusDefensa() {
		return condicionAtmos.getBonusDefensa() + terreno.getBonusDefensa() + momentoDia.getBonusDefensa();
	}

	public String determinarTipoImpacto() {
		int random = (int) (Math.random() * 100) + 1;

		if (random <= 60) {
			return "total";
		} else if (random <= 90) {
			return "parcial";
		} else {
			return "fallo";
		}
	}

	private int obtenerDanhoPorImpacto(Ataque ataque) {
		String tipoImpacto = determinarTipoImpacto();

		switch (tipoImpacto.toLowerCase()) {
			case "total":
				return ataque.getDanho_total();
			case "parcial":
				return ataque.getDanho_parcial();
			case "fallo":
				return ataque.getDanho_fallo();
			default:
				System.out.println("Tipo de impacto inválido");
				return 0;
		}
	}

	private Ataque elegirAtaqueJugador() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Elige un ataque");

		for (int i = 0; i < protagonista.getAtaque().size(); i++) {
			Ataque ataque = protagonista.getAtaque().get(i);
			System.out.println(i + ". " + ataque.getNombre());
		}

		int eleccion = -1;
		boolean valido = false;

		if (sc.hasNextInt()) {
			eleccion = sc.nextInt();
			sc.nextLine();

			if (eleccion >= 0 && eleccion < protagonista.getAtaque().size()) {
				valido = true;
			} else {
				System.out.println("Número fuera de rango.");
			}

		} else {
			System.out.println("Entrada inválida. Intenta de nuevo.");
			sc.nextLine();
		}

		return protagonista.getAtaque().get(eleccion);
	}

	private Ataque elegirAtaqueAleatorio(PersonajeCombatiente enemigo) {
		int numAtaques = enemigo.getAtaque().size();
		int random = (int) (Math.random() * numAtaques);
		return enemigo.getAtaque().get(random);
	}

	public int calcularDanhoTotal(Ataque ataque) {
		int danhoBase = obtenerDanhoPorImpacto(ataque);
		int bonusAtaque = calcularBonusAtaque();
		int danhoFinal = danhoBase + bonusAtaque;

		System.out.println("Daño base: " + danhoBase + " | Bonus ataque: " + bonusAtaque);
		System.out.println("Daño final infligido: " + Math.max(0, danhoFinal));

		return Math.max(0, danhoFinal);
	}

	public void testCalculoDanhoJugador() {
		Ataque ataqueElegido = elegirAtaqueJugador();
		int danhoFinal = calcularDanhoTotal(ataqueElegido);

		System.out.println("=== Resultado de prueba ===");
		System.out.println("Ataque usado: " + ataqueElegido.getNombre());
		System.out.println("Daño final calculado: " + danhoFinal);
	}
	
	//CALCULAR ATAQUE - DEFENSA
	private int calcularDanhoNeto(int danhoBase, int bonusAtaque, int bonusDefensa) {
	    int danhoNeto = danhoBase + bonusAtaque - bonusDefensa;
//	    if (danhoNeto < 0) {
//	        return 0;
//	    } else {
//	        return danhoNeto;
//	    }
	    return Math.max(0, danhoNeto);  
	}

	//RESTAR VIDA
	private void restarVida(PersonajeCombatiente defensor, int danho) {
	    int vidaActual = defensor.getVida();
	    int vidaRestante;

	    if (vidaActual - danho < 0) {
	        vidaRestante = 0;
	    } else {
	        vidaRestante = vidaActual - danho;
	    }

	    defensor.setVida(vidaRestante);
	    System.out.println(defensor.getNombre() + " ha recibido " + danho + " de daño. Vida restante: " + vidaRestante);
	}

	//ATACA EL RPOTAGONISTA
	public void turnoProtagonista() {
		System.out.println("\n Es tu turno ---");
		System.out.println("Vida actual del enemigo: " + enemigo.getVida());
		//El jugador escoge ataque.
		Ataque ataque = elegirAtaqueJugador();
		//Se determina si impacta total, parcial o fallo.
		int danhoBase = obtenerDanhoPorImpacto(ataque);
		//Se suman bonus del entorno.
	    int bonusAtaque = calcularBonusAtaque();
	    
	    int bonusDefensa = calcularBonusDefensa();
	    //Calculamos el daño neto y se aplica al enemigo.
	    int danhoFinal = calcularDanhoNeto(danhoBase, bonusAtaque, bonusDefensa);
	    //Se imprime resultado.
	    restarVida(enemigo, danhoFinal);
	}

	//ATACA EL ENEMIGO(AUTOMÁTICO)
	public void turnoEnemigo() {
		System.out.println("\n--- Turno de " + enemigo.getNombre() + " ---");
		System.out.println("Vida actual del jugador: " + protagonista.getVida());
		 // 1. Elegir ataque aleatorio del enemigo
	    Ataque ataque = elegirAtaqueAleatorio(enemigo);

	    // 2. Calcular daño base por impacto
	    int danhoBase = obtenerDanhoPorImpacto(ataque);

	    // 3. Calcular bonificaciones del entorno
	    int bonusAtaque = calcularBonusAtaque();
	    int bonusDefensa = calcularBonusDefensa();

	    // 4. Calcular daño neto
	    int danhoFinal = calcularDanhoNeto(danhoBase, bonusAtaque, bonusDefensa);

	    // 5. Aplicar daño al protagonista
	    restarVida(protagonista, danhoFinal);
	}
	
	//IMPRIMIR VIDA AMBOS
	private void imprimirVida() {
	    System.out.println("\n====== ESTADO ACTUAL ======");
	    System.out.println(protagonista.getNombre() + " - Vida: " + protagonista.getVida());
	    System.out.println(enemigo.getNombre() + " - Vida: " + enemigo.getVida());
	    System.out.println("===========================\n");
	}
	
	//MÉTODO PARA COMPROBAR VIDAS
	private boolean finCombate() {
	    if (protagonista.getVida() <= 1) {
	        return true;
	    }
	    if (enemigo.getVida() <= 1) {
	        return true;
	    }
	    return false;
	}
	
	//COMBATE 
	public void combatir() {
	    System.out.println("\n🔥 ¡Comienza el combate!");
	    System.out.println("Entorno: " + condicionAtmos.getNombre() + ", " +
	                       terreno.getNombre() + ", " +
	                       momentoDia.getNombre());

	    // Bucle del combate: se ejecuta mientras ambos estén vivos
	    while (!finCombate()) {
	        imprimirVida();

	        // Turno del jugador
	        turnoProtagonista();

	        // Solo se ejecuta el turno del enemigo si aún sigue el combate
	        if (!finCombate()) {
	            turnoEnemigo();
	        }
	    }

	    if (protagonista.getVida()<=0) {
	    	System.out.println(enemigo.getNombre()+" te ha derrotado");
	    } else {
	    	System.out.println("Has derrotado a " + enemigo.getNombre());
	    }
	    
	}



}
