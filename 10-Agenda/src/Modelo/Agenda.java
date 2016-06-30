package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;

public interface Agenda {	
	
	/**
	 * 
	 * @param cn
	 * @param sql
	 * @return
	 */
	public int actions (Connection cn, String sql);
	
	/**
	 * 
	 * @param cn
	 * @param sql
	 * @return
	 */
	public ResultSet consulta(Connection cn, String sql);
		
}
