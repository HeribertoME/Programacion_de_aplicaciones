package modelo;

public class Suma implements Operaciones{

	/**
	 * @param n1 parámetro del primer numero que es enviado desde la ventana de operaciones
	 * @param n2 parámetro del segundo número que es enviado desde la ventana de operaciones
	 * @return Retorna la suma de n1 más n2
	 */
	@Override
	public int operacion(int n1, int n2) {
		return n1 + n2;
	}

}
