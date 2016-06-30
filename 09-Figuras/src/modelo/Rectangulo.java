package modelo;

public class Rectangulo implements Figuras {

	/**
	 * @param l1 Parámetro que define el lado del cuadrado
	 * @param base Parámetro que define la base del rectangulo
	 * @param altura Parámetro que define la altura del rectángulo
	 * @param l1t Parámetro que define el lado 1 del triángulo
	 * @param l2t Parámetro que define el lado 2 del triángulo
	 * @param l3t Parámetro que define el lado 3 del triángulo
	 * @param d Parámetro que defin el diametro del circulo
	 * @return Retorna base + base + altura + altura que es el perimetro del rectángulo
	 */
	@Override
	public double perimetro(int l1, int base, int altura, int l1t, int l2t, int l3t, int d) {
		return base + base + altura + altura;
	}
	
	/**
	 * @param l1 Parámetro que define el lado del cuadrado
	 * @param base Parámetro que define la base del rectangulo o del triángulo
	 * @param altura Parámetro que define la altura del rectángulo o del triángulo
	 * @param r Parámetro que define el radio del circulo
	 * @return Retorna base * altura que es el area del rectángulo
	 */
	@Override
	public double area(int l1, int base, int altura, int r) {
		return base * altura;
	}

}
