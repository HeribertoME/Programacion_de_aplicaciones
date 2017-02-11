package modelo;

public class Circulo implements Figuras {

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
	@Override
	public double perimetro(int l1, int base, int altura, int l1t, int l2t, int l3t, int d) {
		double pi = 3.141592;
		return d * pi;
	}
	
	/**
	 * @param l1 Parámetro que define el lado del cuadrado
	 * @param base Parámetro que define la base del rectangulo o del triángulo
	 * @param altura Parámetro que define la altura del rectángulo o del triángulo
	 * @param r Parámetro que define el radio del circulo
	 * @return Retorna ((r**r) * pi) que es el area del circulo
	 */
	@Override
	public double area(int l1, int base, int altura, int r) {
		double pi = 3.141592;
		return ((r*r) * pi);
	}

}
