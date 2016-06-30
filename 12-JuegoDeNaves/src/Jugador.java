/**
 * 
 * @author heriberto
 *
 */
public class Jugador {
	
	Naves n1 = Naves.instanciaNave();
	
	/**
	 * Constructor vacio para evitar inyeccion de codigo
	 */
	public Jugador(){}
	
	/**
	 * Elimina una vida de la nave
	 */
	public void eliminarNave(){
		n1.eliminarVida();
	}

}
