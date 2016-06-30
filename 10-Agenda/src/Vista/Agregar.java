package Vista;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Modelo.Contacto;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class Agregar extends JFrame implements ActionListener, FocusListener{
	Connection myCon;
	
	private JLabel fotoContacto = new JLabel(new ImageIcon(Agregar.class.getResource("/images/img.png")));
	private JButton btnOk = new JButton("AGREGAR");
	private JButton btnCancel = new JButton("CANCELAR");
	private final JButton btnEdit = new JButton("Edit");
	
	private JTextField jtfnombre = new JTextField();
	private JTextField jtfapellidos = new JTextField();
	private JTextField jtforganizacion = new JTextField();
	private JTextField jtfcelular = new JTextField();
	private JTextField jtfparticular = new JTextField();
	private JTextField jtfemail = new JTextField();
	private JTextField jtfurl = new JTextField();
	private JTextField jtfdireccion = new JTextField();
	private JTextField jtfcumple = new JTextField();// TODO Campo cumpleaños
	
	private JTextField txtFields[] = {jtfnombre, jtfapellidos, jtforganizacion, jtfcelular, jtfparticular, jtfemail, jtfurl, jtfdireccion, jtfcumple};
	
	
	private Color blancoLi = new Color(255, 255, 255);
	private Color blanco = new Color(250, 250, 250);
	private Color negro = new Color(000, 000, 000);
	private Color gris = new Color(223, 223, 223);
	private Color azul = new Color(51, 181, 229);
	
	private Border line = new LineBorder(negro);
	private Border margin = new EmptyBorder(1, 1, 1, 1);
	private Border compound = new CompoundBorder(line, margin);
	
	private Border borderButtom = BorderFactory.createMatteBorder(0,0,1,0,gris);
	
	Container c = getContentPane();		
	
	/**
	 * Constructor de la clase 
	 * @param con 
	 */
	public Agregar(Connection con) {
		this.myCon = con;
		super.setTitle("Agregar contacto");
		super.setSize(400, 560);
		
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		super.setLocationRelativeTo(null);
		super.setResizable(false);
		
		cargarControladores();
	}
	
	/**
	 * cargarControladores();
	 * Metodo para cargar controladores y agregarlos al Conteiner
	 */
	private void cargarControladores() {
		c.setLayout(null);
		c.setBackground(blancoLi);
		
		btnCancel.setBorder(compound);
		btnCancel.setForeground(azul);
		btnCancel.setBackground(blanco);
		btnCancel.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));				
		btnCancel.setBounds(20, 13, 174, 30);
		
		btnOk.setBorder(compound);
		btnOk.setForeground(azul);
		btnOk.setBackground(blanco);
		btnOk.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
		btnOk.setBounds(206, 13, 180, 30);
		
		btnEdit.setBorder(compound);
		btnEdit.setForeground(azul);
		btnEdit.setBackground(blanco);
		btnEdit.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));				
		btnEdit.setBounds(20, 130, 60, 17);
		
		fotoContacto.setBounds(20, 70, 60, 60);
		
		jtfnombre.setBorder(borderButtom);
		jtfnombre.setBounds(100, 65, 210, 35);
		jtfnombre.setText("Nombre");
		//lblNombre.setBounds(100, 65, 210, 35);
		
		jtfapellidos.setBorder(borderButtom);
		jtfapellidos.setBounds(100, 100, 210, 35);
		jtfapellidos.setText("Apellidos");
		//lblApellidos.setBounds(100, 100, 210, 35);
		
		jtforganizacion.setBorder(borderButtom);
		jtforganizacion.setBounds(100, 135, 210, 35);
		jtforganizacion.setText("Organización");
		//lblOrganizacion.setBounds(100, 135, 210, 35);
		
		jtfcelular.setBorder(borderButtom);
		jtfcelular.setBounds(20, 200, 290, 35);
		jtfcelular.setText("Celular");
		//lblCelular.setBounds(20, 200, 290, 35);
		
		jtfparticular.setBorder(borderButtom);
		jtfparticular.setBounds(20, 235, 290, 35);
		jtfparticular.setText("Particular");
		//lblParticular.setBounds(20, 235, 290, 35);
		
		jtfemail.setBorder(borderButtom);
		jtfemail.setBounds(20, 300, 290, 35);
		jtfemail.setText("E-mail");
		//lblEmail.setBounds(20, 300, 290, 35);
		
		jtfurl.setBorder(borderButtom);
		jtfurl.setBounds(20, 335, 290, 35);
		jtfurl.setText("Página Web");
		//lblUrl.setBounds(20, 335, 290, 35);
		
		jtfdireccion.setBorder(borderButtom);
		jtfdireccion.setBounds(20, 400, 290, 35);
		jtfdireccion.setText("Dirección");
		//lblDireccion.setBounds(20, 400, 290, 35);
		
		jtfcumple.setBorder(borderButtom);
		jtfcumple.setBounds(20, 435, 290, 35);
		jtfcumple.setText("AAAA/MM/DD");
		//lblCumple.setBounds(20, 435, 290, 35);
		
		
		c.add(btnOk);
		c.add(fotoContacto);
		c.add(btnCancel);			
		c.add(btnEdit);						
		
		btnCancel.addActionListener(this);
		btnOk.addActionListener(this);
		btnEdit.addActionListener(this);				

		// Add event Focus
		for (int i = 0; i < txtFields.length; i++) {
			//c.add(lbLabels[i]);
			c.add(txtFields[i]);
			txtFields[i].addFocusListener(this);
		}
	} 

	/**
	 * Metodo actionPerformde dependiendo de la seleccion se realizaran las acciones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * if para el boton btnCancel que cierra la ventana actual
		 */
		if(e.getSource() == btnCancel ){
			this.setVisible(false);
			VentanaAgenda obj;
			try {
				obj = new VentanaAgenda();
				obj.setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		/**
		 * if para el boton btnOk que captura la informacion
		 * de los campos de texto y los agrega a la base de datos
		 */
		if(e.getSource() == btnOk ){
			Contacto obj = new Contacto();
			
			String nombre = jtfnombre.getText();
			String app = jtfapellidos.getText();
			String org = jtforganizacion.getText();
			String cel = jtfcelular.getText();
			String particular = jtfparticular.getText();
			String mail = jtfemail.getText();
			String dir = jtfdireccion.getText();
			String web = jtfurl.getText();
			String cumple = jtfcumple.getText();
		
			String sql = "INSERT INTO `contacto` (`idContact`, `nombre`, `app`, `organizacion`, `celular`, `particular`, `email`, `direccion`, `sitioWeb`, `cumpleanos`, `id_grupo`) "
					+ "VALUES (NULL, '"+nombre+"', '"+app+"', '"+org+"', '"+cel+"', '"+particular+"', '"+mail+"', '"+dir+"', '"+web+"', '"+cumple+"', NULL)"; 
			int resp = obj.actions(myCon, sql);
			
			if(resp == 1){
				JOptionPane.showMessageDialog(null,"Guardado correctamente");
				this.setVisible(false);
				VentanaAgenda obj2;
				try {
					obj2 = new VentanaAgenda();
					obj2.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else{
				JOptionPane.showMessageDialog(null,"No se pudo guardar");
			}						
		}
		/**
		 * if para el boton btnEdit que permite realizar la configuracion de la foto
		 */
		if(e.getSource() == btnEdit){
			// TODO Abrir ventana para cargar foto
		}
	}

	/**
	 * Metodo que hace invisible las etiquetas de los campos de texto cuando
	 * se comienza a escribir
	 */
	@Override
	public void focusGained(FocusEvent e) {
		for (int i = 0; i < txtFields.length; i++) {
			if( e.getSource() == txtFields[i] && txtFields[i].getText().isEmpty()) {
				//lbLabels[i].setVisible(false);
			}
		}
	}

	/**
	 * Metodo que hace visible las etiquetas en los campos de texto
	 * en caso de que esten vacias
	 */
	@Override
	public void focusLost(FocusEvent e) {
		for (int i = 0; i < txtFields.length; i++) {
			if( e.getSource() == txtFields[i] && txtFields[i].getText().isEmpty()){
				//lbLabels[i].setVisible(true);
			}
		}		
	}
}
