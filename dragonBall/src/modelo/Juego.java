package modelo;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Juego {

    private ArrayList<Protagonista> personajesProtagonistas;
    private ArrayList<PersonajeSecundario> personajesSecundarios;
    private ArrayList<PersonajeCombatiente> personajesEnemigos;
 
    
 
  
    public Juego() {
        
    }
    
 // Asignamos los datos cargados en DatosJuego
    public void inicializar() {
        personajesProtagonistas = DatosJuego.protagonistas;
        personajesSecundarios = DatosJuego.secundarios;
        personajesEnemigos = DatosJuego.enemigos;
    }
    
    
    private Protagonista buscarProtagonistaPorNombre(String nombre) {
        for (Protagonista prota : DatosJuego.protagonistas) {
            if (prota.getNombre().equalsIgnoreCase(nombre)) {
                return prota;
            }
        }
        return null;
    }
    
    public Protagonista elegirProtagonistaInicial() {
        Scanner sc = new Scanner(System.in);
        Protagonista protagonista = null;
        boolean valido = false;

        while (!valido) {
            System.out.println("Elige tu personaje para comenzar la aventura:");
            System.out.println("1. Goku");
            System.out.println("2. Vegeta");
            System.out.println("3. Majin Boo");

            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    protagonista = buscarProtagonistaPorNombre("Goku");
                    valido = true;
                    break;
                case 2:
                    protagonista = buscarProtagonistaPorNombre("Vegeta");
                    valido = true;
                    break;
                case 3:
                    protagonista = buscarProtagonistaPorNombre("Majin Boo");
                    valido = true;
                    break;
                default:
                    System.out.println("❌ Opción inválida. Por favor, elige 1, 2 o 3.");
            }
        }

        System.out.println("✅ Has elegido a: " + protagonista.getNombre());
        return protagonista;
    }


    // IMPRIMIR PROTAGONISTAS
    public void imprimirProtagonistas() {
        System.out.println("=== PROTAGONISTAS ===");
        for (Protagonista prota : personajesProtagonistas) {
            System.out.println("Nombre: " + prota.getNombre());
            System.out.println("Vida: " + prota.getVida());
            System.out.println("Ataques:");
            for (Ataque ataque : prota.getAtaque()) {
                System.out.println("- " + ataque.getNombre());
            }
            System.out.println("---------------------------");
        }
    }

    // IMPRIMIR SECUNDARIOS
    public void imprimirSecundarios() {
        System.out.println("=== PERSONAJES SECUNDARIOS ===");
        for (PersonajeSecundario secundario : personajesSecundarios) {
            System.out.println("Nombre: " + secundario.getNombre());
            System.out.println("Vida: " + secundario.getVida());
            System.out.println("Ataques:");
            for (Ataque ataque : secundario.getAtaque()) {
                System.out.println("- " + ataque.getNombre());
            }
            System.out.println("---------------------------");
        }
    }

    // IMPRIMIR ENEMIGOS
    public void imprimirEnemigos() {
        System.out.println("=== ENEMIGOS ===");
        for (PersonajeCombatiente enemigo : personajesEnemigos) {
            System.out.println("Nombre: " + enemigo.getNombre());
            System.out.println("Vida: " + enemigo.getVida());
            System.out.println("Ataques:");
            for (Ataque ataque : enemigo.getAtaque()) {
                System.out.println("- " + ataque.getNombre());
            }
            System.out.println("---------------------------");
        }
    }
}
