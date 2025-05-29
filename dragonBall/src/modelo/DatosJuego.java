package modelo;

import daoDragonBall.*;

import java.sql.*;
import java.util.ArrayList;


public class DatosJuego {

    public static ArrayList<Protagonista> protagonistas;
    public static ArrayList<PersonajeCombatiente> enemigos;
    public static ArrayList<PersonajeSecundario> secundarios;

    public static ArrayList<CondicionAtmosferica> condicionesAtmosfericas;
    public static ArrayList<TipoTerreno> tiposTerreno;
    public static ArrayList<MomentoDia> momentosDia;

    public  void cargarDatos() throws SQLException {

    	protagonistas = new ArrayList<>(DaoPersonaje.getInstance().obtenerProtagonistas());
    	enemigos = new ArrayList<>(DaoPersonaje.getInstance().obtenerEnemigos());
    	secundarios = new ArrayList<>(DaoPersonaje.getInstance().obtenerSecundarios());
    	condicionesAtmosfericas = new ArrayList<>(DaoCondicionAtmosferica.getInstance().obtenerCondicionAtmosferica());
    	tiposTerreno = new ArrayList<>(DaoTipoTerreno.getInstance().obtenerTipoTerreno());
    	momentosDia = new ArrayList<>(DaoMomentoDia.getInstance().obtenerMomentoDia());
    }
}
