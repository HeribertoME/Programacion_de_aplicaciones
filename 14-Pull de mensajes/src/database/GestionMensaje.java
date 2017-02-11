package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 
 * @author heriberto
 *
 */
public class GestionMensaje {
	private Statement st;
	private ResultSet rs;
	
	/**
	 * 
	 * @param con Es la instancia de la conexion
	 * @param mensaje Es el mensaje a enviar a la base de datos
	 * @param id Es el id del usuario activo
	 * @return 1 si se guarda con exito en la bd, 0 si hay error
	 */
	public int insertMsj(Connection con, String mensaje, int idUsu){
		String sql = "INSERT INTO mensaje VALUES(null,curdate(), curtime(),'"+mensaje+"',"+idUsu+")";
		try{
			st = con.createStatement();
			st.executeUpdate(sql);
			System.out.println("Exito");
			return 1;
		} catch (Exception e){
			System.out.println(e.getMessage());
			return 0;
		}
	}
	
	/**
	 * 
	 * @param con La instancia de la conexion
	 * @return rs con el resultado de la consulta
	 */
	public ResultSet consulta(Connection con){
		String sql = "SELECT idMensaje,"
				+ "date_format(fecha,'%d   %M    %Y'),"
				+ "hora,"
				+ "msj,"
				+ "nomUsu FROM mensaje INNER JOIN usuario ON usuario.idUsu=mensaje.idUsu";
		try{
			st = con.createStatement();
			rs = st.executeQuery(sql);
			//System.out.println(rs);
			return rs;
		}catch(Exception e){
			System.out.println("Falló la consulta "+e.getMessage());
			return null;
		}
	}
	
	public ResultSet consultaMensaje(Connection cn, String id){
		String sql = "SELECT msj FROM mensaje where idMensaje='"+id+"'";
		try{
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			return rs;
		}catch(Exception e){
			System.out.println("Falló la consulta " + e.getMessage());
			return null;
		}
	}

}
