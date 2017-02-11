import java.util.Scanner;

/**
 * 
 * @author heriberto
 *
 */
public class JugadorDeNaves {

	/**
	 * Metodo principal donde se llaman las clases
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Naves n1 = Naves.instanciaNave();
		Jugador j1 = new Jugador();
		Computadora c1 = new Computadora();
		System.out.println("Juego de naves");
		System.out.println("Hay " + n1.getVidas() + " naves");

		while (n1.getVidas() > 0) {
			Scanner scn = new Scanner(System.in);
			System.out.println("Cuantos disparos quieres hacer?");
			int disparos = scn.nextInt();

			if (disparos <= n1.getVidas()) {
				for (int i = 0; i < disparos; i++) {
					j1.eliminarNave();
				}
				
				System.out.println("Eliminaste " + disparos + " naves");
				
				if (Math.round(disparos * Math.random()) > 0) {
					for (int i = 0; i < Math.round(disparos * Math.random()); i++) {
						c1.crearNave();
					}					
				}
				
				System.out.println("Restan " + n1.getVidas() + " naves");
			} else {
				System.out.println("El numero de disparos no puede superar el numero de naves");
			}
		}
	}

}
