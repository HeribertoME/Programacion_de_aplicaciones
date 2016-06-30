package vista;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.Division;
import modelo.Multiplicacion;
import modelo.Resta;
import modelo.Suma;

public class VentanaOperaciones extends JFrame implements ActionListener {
	/**
	 * Componentes que conforman la ventana
	 */
	private JLabel lbln1 = new JLabel("Número 1");
	private JTextField jtfN1 = new JTextField();
	private JLabel lbln2 = new JLabel("Número 2");
	private JTextField jtfN2 = new JTextField();
	
	private JButton btnSuma = new JButton("+");
	private JButton btnResta = new JButton("-");
	private JButton btnMult = new JButton("x");
	private JButton btnDiv = new JButton("/");
	
	private JLabel lblRes = new JLabel("");
	
	private Container c = getContentPane();
	
	/**
	 * Constructor de la clase
	 */
	public VentanaOperaciones(){
		super.setTitle("Operaciones");
		super.setSize(400, 500);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cargarControladores();
	}
	
	/**
	 * Método para cargar controladores y agregarlos al Conteiner
	 */
	private void cargarControladores() {
		c.setLayout(null);
		
		lbln1.setBounds(20, 20, 100, 20);
		jtfN1.setBounds(20, 40, 150, 20);
		lbln2.setBounds(20, 60, 100, 20);
		jtfN2.setBounds(20, 80, 150, 20);
		
		btnSuma.setBounds(20, 120, 80, 80);
		btnResta.setBounds(105, 120, 80, 80);
		btnMult.setBounds(20, 205, 80, 80);
		btnDiv.setBounds(105, 205, 80, 80);
		
		lblRes.setBounds(20, 300, 250, 20);
		
		c.add(lbln1);
		c.add(jtfN1);
		c.add(lbln2);
		c.add(jtfN2);
		
		c.add(btnSuma);
		c.add(btnResta);
		c.add(btnMult);
		c.add(btnDiv);
		
		c.add(lblRes);
		
		btnSuma.addActionListener(this);
		btnResta.addActionListener(this);
		btnMult.addActionListener(this);
		btnDiv.addActionListener(this);
		
	}
	
	/**
	 * Método actionListener dependiendo del boton seleccionado se realiza la operación 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * if para el boton btnSuma que inicializa la operación suma
		 */
		if(e.getSource() == btnSuma ){
			Suma obj = new Suma();
			int r = obj.operacion(
					Integer.parseInt(jtfN1.getText()),
					Integer.parseInt(jtfN2.getText())
					);
			lblRes.setText(String.format("%s + %s = %d", 
					jtfN1.getText(), jtfN2.getText(), r));
			
		}
		/**
		 * if para el boton btnResta que inicializa la operación resta
		 */
		if(e.getSource() == btnResta){
			Resta obj = new Resta();
			int r = obj.operacion(
					Integer.parseInt(jtfN1.getText()),
					Integer.parseInt(jtfN2.getText())
					);
			lblRes.setText(String.format("%s - %s = %d",
					jtfN1.getText(), jtfN2.getText(), r));
		}
		/**
		 * if para el boton btnMult que inicializa la operación multiplicación
		 */
		if(e.getSource() == btnMult){
			Multiplicacion obj = new Multiplicacion();
			int r = obj.operacion(
					Integer.parseInt(jtfN1.getText()), 
					Integer.parseInt(jtfN2.getText())
					);
			lblRes.setText(String.format("%s * %s = %d", 
					jtfN1.getText(), jtfN2.getText(), r));
		}
		/**
		 * if para el boton btnDiv que inicializa la operación división
		 */
		if(e.getSource() == btnDiv){
			Division obj = new Division();
			int numero2 = Integer.parseInt(jtfN2.getText());
			if(numero2 == 0)
				lblRes.setText("No se puede dividir entre 0");
			else{
			int r = obj.operacion(
					Integer.parseInt(jtfN1.getText()), 
					numero2
					);
			lblRes.setText(String.format("%s / %s = %d", 
					jtfN1.getText(), jtfN2.getText(), r));
			}
		}	
	}
}
