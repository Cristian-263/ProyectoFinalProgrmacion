package modelo;

import daoDragonBall.*;

import java.sql.*;
import java.util.List;

public class DatosJuego {

    public static List<Protagonista> protagonistas;
    public static List<PersonajeCombatiente> enemigos;
    public static List<PersonajeSecundario> secundarios;

    public static List<CondicionAtmosferica> condicionesAtmosfericas;
    public static List<TipoTerreno> tiposTerreno;
    public static List<MomentoDia> momentosDia;

    public static void cargarDatos() throws SQLException {
        
        DaoPersonaje daoPersonaje = DaoPersonaje.getInstance();
        protagonistas = daoPersonaje.obtenerProtagonistas();
        enemigos = daoPersonaje.obtenerEnemigos();
        secundarios = daoPersonaje.obtenerSecundarios();
        condicionesAtmosfericas = DaoCondicionAtmosferica.getInstance().obtenerCondicionAtmosferica();
        tiposTerreno = DaoTipoTerreno.getInstance().obtenerTipoTerreno();
        momentosDia = DaoMomentoDia.getInstance().obtenerMomentoDia();
    }
}
