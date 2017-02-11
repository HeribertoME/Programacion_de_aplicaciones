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
	private Connection c = null;

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
			// Driver JDBC
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			c = DriverManager.getConnection(url,user,pass);
		} catch (ClassNotFoundException e){
			JOptionPane.showMessageDialog(null,
					"No se encontró la clase Driver\n " + e,
					"Error",
					JOptionPane.ERROR_MESSAGE);
					c = null;
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null,
					"No se pudó conectar a la base\n " + e,
					"Error",
					JOptionPane.ERROR_MESSAGE);
					c = null;
		} catch (InstantiationException e) {
			JOptionPane.showMessageDialog(null,
					"No se pudó instanciar la clase\n " + e,
					"Error",
					JOptionPane.ERROR_MESSAGE);
					c = null;
		} catch (IllegalAccessException e){
			JOptionPane.showMessageDialog(null,
					"Acceso no permitido a la base de datos\n " + e,
					"Error",
					JOptionPane.ERROR_MESSAGE);
					c = null;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Error en la conexion\n " + e,
					"Error",
					JOptionPane.ERROR_MESSAGE);
					c = null;
		} finally {
			JOptionPane.showMessageDialog(null,
					"Conexión exitosa",
					"Éxito",
					JOptionPane.INFORMATION_MESSAGE);
					return c;
		}
	}

}
