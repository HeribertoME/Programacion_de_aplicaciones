package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Model.Figura;
import Model.Option;

/**
 * 
 * @author heriberto
 *
 */
public final class VentanaPrincipal extends JFrame implements ActionListener{
	/**
	 * Componentes que conforman la ventana
	 */
	private static final VentanaPrincipal instancia = new VentanaPrincipal();
	// Buttons
	private JButton btnCambiar = new JButton("Cambiar");
	
	// Radio buttons
	private JRadioButton rdbtnCasa = new JRadioButton("Casa");
	private JRadioButton rdbtnGato = new JRadioButton("Gato");
	private JRadioButton rdbtnFlor = new JRadioButton("Flor");
	private JRadioButton rdbtnTren = new JRadioButton("Tren");
	
	// Group radio buttons
	private ButtonGroup grupo = new ButtonGroup();
	
	// Container
	private Container c = getContentPane();
	
	//
	private Option option = new Option();
	private Figura figura;
	private boolean uno,dos,tres,cuatro;
	private JPanel panel = new JPanel();
	
	/**
	 * Constructor de la clase
	 */
	private VentanaPrincipal() {
		super.setTitle("");
		super.setSize(320, 480);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cargarControladores();
	}
	
	/**
	 * Método para cargar los controladores y agregarlos al Container
	 */
	private void cargarControladores() {
		c.setLayout(null);
		
		// Agregar radio buttons al grupo
		grupo.add(rdbtnCasa);
		grupo.add(rdbtnGato);
		grupo.add(rdbtnFlor);
		grupo.add(rdbtnTren);
		
		// Definicion de limites
		rdbtnCasa.setBounds(10, 320, 100, 20);
		rdbtnGato.setBounds(120, 320, 100, 20);
		rdbtnFlor.setBounds(10, 350, 100, 20);
		rdbtnTren.setBounds(120, 350, 100, 20);
		
		btnCambiar.setBounds(100, 400, 100, 20);
		
		panel.setPreferredSize(new Dimension(480, 320));
		panel.setBackground(Color.white);
		panel.setBounds(10,10,296,302);
		
		// Agregarlos al panel
		c.add(rdbtnCasa);
		c.add(rdbtnGato);
		c.add(rdbtnFlor);
		c.add(rdbtnTren);
		
		c.add(btnCambiar);
		c.add(panel);
		
		// Asignación de eventos a botones
		btnCambiar.addActionListener(this);
		
	}
	
	/**
	 * Metodo actionListener dependiendo de la selección se realizaran las acciones
	 */
	public void actionPerformed(ActionEvent e) {
		/**
		 * if para el boton btnCambiar que visualiza la imagen seleccionada en el radio button
		 */
		if(e.getSource() == btnCambiar ){
			mostrarImagen();
		}	
	}
	
	/**
	 * Metodo que muestra las imagenes
	 */
	public void mostrarImagen(){
		Graphics papel = panel.getGraphics();
	
		if(rdbtnCasa.isSelected()){
			//System.out.println("Muestra paisaje");
			panel.paint(papel);
			figura = option.crearFigura(1);
			figura.dibuja(papel);				
		}
		if(rdbtnGato.isSelected()){
			//System.out.println("Muestra auto");
			panel.paint(papel);
			figura = option.crearFigura(2);
			figura.dibuja(papel);
		}
		if(rdbtnFlor.isSelected()){
			//System.out.println("Muestra cara");
			panel.paint(papel);
			figura = option.crearFigura(3);
			figura.dibuja(papel);
		}
		if(rdbtnTren.isSelected()){
			//System.out.println("Muestra cuerpo");
			panel.paint(papel);
			figura = option.crearFigura(4);
			figura.dibuja(papel);
		}
	}
	
	public static VentanaPrincipal instanciaSinglenton(){
		return instancia;
	}
		
}
