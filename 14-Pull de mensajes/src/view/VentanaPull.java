package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import database.GestionMensaje;
import javax.swing.JLabel;

public class VentanaPull extends JFrame implements ActionListener, MouseListener{
	
	private static final long serialVersionUID = -7687853010882699892L;
	private JButton btnMsj = new JButton("Nuevo mensaje");
	private JButton btnSalir = new JButton("Cerrar");
	
	private JTextArea jtaMensaje = new JTextArea();
	
	private JTable tabla = new JTable();
	private JScrollPane scrollPane = new JScrollPane();
	private DefaultTableModel modelo = new DefaultTableModel(){
		private static final long serialVersionUID = 4757348047712266931L;
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	
	private Color blanco = new Color(250, 250, 250);
	private Color azul = new Color(73, 144, 222);
	
	private Border line = new LineBorder(blanco);
	private Border margin = new EmptyBorder(1, 1, 1, 1);
	private Border compound = new CompoundBorder(line, margin);
	
	private Object datos [] = new Object[4];
	
	private Container c = getContentPane();
	
	private Connection cn;
	
	private int idUsu;
	private JLabel lblMensaje;

	/**
	 * Constructor que inicializa los componentes de la ventana
	 * @param idUsu Es el id del Usuario que envia el login
	 * @param usuario Es el nombre del usuario que envia el login
	 * @param connection Es la instancia de la conexion creada
	 * @throws SQLException 
	 */
	public VentanaPull(int idUsu, String usuario, Connection connection) throws SQLException {
		this.idUsu = idUsu;
		this.cn = connection;
		super.setTitle("Hola "+ usuario);
		super.setSize(500, 500);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cargarDatos(connection);
		cargarControles();
	}
	
	/**
	 * Metodo que carga los componentes de la ventana
	 * @throws SQLException 
	 */
	private void cargarControles() throws SQLException{
		c.setLayout(null);
		c.setBackground(blanco);
		
		tabla.setBounds(10, 10, 465, 200);
		tabla.getRowSelectionAllowed();
		
				
		scrollPane.setBounds(10, 11, 465, 199);
		scrollPane.setViewportView(tabla);		
		
		jtaMensaje.setBounds(10, 247, 465, 148);
		jtaMensaje.setBackground(new Color(240, 255, 255));
		jtaMensaje.setEditable(false);
		
		btnMsj.setBorder(compound);
		btnMsj.setForeground(azul);		
		btnMsj.setBounds(130, 410, 115, 20);
		
		btnSalir.setBorder(compound);
		btnSalir.setForeground(azul);		
		btnSalir.setBounds(250, 410, 110, 20);
		
		c.add(scrollPane);
		c.add(jtaMensaje);
		c.add(btnMsj);
		c.add(btnSalir);
		
		lblMensaje = new JLabel("Mensaje:");
		lblMensaje.setBounds(20, 221, 65, 14);
		getContentPane().add(lblMensaje);
		
		// Asignacion de los eventos
		btnMsj.addActionListener(this);
		btnSalir.addActionListener(this);
		tabla.addMouseListener(this);
		
	}
	
	/**
	 * Metodo que carga los mensajes en la tabla al iniciar el pull
	 * @param connection Es la conexion que se creó
	 * @throws SQLException 
	 */
	private void cargarDatos(Connection connection) throws SQLException {

		modelo = new DefaultTableModel();
		
		GestionMensaje msj = new GestionMensaje();
		ResultSet rs = msj.consulta(connection);
		
		modelo.addColumn("Id");
		modelo.addColumn("Fecha");
		modelo.addColumn("Hora");
		modelo.addColumn("Usuario");
		tabla.setModel(modelo);
		
		while(rs.next()){
			datos[0] = rs.getString(1);
			datos[1] = rs.getString(2);
			datos[2] = rs.getString(3);
			datos[3] = rs.getString(5);
			
			modelo.addRow(datos);
		}		
		
	}

	/**
	 * Metodo que realiza las acciones de los botones
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		/**
		 * if para el boton btnSalir, cierra la ventana y se reinicia la clase VentanaPrincipal
		 */
		if(ev.getSource() == btnSalir){
			System.exit(0);
			
		}
		/**
		 * if para el boton btnMsj, puede enviar un mensaje nuevo al pull de mensajes
		 */
		if(ev.getSource() == btnMsj){
			//System.out.println(fila);
			//tabla.removeRowSelectionInterval(fila, fila);
			String mensaje = JOptionPane.showInputDialog("Mensaje: ");
			System.out.println(mensaje);
			String resp = enviaMensaje(mensaje);
			jtaMensaje.setText(resp);
			vaciarTabla();
			try {
				cargarDatos(cn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
	}
	
	/**
	 * Metodo que acciona el evento al elegir elementos la tabla
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		String mensaje = null;
		String id = null;
		int row = tabla.rowAtPoint(e.getPoint());
		if(row >= 0 && tabla.isEnabled()){
				id = modelo.getValueAt(row, 0).toString();
		}

		try {
			mensaje = consultaMensaje(id);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		jtaMensaje.setText(mensaje);
	}

	/**
	 * Metodo que vacia la tabla para cargar los datos nuevamente
	 * 
	 */
	private void vaciarTabla() {
		tabla.setModel(new DefaultTableModel());
	}

	/**
	 * Metodo para enviar el mensaje capturado
	 */
	private String enviaMensaje(String mensaje) {
		if(mensaje != null){
		GestionMensaje msj = new GestionMensaje();
		int resp = msj.insertMsj(cn, mensaje, idUsu);
		if(resp == 1){
			return "Mensaje enviado";
		}else
		return "Hubo un error";
		}
		return "Cancelado";
	}
	
	/**
	 * Metodo para consultar el mensaje correspondiente de la lista de mensajes
	 * @param id Es el id del mensaje
	 * @return mensaje regresamos el mensaje consultado
	 * @throws SQLException 
	 */
	private String consultaMensaje(String id) throws SQLException {
		GestionMensaje msj = new GestionMensaje();
		ResultSet rs = msj.consultaMensaje(cn, id);
		String mensaje = null;
		while (rs.next()) {
			mensaje = rs.getString(1);
		}
		return mensaje;
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}