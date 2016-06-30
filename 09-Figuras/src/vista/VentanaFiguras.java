package vista;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.Circulo;
import modelo.Cuadrado;
import modelo.Figuras;
import modelo.Rectangulo;
import modelo.Triangulo;

/**
 * 
 * @author heriberto
 *
 */

public class VentanaFiguras extends JFrame implements ActionListener {
	/**
	 * Componentes que conforman la ventana
	 */
	// Buttons
	private JButton btnCuadro = new JButton("Cuadrado");
	private JButton btnRectangulo = new JButton("Rectángulo");
	private JButton btnTriangulo = new JButton("Triángulo");
	private JButton btnCirculo = new JButton("Circulo");
	private JButton btnCalcular = new JButton("Calcular");
	private JButton btnBorrar = new JButton("Borrar");
	
	// Labels
	private JLabel lblLado1 = new JLabel("Lado");
	private JLabel lblLado2 = new JLabel("Base");
	private JLabel lblLado3 = new JLabel("Altura");
	private JLabel lblPer = new JLabel("Resultado del perimetro");
	private JLabel lblArea = new JLabel("Resultado del área");
	
	// TextFields
	private JTextField jtfL1 = new JTextField();
	private JTextField jtfL2 = new JTextField();
	private JTextField jtfL3 = new JTextField();
	
	// Container
	private Container c = getContentPane();
	
	private int opc = 0;
	
	private Figuras f;
	
	/**
	 * Constructor de la clase
	 */
	public VentanaFiguras() {
		super.setTitle("Figuras");
		super.setSize(400, 430);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cargarControladores();
	}
	
	/**
	 * cargarControladores();
	 * Método para cargar controladores y agregarlos al Conteiner
	 */
	private void cargarControladores() {
		c.setLayout(null);
		
		// Definición de limites
		btnCuadro.setBounds(20, 20, 150, 20);
		btnRectangulo.setBounds(180, 20, 150, 20);
		btnTriangulo.setBounds(20, 50, 150, 20);
		btnCirculo.setBounds(180, 50, 150, 20);
		
		lblLado1.setBounds(20, 120, 150, 20);
		lblLado2.setBounds(20, 160, 150, 20);
		lblLado3.setBounds(20, 200, 150, 20);
		
		jtfL1.setBounds(180, 120, 100, 20);
		jtfL2.setBounds(180, 160, 100, 20);
		jtfL3.setBounds(180, 200, 100, 20);
		
		btnCalcular.setBounds(100, 250, 150, 20);
		
		lblPer.setBounds(20, 290, 300, 20);
		lblArea.setBounds(20, 320, 300, 20);
		
		btnBorrar.setBounds(149, 353, 117, 25);
		
		
		// Agregarlos al panel
		c.add(btnCuadro);
		c.add(btnRectangulo);
		c.add(btnTriangulo);
		c.add(btnCirculo);
		
		c.add(lblLado1);
		c.add(lblLado2);
		c.add(lblLado3);
		
		c.add(jtfL1);
		c.add(jtfL2);
		c.add(jtfL3);
		
		c.add(btnCalcular);
		
		c.add(lblPer);
		c.add(lblArea);
		
		c.add(btnBorrar);
						
		
		// Ocultar al inicio
		lblLado1.setVisible(false);
		lblLado2.setVisible(false);
		lblLado3.setVisible(false);
		
		jtfL1.setVisible(false);
		jtfL2.setVisible(false);
		jtfL3.setVisible(false);
		
		// Asignación de los eventos a cada boton
		btnCuadro.addActionListener(this);
		btnRectangulo.addActionListener(this);
		btnTriangulo.addActionListener(this);
		btnCirculo.addActionListener(this);
		btnCalcular.addActionListener(this);
		btnBorrar.addActionListener(this);
		
	}
	
	/**
	 * Método actionListener dependiendo de la selección se realizaran las operaciones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * if para el boton btnCuadro que visualiza las opciones para realizar
		 * el cálculo del perimetro y area del cuadrado
		 */
		if(e.getSource() == btnCuadro ){
			// Establece la variable opt=1 para usarla en el switch del boton Calcular
			opc = 1;
			
			// Visualiza la etiqueta lblLado1 y jtfL1		
			lblLado1.setVisible(true);
			jtfL1.setVisible(true);		
		}
		
		/**
		 * if para el boton btnRectangulo que visualiza las opciones para realizar
		 * el cálculo del perimetro y area del rectangulo
		 */
		if(e.getSource() == btnRectangulo ){
			// Establece la variable opt = 2 para usarla en el switch del boton Calcular
			opc = 2;
			
			// Visualiza la etiqueta lblLado1, lblLado2, jtfL1 y jtfL2		
			lblLado2.setVisible(true);
			jtfL2.setVisible(true);
			lblLado3.setVisible(true);
			jtfL3.setVisible(true);
		}
		
