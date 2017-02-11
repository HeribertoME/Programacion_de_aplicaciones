import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ventana extends JFrame implements ActionListener{

	private JTextField txtN1 = new JTextField();
	private JTextField txtN2 = new JTextField();
	private JLabel lbN1 = new JLabel("Numero 1");
	private JLabel lbN2 = new JLabel("Numero 2");
	private JLabel lbResultado = new JLabel("Resultado: ");
	private JButton btnCalcular = new JButton("Calcular");
	private Container c = getContentPane();
	
	private Operaciones op = new Operaciones();
	
	
	public Ventana(){
		super.setTitle("Operaciones");
		super.setSize(320, 480);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cargarControles() ;
	}


	private void cargarControles() {
		
		c.setLayout(null);
		
		lbN1.setBounds(10, 10, 300, 30);
		txtN1.setBounds(10, 40, 290, 30);
		
		lbN2.setBounds(10, 80, 300, 30);
		txtN2.setBounds(10, 110, 290, 30);
		
		btnCalcular.setBounds(10, 150, 290, 35);
		lbResultado.setBounds(10,180,300,30);
		
		c.add(lbN1);
		c.add(txtN1);
		c.add(lbN2);
		c.add(txtN2);
		c.add(btnCalcular);
		c.add(lbResultado);
		
		//Asignar Evento al boton
		btnCalcular.addActionListener(this);
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		int r = op.sumar(
				Integer.parseInt(txtN1.getText()), 
				Integer.parseInt(txtN2.getText())
				);
		// %d = asignara un valor de tipo decimal
		lbResultado.setText(String.format("%s + %s = %d", 
				txtN1.getText(), 
				txtN2.getText(), 
				r)
				);
	}
	
	
	
}
