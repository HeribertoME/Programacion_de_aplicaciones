import java.sql.SQLException;

import Vista.VentanaAgenda;

/**
 * 
 */

/**
 * @author heriberto Martinez
 *
 */
public class AppAgenda {

	/**
	 * @param args Parametro para llamar la vista de la clase VentanaAgenda
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		VentanaAgenda vtn = new VentanaAgenda();
		vtn.setVisible(true);
	}

}
