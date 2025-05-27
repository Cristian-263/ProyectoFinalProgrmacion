package daoDragonBall;

import java.sql.*;
import java.util.*;
import modelo.*;

public class DaoPersonaje {
    
    private Connection conn;

    public DaoPersonaje() throws SQLException {
        conn = DBConnection.getConnection();
    }
    
    public List<Protagonista> obtenerProtagonistas() throws SQLException {
        List<Protagonista> personajesProtagonistas = new ArrayList<>();

        String obtenerProtagonistas = "SELECT id, nombre, vida FROM personajes WHERE tipo = 'protagonista'";
        PreparedStatement statement = conn.prepareStatement(obtenerProtagonistas);
        ResultSet rs = statement.executeQuery();

        DaoAtaque daoAtaque = DaoAtaque.getInstance();

        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            int vida = rs.getInt("vida");

            List<Ataque> ataques = daoAtaque.obtenerAtaquesPorPersonaje(id);

            Protagonista protagonista = new Protagonista(nombre, vida, ataques);
            personajesProtagonistas.add(protagonista);
        }

        rs.close();
        statement.close();

        return personajesProtagonistas;
    }
    public List<PersonajeSecundario> obtenerSecundarios() throws SQLException {
        List<PersonajeSecundario> personajesSecundarios = new ArrayList<>();

        String obtenerPersonajesSecundarios = "SELECT id, nombre, vida FROM personajes WHERE tipo = 'personajeSecundario'";
        PreparedStatement statement = conn.prepareStatement(obtenerPersonajesSecundarios);
        ResultSet rs = statement.executeQuery();

        DaoAtaque daoAtaque = DaoAtaque.getInstance();

        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            int vida = rs.getInt("vida");

            List<Ataque> ataques = daoAtaque.obtenerAtaquesPorPersonaje(id);

            PersonajeSecundario secundario = new PersonajeSecundario(nombre, vida, ataques, new ArrayList<>());
            personajesSecundarios.add(secundario);
        }

        rs.close();
        statement.close();

        return personajesSecundarios;
    }
    
    public List<PersonajeCombatiente> obtenerEnemigos() throws SQLException {
        List<PersonajeCombatiente> personajesEnemigos = new ArrayList<>();

        String ontenerPersonajesEnemigos = "SELECT id, nombre, vida FROM personajes WHERE tipo = 'enemigo'";
        PreparedStatement statement = conn.prepareStatement(ontenerPersonajesEnemigos);
        ResultSet rs = statement.executeQuery();

        DaoAtaque daoAtaque = DaoAtaque.getInstance();

        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            int vida = rs.getInt("vida");

            List<Ataque> ataques = daoAtaque.obtenerAtaquesPorPersonaje(id);

            PersonajeCombatiente enemigo = new PersonajeCombatiente(nombre, vida, ataques);
            personajesEnemigos.add(enemigo);
        }

        rs.close();
        statement.close();

        return personajesEnemigos;
    }

}
