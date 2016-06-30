package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.GestionUsuario;
import singlenton.SinglentonConexion;

/**
 * 
 * @author heriberto
 *
 */

public class VentanaPrincipal extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = -2406989778933578480L;
	
	private JTextField jtfUsuario = new JTextField();
	private JPasswordField jtfPass = new JPasswordField();
	
	private JLabel lblUsuario = new JLabel("Usuario");
	private JLabel lblPass = new JLabel("Pasdword");
	//private JLabel lblNuevo = new JLabel("¿Nuevo usuario?");
	
	private JButton btnIngresar = new JButton("Ingresar");
	private JButton btnNuevo = new JButton("Registrar");
	
	private Container c = getContentPane();
	
	private SinglentonConexion sc = SinglentonConexion.instanciaCon();
	private Connection myCon = sc.getConnection();
	
	/**
	 * Constructor
	 */
	public VentanaPrincipal() {
		super.setTitle("Inicio");
		super.setSize(500, 200);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cargarControles();
	}
	
	/**
	 * Metodo que carga los componentes dispnibles en la ventana
	 */
	private void cargarControles(){
		c.setLayout(null);
		
		lblUsuario.setBounds(20, 20, 120, 30);
		jtfUsuario.setBounds(150, 20, 120, 30);
		
		lblPass.setBounds(20, 60, 120, 30);
		jtfPass.setBounds(150, 60, 120, 30);
		
		btnIngresar.setBounds(100, 100, 120, 30);
		btnNuevo.setBounds(230, 100, 120, 30);
		
		c.add(lblUsuario);
		c.add(jtfUsuario);
		c.add(lblPass);
		c.add(jtfPass);
		c.add(btnIngresar);
		c.add(btnNuevo);
		
		btnIngresar.addActionListener(this);
		btnNuevo.addActionListener(this);
		
	}
	
	/**
	 * Metodo que llama las ventanas dependiendo de la accion que se realice
	 * 
	 */
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		/**
		 * if para ejecutar el boton btnIngresar que realiza la accion de loggin
		 */
		if(e.getSource() == btnIngresar){
			int idUsu = 0;
			String usuario = null;
			String password = null;
			String user = String.valueOf(jtfUsuario.getText());
			String pass = String.valueOf(jtfPass.getText());
			//System.out.println("Buscar usuario y contraseña en la base, despues llamar ventana de pull");
			GestionUsuario usu = new GestionUsuario();
			ResultSet rs = usu.consulta(myCon, user);
			
			try {
				while (rs.next()) {
					idUsu = rs.getInt(1);
					usuario = rs.getString(2);
					password = rs.getString(3);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			if(pass.equals(password)){
				System.out.println("Inicio correcto");
				VentanaPull vtn = null;
				try {
					vtn = new VentanaPull(idUsu, usuario, myCon);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				vtn.setVisible(true);
				this.setVisible(false);
			}else{
				System.out.println("Inicio erroneo");
				JOptionPane.showMessageDialog(null, 
						"Usuario o contraseña incorrecto",
						"Error",
						JOptionPane.ERROR_MESSAGE);
			}
		/**
		 * If para ejecutar el boton btnNuevo que manda a llamar la ventana de registro
		 * de nuevo usuario
		 */
		}
		if(e.getSource() == btnNuevo){
			//System.out.println("LLamar ventana de nuevo registro");
			VentanaRegistro vtn = new VentanaRegistro(myCon);
			vtn.setVisible(true);
		}
	}

}
