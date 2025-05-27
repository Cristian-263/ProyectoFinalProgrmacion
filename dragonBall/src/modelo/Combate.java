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

	public void turnoProtagonista() {
		System.out.println("\n Es tu turno ---");
		System.out.println("Vida actual del enemigo: " + enemigo.getVida());
	}

	public void turnoEnemigo() {
		System.out.println("\n--- Turno de " + enemigo.getNombre() + " ---");
		System.out.println("Vida actual del jugador: " + protagonista.getVida());
	}
}
