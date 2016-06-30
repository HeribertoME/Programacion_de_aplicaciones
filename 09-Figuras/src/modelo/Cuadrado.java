package modelo;

public class Cuadrado implements Figuras {
	
	/**
	 * @param l1 Parámetro que define el lado del cuadrado
	 * @param base Parámetro que define la base del rectangulo
	 * @param altura Parámetro que define la altura del rectángulo
	 * @param l1t Parámetro que define el lado 1 del triángulo
	 * @param l2t Parámetro que define el lado 2 del triángulo
	 * @param l3t Parámetro que define el lado 3 del triángulo
	 * @param d Parámetro que defin el diametro del circulo
	 * @return Retorna l1 + l1 + l1 + l1 que es el perimetro del cuadrado
	 */
	@Override
	public double perimetro(int l1, int base, int altura, int l1t, int l2t, int l3t, int d) {
		return l1 + l1 + l1 +l1;
	}

	/**
	 * @param l1 Parámetro que define el lado del cuadrado
	 * @param base Parámetro que define la base del rectangulo o del triángulo
	 * @param altura Parámetro que define la altura del rectángulo o del triángulo
	 * @param r Parámetro que define el radio del circulo
	 * @return Retorna l1 * l1 que es el area del cuadrado
	 */
	@Override
	public double area(int l1, int base, int altura, int r) {
		return l1 * l1;
	}

}
