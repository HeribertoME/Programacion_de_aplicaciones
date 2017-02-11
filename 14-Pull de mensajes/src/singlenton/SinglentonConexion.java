package singlenton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class SinglentonConexion {
	
	private static final SinglentonConexion con = new SinglentonConexion();
	private String nombreBD;
	private String user;
	private String pass;
	private String url;
	
	/**
	 * Constructor de la clase
	 */
	private SinglentonConexion(){
		nombreBD = "pull";
		user = "root";
		pass = null;
		url = "jdbc:mysql://localhost/"+nombreBD;
	}
	
	/**
	 * Metodo de instanciamiento unico
	 * 
	 * @return instancia unica
	 */
	public static SinglentonConexion instanciaCon(){
		return con;
	}
	
	/**
	 * Metodo que realiza la conexion a la BD
	 */
	public Connection getConnection(){
		try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection c = DriverManager.getConnection(url, user, pass);
		//System.out.println("Conexión realizada");
		return c;
		} catch (ClassNotFoundException e){
			System.out.println("No se encontró la clase Driver");			
		} catch (SQLException e){
			System.out.println("No se pudo conectar a la base");
		} catch (InstantiationException e) {
			System.out.println("No se pudo instanciar la clase");
		} catch (IllegalAccessException e){
			System.out.println("Acceso no permitido a la base de datos");
		}
		return null;
	}
}
