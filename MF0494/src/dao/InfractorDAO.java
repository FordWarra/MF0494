/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.ConexionBD;
import modelo.Infractor;

/**
 * @author David
 * Clase que implementa un CRUD de la base batos
 * (Create, Read, update y delete)
 */
public class InfractorDAO {

	private ConexionBD conexion;
	
    public InfractorDAO() {
        this.conexion = new ConexionBD();
    }


    public ArrayList<Infractor> obtenerInfractor() {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		Statement consulta = null;
		ResultSet resultado = null;
		ArrayList<Infractor> lista = new ArrayList<Infractor>();
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from infractores");
			
			// Bucle para recorrer todas las filas que devuelve la consulta
			while(resultado.next()) {
				
				String dni = resultado.getString("dni");
				String nombre = resultado.getString("nombre");
				String apellidos = resultado.getString("apellidos");
				int antiguedad = resultado.getInt("antiguedad");
				float sancion = resultado.getFloat("sancion");
				int puntos = resultado.getInt("puntos");
				
				Infractor i = new Infractor(dni, nombre, apellidos, antiguedad, sancion, puntos);
				lista.add(i);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre infractores: "+e.getMessage());
		} finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return lista;
    }

    
    

    public Infractor obtenerInfractor(String dni) {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Infractor i = null;
		
		try {
			consulta = con.prepareStatement("select * from infractores"
					+ " where dni = ?");
			consulta.setString(1, dni);
			resultado=consulta.executeQuery();
			
			// Bucle para recorrer todas las filas que devuelve la consulta
			if (resultado.next()) {
				
				String nombre = resultado.getString("nombre");
				String apellidos = resultado.getString("apellidos");
				int antiguedad = resultado.getInt("antiguedad");
				float sancion = resultado.getFloat("sancion");
				int puntos = resultado.getInt("puntos");
				
				i = new Infractor(dni, nombre, apellidos, antiguedad, sancion, puntos);
				
			}
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre un infractor: "
		         +e.getMessage());
		} finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return i;
    }


    public int insertarInfractor(Infractor i) {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		int resultado=0;
		
		try {
			consulta = con.prepareStatement("INSERT INTO infractores(dni, nombre, apellidos, antiguedad, sancion, puntos) \r\n"
					+ "VALUES\r\n"
					+ "(?,?,?,?,?,?)");
			
			consulta.setString(1, i.getDni());
			consulta.setString(2, i.getNombre());
			consulta.setString(3, i.getApellidos());
			consulta.setInt(4, i.getAntiguedad());
			consulta.setFloat(5, i.getSancion());
			consulta.setInt(6, i.getPuntos());
			
			resultado=consulta.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar la inserción de un infractor: "
		        +e.getMessage());
		} finally {
			try {
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return resultado;
    }
    
  
}
