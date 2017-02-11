package modelo;

public class Multiplicacion implements Operaciones{

	/**
	 * @param n1 parámetro del primer numero que es enviado desde la ventana de operaciones
	 * @param n2 parámetro del segundo número que es enviado desde la ventana de operaciones
	 * @return Retorna la multiplicaciójn de n1 por n2
	 */
	@Override
	public int operacion(int n1, int n2) {
		return n1 * n2;
	}

}
