package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	public Connection obtenerConexion(){
		try{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/agenda";
		Connection cn = DriverManager.getConnection(url, "root", "");
		return cn;
		}
		catch (Exception e){
			return null;			
		}
	}

}
