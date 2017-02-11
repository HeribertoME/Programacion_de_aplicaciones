package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author heriberto
 *
 */
public class GestionUsuario {
	private Statement st;
	private ResultSet rs;
	
	/**
	 * Metodo que inserta usuario en la base de datos
	 * @param cn Es la nstancia de  la conexion
	 * @param user Es el nombre del usuario a ingresar
	 * @param pass Es el password del usuario a ingresar
	 * @return 1 si se ingresa correctamente, 0 si falla el registro
	 */
	public int insertarUsuario(Connection cn, String user, String pass){
		String sql = "INSERT INTO usuario VALUES(null,'"+user+"','"+pass+"')";
		try{
			st = cn.createStatement();
			st.executeUpdate(sql);
			return 1;
		}catch (SQLException e){
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Metodo que realiza la consulta de usuarios en la base de datos
	 * @param cn Es la instancia de la conexion
	 * @param user Es el nombre del usuario que se va a consultar
	 * @return rs  ResultSet con el resultado de la consulta
	 */
	public ResultSet consulta(Connection cn, String user){
		String sql = "SELECT*FROM usuario WHERE nomUsu='"+user+"'";
		try{
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			return rs;			
		} catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
}
