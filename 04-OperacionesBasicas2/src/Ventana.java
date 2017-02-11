import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 * 
 * @author Heriberto Martinez Elizarraraz 
 *
 */
public class Ventana extends JFrame implements ActionListener{

	/**
	 * Se crean los objetos de todos los componentes ha utilizar
	 */
	private JTextField txtN1 = new JTextField();
	private JTextField txtN2 = new JTextField();
	
	private JLabel lbN1 = new JLabel("Numero 1");
	private JLabel lbN2 = new JLabel("Numero 2");
	private JLabel lbResultado = new JLabel("Resultado: ");
	
	private JButton btnSuma = new JButton("Suma");
	private JButton btnResta = new JButton("Resta");
	private JButton btnMultiplicar = new JButton("Multiplicar");
	private JButton btnDividir = new JButton("Dividir");
	
	private Container c = getContentPane();
	
	private Operaciones op = new Operaciones();
	
	/**
	 * Se crea el metodo para la ventana
	 */
	public Ventana(){
		super.setTitle("Operaciones");
		super.setSize(320, 480);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cargarControles() ;
	}

	/**
	 * Se crea el metodo para cargar los controladores
	 */
	private void cargarControles() {
		
		c.setLayout(null);
		
		//Se le da posicionamiento a los componentes
		lbN1.setBounds(10, 10, 270, 30);
		txtN1.setBounds(10, 40, 270, 30);
		
		lbN2.setBounds(10, 80, 270, 30);
		txtN2.setBounds(10, 110, 270, 30);
		
		btnSuma.setBounds(10, 150, 95, 35);
		btnResta.setBounds(120, 150, 95, 35);
		btnMultiplicar.setBounds(10, 200, 95, 35);
		btnDividir.setBounds(120, 200, 95, 35);
		
		lbResultado.setBounds(10, 240, 270, 30);
		
		//Se agregan los componentes al contenedor
		c.add(lbN1);
		c.add(txtN1);
		c.add(lbN2);
		c.add(txtN2);
		c.add(btnSuma);
		c.add(btnResta);
		c.add(btnMultiplicar);
		c.add(btnDividir);
		c.add(lbResultado);
		
		//Asignar Evento a los botones
		btnSuma.addActionListener(this);
		btnResta.addActionListener(this);
		btnMultiplicar.addActionListener(this);
		btnDividir.addActionListener(this);
		
	}
	/**
	 * Se crea el metodo del escuchador para las acciones de los botones
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		/**
		 * Se utiliza un if para comparar el boton y realize la opcion, en este caso es el boton de suma
		 */
		if(arg0.getSource()== btnSuma){
			int r = op.sumar(
					Integer.parseInt(txtN1.getText()), 
					Integer.parseInt(txtN2.getText())
					);
			lbResultado.setText(String.format("%s + %s = %d", 
					txtN1.getText(), 
					txtN2.getText(), 
					r)
					);
		}
		
		/**
		 * Se utiliza un if para comparar el boton y realize la opcion, en este caso es el boton de resta 
		 */
		else if (arg0.getSource()== btnResta) {
			int r = op.restar(
					Integer.parseInt(txtN1.getText()), 
					Integer.parseInt(txtN2.getText())
					);
			lbResultado.setText(String.format("%s - %s = %d", 
					txtN1.getText(), 
					txtN2.getText(), 
					r)
					);
		}
		/**
		 * Se utiliza un if para comparar el boton y realize la opcion, en este caso es el boton de multiplicar
		 */
		else if (arg0.getSource()== btnMultiplicar) {
			int r = op.multiplicar(
					Integer.parseInt(txtN1.getText()), 
					Integer.parseInt(txtN2.getText())
					);
			lbResultado.setText(String.format("%s * %s = %d", 
					txtN1.getText(), 
					txtN2.getText(), 
					r)
					);
		}
		/**
		 * Se utiliza un if para comparar el boton y realize la opcion, en este caso es el boton de dividir
		 */
		else if (arg0.getSource()== btnDividir) {
			int r = op.dividir(
					Integer.parseInt(txtN1.getText()), 
					Integer.parseInt(txtN2.getText())
					);
			lbResultado.setText(String.format("%s / %s = %d", 
					txtN1.getText(), 
					txtN2.getText(), 
					r)
					);
		}
		
	}
	
}
