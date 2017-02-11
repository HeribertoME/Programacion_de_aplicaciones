package modelo;
/**
 * 
 * @author heriberto
 *
 */

public interface Figuras {
	
	/**
	 * @param l1 Parámetro que define el lado del cuadrado
	 * @param base Parámetro que define la base del rectangulo
	 * @param altura Parámetro que define la altura del rectángulo
	 * @param l1t Parámetro que define el lado 1 del triángulo
	 * @param l2t Parámetro que define el lado 2 del triángulo
	 * @param l3t Parámetro que define el lado 3 del triángulo
	 * @param d Parámetro que defin el diametro del circulo
	 * @return Retorna d * pi que es el perimetro del circulo
	 */
	public double perimetro (int l1, int base, int altura, int l1T, int l2T, int l3T, int d);
	
	/**
	 * @param l1 Parámetro que define el lado del cuadrado
	 * @param base Parámetro que define la base del rectangulo o del triángulo
	 * @param altura Parámetro que define la altura del rectángulo o del triángulo
	 * @param r Parámetro que define el radio del circulo
	 * @return Retorna ((r**r) * pi) que es el area del circulo
	 */
	public double area(int l1, int base, int altura, int r);

}
