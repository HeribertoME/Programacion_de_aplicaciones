import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * 
 * @author heriberto
 *
 */
public final class Conexion {
	
	private static final Conexion con = new Conexion();
	private String nombreBD;
	private String user;
	private String pass;
	private String url;
	
	/**
	 * Constructor
	 */
	private Conexion(){
		nombreBD = "pull";
		user = "root";
		pass = null;
		url = "jdbc:mysql://localhost/"+nombreBD;
	}
	
	/**
	 * Metodo que retorna la unica instancia generada en esta clase
	 * 
	 * @return instancia unica
	 */
	public static Conexion instanciaConexion (){
		return con;
	}
	
	/**
	 * Metodo de conexion
	 */
	public Connection conectar(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection c = DriverManager.getConnection(url,user,pass);
			JOptionPane.showMessageDialog(null,
					"Conexi�n exitosa",
					"�xito",
					JOptionPane.INFORMATION_MESSAGE);
			return c;
		} catch (ClassNotFoundException e){
			JOptionPane.showMessageDialog(null, 
					"No se encontr� la clase Driver\n "+e,
					"Error",
					JOptionPane.ERROR_MESSAGE);			
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, 
					"No se pud� conectar a la base\n "+e,
					"Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (InstantiationException e) {
			JOptionPane.showMessageDialog(null, 
					"No se pud� instanciar la clase\n "+e,
					"Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (IllegalAccessException e){
			JOptionPane.showMessageDialog(null, 
					"Acceso no permitido a la base de datos\n "+e,
					"Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	
}
