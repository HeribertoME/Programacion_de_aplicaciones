/**
 * 
 * @author Heriberto Martinez Elizarraraz 
 *
 */
public class AppPerimetros {
	/**
	 * 
	 * @param args Parametro del metodo main (principal)
	 * En este método se crea un objeto p de la clase 
	 * Perimetros y se muestra en consola
	 */
	public static void main(String[] args) {
		Perimetros p = new Perimetros();
		System.out.printf("El perimetro del cuadrado es: %d",
				p.cuadrado(10));
	}
}
