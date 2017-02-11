/**
 * 
 * @author 
 *
 */
public final class Naves {

	private static final Naves nave = new Naves();
	private int vidas;

	/**
	 * Constructor privado para prohibir la generacion de instancias nuevas
	 */
	private Naves() {
		vidas = 10;
	}

	/**
	 * Metodo que retorna la unica instancia generada en esta clase
	 * 
	 * @return instancia unica
	 */
	public static Naves instanciaNave() {
		return nave;
	}
	
	/**
	 * incremento de la vida
	 */
	public void crearVida(){
		vidas++;
	}
	
	/**
	 * decremento de la vida
	 */
	public void eliminarVida(){
		vidas--;
	}

	/**
	 * obtiene las vidas como valor entero
	 * @return
	 * numero de vidas
	 */
	public int getVidas() {
		return vidas;
	}

	/**
	 * asigna vidas
	 * @param vidas
	 * vida de la nave
	 */
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	
}