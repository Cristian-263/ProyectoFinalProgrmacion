package daoDragonBall;

import modelo.CondicionAtmosferica;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoCondicionAtmosferica {

	private Connection conn;

	public DaoCondicionAtmosferica() throws SQLException {
		conn = DBConnection.getConnection();
	}
	
	public List<CondicionAtmosferica> obtenerCondicionAtmosferica() throws SQLException{
		List<CondicionAtmosferica> lista = new ArrayList<>();
		
        String sql = "SELECT id, nombre FROM condiciones_atmosfericas";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        
        while(rs.next()) {
        	int id = rs.getInt("id");
        	String nombre = rs.getString("nombre");
        	lista.add(new CondicionAtmosferica(id, nombre));
        }
        rs.close();
        statement.close();
        return lista;
	}

}
