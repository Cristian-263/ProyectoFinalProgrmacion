package modelo;


import java.sql.SQLException;
import java.util.List;

public class Juego {

    private List<Protagonista> personajesProtagonistas;
    private List<PersonajeSecundario> personajesSecundarios;
    private List<PersonajeCombatiente> personajesEnemigos;
 
    
 
  
    public Juego() {
        
    }
    
 // Asignamos los datos cargados en DatosJuego
    public void inicializar() {
        personajesProtagonistas = DatosJuego.protagonistas;
        personajesSecundarios = DatosJuego.secundarios;
        personajesEnemigos = DatosJuego.enemigos;
    }

    // IMPRIMIR PROTAGONISTAS
    public void mostrarProtagonistas() {
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
    public void mostrarSecundarios() {
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
    public void mostrarEnemigos() {
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
