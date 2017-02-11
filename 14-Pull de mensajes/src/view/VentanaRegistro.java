package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.GestionUsuario;

public class VentanaRegistro extends JFrame implements ActionListener {

	private static final long serialVersionUID = -1784148607844701851L;
	private JLabel lblnick = new JLabel("Nick");
	private JLabel lblpass = new JLabel("Introduzca contraseña");
	private JLabel lblpassConf = new JLabel("Confirmar contraseña");
	
	private JTextField jtfnick = new JTextField();
	private JPasswordField jtfPass = new JPasswordField();
	private JPasswordField jtfPassConf = new JPasswordField();
	
	private JButton btnRegistrar = new JButton("Registrar");
	private JButton btnCancelar = new JButton("Cancelar");
	
	private Container c = getContentPane();
	
	private Connection connection;
	
	/**
	 * Constructor que inicializa los componentes de la ventana
	 * @param connection Es la instancia de la conexion creada
	 */
	public VentanaRegistro(Connection connection) {
		this.connection = connection;
		super.setTitle("Nuevo registro");
		super.setSize(300, 300);
		//super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cargaControles();
	}
	
	/**
	 * Metodo que carga los componentes de la ventana
	 * 
	 */
	private void cargaControles(){
		c.setLayout(null);
		
		lblnick.setBounds(10, 10, 120, 20);
		jtfnick.setBounds(140, 10, 120, 20);
		
		lblpass.setBounds(10, 40, 120, 20);
		jtfPass.setBounds(140, 40 , 120, 20);
		
		lblpassConf.setBounds(10, 70, 120, 20);
		jtfPassConf.setBounds(140, 70, 120, 20);
		
		btnRegistrar.setBounds(30, 100, 100, 20);
		btnCancelar.setBounds(140, 100, 100, 20);
		
		c.add(lblnick);
		c.add(jtfnick);
		c.add(lblpass);
		c.add(jtfPass);
		c.add(lblpassConf);
		c.add(jtfPassConf);
		c.add(btnRegistrar);
		c.add(btnCancelar);
		
		btnRegistrar.addActionListener(this);
		btnCancelar.addActionListener(this);
		
	}

	/**
	 * Metodo que ejecuta las acciones del ActionListener
	 */
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == btnRegistrar){
			//System.out.println("Registra");
			boolean val = validacion();
			if(val){
				//Inserta en la base de datos
				//System.out.println("Inserta en la bd");
				GestionUsuario usu = new GestionUsuario();
				@SuppressWarnings("deprecation")
				int conf = usu.insertarUsuario(connection, String.valueOf(jtfnick.getText()), String.valueOf(jtfPass.getText()));
				if(conf == 1){
					JOptionPane.showMessageDialog(null,
							"Usuario registrado",
							"Éxito",
							JOptionPane.INFORMATION_MESSAGE);
				jtfnick.setText("");
				jtfPass.setText("");
				jtfPassConf.setText("");
				}
				else
					JOptionPane.showMessageDialog(null, 
							"No se pudo registrar ",
							"Error",
							JOptionPane.ERROR_MESSAGE);
				
			}
			
		}
		if(arg0.getSource() == btnCancelar){
			this.setVisible(false);
		}
	}
	
	/**
	 * Metodo que valida los campos de texto
	 * 
	 * @return true si no hay campos vacios
	 */
	@SuppressWarnings("deprecation")
	private boolean validacion(){
		if(jtfnick.getText().equals("") 
				|| jtfPass.getText().equals("")
				|| jtfPassConf.getText().equals("")){
			JOptionPane.showMessageDialog(null, 
					"No puede haber campos vacios",
					"Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		else{
			if(jtfPass.getText().equals(jtfPassConf.getText())){
				return true;
			}else{
				JOptionPane.showMessageDialog(null, 
						"Las contraseñas no coinciden",
						"Error",
						JOptionPane.ERROR_MESSAGE);
				return false;	
			}
		}
	}

}
