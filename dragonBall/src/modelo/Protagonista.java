package modelo;

import java.util.List;

public class Protagonista extends PersonajeCombatiente {

    
    
    
    //Constructor
    public Protagonista() {
    }

    public Protagonista(String nombre, int vida, List<Ataque> listaAtaques) {
        super(nombre, vida, listaAtaques); 
        
    }
    

}