		/**
		 * if para el boton btnTriangulo que visualiza las opciones para realizar
		 * el cálculo del perimetro y area del triangulo
		 */
		if(e.getSource() == btnTriangulo ){
			// Establece la variable opt = 3 para usarla en el switch del boton Calcular
			opc = 3;
			
			// Visualiza la etiqueta lblLado1, lblLado2, lblLado3, jtfL1, jtfL2 y jtfL3		
			lblLado1.setVisible(true);
			jtfL1.setVisible(true);
			
			lblLado2.setVisible(true);
			jtfL2.setVisible(true);
			
			lblLado3.setVisible(true);
			jtfL3.setVisible(true);
			
		}
		
		/**
		 * if para el boton btnCirculo que visualiza las opciones para realizar
		 * el cálculo del perimetro y area del triangulo
		 */
		if(e.getSource() == btnCirculo ){
			// Establece la variable opt = 4 para usarla en el switch del boton Calcular
			opc = 4;
			
			// Visualiza la etiqueta lblLado1 con nombre radio
			lblLado1.setText("Radio");
			lblLado1.setVisible(true);
			jtfL1.setVisible(true);
			
		}
		
		/**
		 * if para el boton btnCalcular que realiza
		 * el cálculo del perimetro y area dependiendo el valor de la variable opc
		 */
		if(e.getSource() == btnCalcular){		
			switch (opc) {
			case 1:
				f = new Cuadrado();
				double r1 = f.perimetro(
						Integer.parseInt(jtfL1.getText()), 
						0, 
						0, 
						0, 
						0, 
						0, 
						0);
				lblPer.setText(String.format("%s + %s + %s + %s = %.2f", 
						jtfL1.getText(), jtfL1.getText(), jtfL1.getText(), jtfL1.getText(), r1));
				
				double r2 = f.area(
						Integer.parseInt(jtfL1.getText()), 
						0, 
						0, 
						0);
				lblArea.setText(String.format("%s * %s = %.2f", 
						jtfL1.getText(), jtfL1.getText(), r2));				
				break;
				
				case 2:
					f = new Rectangulo();
					double r3 = f.perimetro(
							0, 
							Integer.parseInt(jtfL2.getText()), 
							Integer.parseInt(jtfL3.getText()), 
							0, 
							0, 
							0, 
							0);
					lblPer.setText(String.format("%s + %s + %s + %s = %.2f", 
							jtfL2.getText(), jtfL3.getText(), jtfL2.getText(), jtfL3.getText(), r3));
					double r4 = f.area(
							0, 
							Integer.parseInt(jtfL2.getText()), 
							Integer.parseInt(jtfL3.getText()), 
							0);
					lblArea.setText(String.format("%s * %s = %.2f", 
							jtfL2.getText(), jtfL3.getText(), r4));
					break;
			
				case 3:
					f = new Triangulo();
					double r5 = f.perimetro(0, 
							0, 
							0, 
							Integer.parseInt(jtfL1.getText()), 
							Integer.parseInt(jtfL2.getText()), 
							Integer.parseInt(jtfL3.getText()), 
							0);
					lblPer.setText(String.format("%s + %s + %s = %.2f", 
							jtfL1.getText(), jtfL2.getText(), jtfL3.getText(), r5));
					double r6 = f.area(0, 
							Integer.parseInt(jtfL2.getText()), 
							Integer.parseInt(jtfL3.getText()), 
							0);
					lblArea.setText(String.format("(%s * %s)/2 = %.2f", 
							jtfL2.getText(), jtfL3.getText(), r6));
					break;
					
				case 4:
					f = new Circulo();
					double r7 = f.perimetro(
							0, 
							0, 
							0, 
							0, 
							0, 
							0, 
							2*(Integer.parseInt(jtfL1.getText())));
					lblPer.setText(String.format("pi * 2 (%s) = %.2f", 
							jtfL1.getText(), r7));
					double r8 = f.area(0, 
							0, 
							0, 
							Integer.parseInt(jtfL1.getText()));
					lblArea.setText(String.format("(%s * %s) * pi = %.2f", 
							jtfL1.getText(), jtfL1.getText(), r8));
					break;
					

			default:
				break;
			}
		}
		
		/**
		 * Borramos el contenido que se tenga en los campos lblLinea1, lblLinea2, lblLinea3
		 * jtfL1, jtfL2, y jtfL3
		 * y definimos la variable opc = 0
		 */
		if(e.getSource() == btnBorrar){
			opc = 0;
			limpiar();
		}
	}
	
	/**
	 * Método que borra el contenido en los campos de texto y hace invisible
	 * los componentes que no se ocupan
	 */
	private void limpiar(){
		
		lblLado1.setVisible(false);
		jtfL1.setText(null);
		jtfL1.setVisible(false);
		lblLado1.setText("Lado");
		
		lblLado2.setVisible(false);
		jtfL2.setText(null);
		jtfL2.setVisible(false);

		lblLado3.setVisible(false);
		jtfL3.setText(null);
		jtfL3.setVisible(false);
	}
}
