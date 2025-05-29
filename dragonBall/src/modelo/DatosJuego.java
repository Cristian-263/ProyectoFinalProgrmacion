package modelo;

import daoDragonBall.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class DatosJuego {

    private ArrayList<Protagonista> protagonistas;
    private ArrayList<PersonajeCombatiente> enemigos;
    private ArrayList<PersonajeSecundario> secundarios;
    private ArrayList<CondicionAtmosferica> condicionesAtmosfericas;
    private ArrayList<TipoTerreno> tiposTerreno;
    private ArrayList<MomentoDia> momentosDia;

    // Constructor 
    public DatosJuego() {
        protagonistas = new ArrayList<>();
        enemigos = new ArrayList<>();
        secundarios = new ArrayList<>();
        condicionesAtmosfericas = new ArrayList<>();
        tiposTerreno = new ArrayList<>();
        momentosDia = new ArrayList<>();
    }

    // Método para cargar datos desde los DAOs
    public void cargarDatos() throws SQLException {
        protagonistas = new ArrayList<>(DaoPersonaje.getInstance().obtenerProtagonistas());
        enemigos = new ArrayList<>(DaoPersonaje.getInstance().obtenerEnemigos());
        secundarios = new ArrayList<>(DaoPersonaje.getInstance().obtenerSecundarios());
        condicionesAtmosfericas = new ArrayList<>(DaoCondicionAtmosferica.getInstance().obtenerCondicionAtmosferica());
        tiposTerreno = new ArrayList<>(DaoTipoTerreno.getInstance().obtenerTipoTerreno());
        momentosDia = new ArrayList<>(DaoMomentoDia.getInstance().obtenerMomentoDia());
    }

    // Getters y setters
    public ArrayList<Protagonista> getProtagonistas() {
        return protagonistas;
    }

    public ArrayList<PersonajeCombatiente> getEnemigos() {
        return enemigos;
    }

    public ArrayList<PersonajeSecundario> getSecundarios() {
        return secundarios;
    }

    public ArrayList<CondicionAtmosferica> getCondicionesAtmosfericas() {
        return condicionesAtmosfericas;
    }

    public ArrayList<TipoTerreno> getTiposTerreno() {
        return tiposTerreno;
    }

    public ArrayList<MomentoDia> getMomentosDia() {
        return momentosDia;
    }
}
