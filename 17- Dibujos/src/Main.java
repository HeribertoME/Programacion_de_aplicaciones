import View.VentanaPrincipal;

public class Main {
	
	/**
	 * 
	 * @param args Parámetro para llamar la vista de la clase VentanaPrincipal
	 */
	public static void main(String[] args) {
		VentanaPrincipal v = VentanaPrincipal.instanciaSinglenton();
		v.setVisible(true);
	}

}
