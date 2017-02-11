import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fabrica fabrica = new Fabrica();
		Animal animal;
		
		int op = 0;
		while (op!=4){
			String opcion = JOptionPane.showInputDialog("Crear un animal"
					+"\n 1. Perro"
					+"\n 2. Gato"
					+"\n 3. Zorro"
					+"\n 4. Salir");
		op=Integer.parseInt(opcion);
		if(op==4){
			JOptionPane.showMessageDialog(null,"B Y E .. B Y E ");
		}else{
			animal=fabrica.crearObjeto(op);
			animal.comer();
			JOptionPane.showMessageDialog(null,animal.comer());
			}
			
		}
		

	}

}
