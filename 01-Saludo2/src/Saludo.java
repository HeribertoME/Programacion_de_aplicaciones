import javax.swing.JOptionPane;

/**
 * 
 * @author Heriberto
 *
 */
public class Saludo {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[]args){
		String nombre="Heriberto";
		String edad= "27";
		//Error: System.out.println("Hola"+nombre);
		//Correcto:  System.out.printf("Hola: %s", nombre);
		
		//Formato
		JOptionPane.showMessageDialog(null, String.format("Hola: %s tu edad es: %s años", nombre, edad));	
	}

}
