package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Contacto implements Agenda {
	
	private Statement st;
	private ResultSet rs;

	@Override
	public int actions(Connection cn, String sql) {
		
		try {
			st = cn.createStatement();
			st.execute(sql);
			System.out.println("Exito");
			return 1;
		} catch (Exception e) {
			System.out.println("Falló"+e.getMessage());
			return 0;			
		}				
	}

	@Override
	public ResultSet consulta(Connection cn, String sql) {
		try {
		st = cn.createStatement();
		rs = st.executeQuery(sql);		
		return rs;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
}
