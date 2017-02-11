/**
 * 
 * @author heriberto
 *
 */
public class Computadora {
	
	Naves n1 = Naves.instanciaNave();
	
	/**
	 * Constructor vacio para evitar inyeccion de codigo
	 */
	public Computadora(){}
	
	/**
	 * Crea una vida de la nave
	 */
	public void crearNave(){
		n1.crearVida();
	}

}
