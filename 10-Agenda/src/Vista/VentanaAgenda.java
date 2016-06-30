package Vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Conexion.Conexion;
import Modelo.Contacto;

public class VentanaAgenda extends JFrame implements ActionListener, ListSelectionListener{
	Connection myCon;
	private Contacto objcont = new Contacto();
	private String [] datos = new String[2];
	
	
	/**
	 * Componentes que conforman la ventana
	 */
	
	private JTextField jtfBuscar = new JTextField();
	
	private JButton btnBuscar = new JButton("Buscar");
	private JButton btnNuevo = new JButton("Nuevo");
	private JButton btnOpciones = new JButton(":");
	private JButton btnSearch = new JButton("Buscar");
	
	private JTable tabla = new JTable();
	private JScrollPane scrollPane = new JScrollPane();	
	private DefaultTableModel modelo = new DefaultTableModel();	
	private ListSelectionModel model = tabla.getSelectionModel();
	
	private Color blancoLi = new Color(255, 255, 255);
	private Color blanco = new Color(250, 250, 250);
	private Color negro = new Color(000, 000, 000);
	private Color gris = new Color(223, 223, 223);
	private Color azul = new Color(73, 144, 222);
	
	private Border line = new LineBorder(blanco);
	private Border margin = new EmptyBorder(1, 1, 1, 1);
	private Border compound = new CompoundBorder(line, margin);
	
	private Container c = getContentPane();
	
	/**
	 * Constructor de la clase
	 * @throws SQLException 
	 */
	public VentanaAgenda() throws SQLException {
		super.setTitle("Agenda");
		super.setSize(400, 500);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setLocationRelativeTo(null);
		super.setResizable(false);
		
		conect();
		cargarDatos(myCon);
		cargarControladores();				
	}
	
	/**
	 * cargarControladores();
	 * Metodo para cargar controladores y agregarlos al Conteiner
	 */
	private void cargarControladores() {
		c.setLayout(null);
		c.setBackground(blancoLi);
		
		// Definicion de limites
		jtfBuscar.setBounds(20, 20, 200, 20);
		btnBuscar.setBounds(240, 20, 120, 20);		
		tabla.setBounds(20, 50, 360, 350);
		tabla.getRowSelectionAllowed();
		
		scrollPane.setBounds(20, 51, 360, 349);
		scrollPane.setViewportView(tabla);
		
		btnNuevo.setBorder(compound);
		btnNuevo.setForeground(azul);
		btnNuevo.setBackground(blanco);
		btnNuevo.setBounds(30, 410, 106, 20);
		
		btnSearch.setBorder(compound);
		btnSearch.setForeground(azul);
		btnSearch.setBackground(blanco);
		btnSearch.setBounds(146, 410, 106, 20);
		
		btnOpciones.setBorder(compound);
		btnOpciones.setForeground(azul);
		btnOpciones.setBackground(blanco);
		btnOpciones.setBounds(262, 410, 106, 20);
										
		
		// Agregarlos al panel
		c.add(jtfBuscar);
		c.add(btnBuscar);		
		c.add(scrollPane);
		c.add(btnNuevo);
		c.add(btnSearch);
		c.add(btnOpciones);
		
		//Asignacion de los eventos
		btnNuevo.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOpciones.addActionListener(this);
		
		model.addListSelectionListener(this);
	}
	
	/**
	 * Metodo que realiza la conexion a la bd
	 */
	protected void conect(){
		Conexion obj = new Conexion();
		Connection cn = obj.obtenerConexion();		
		if( cn != null){
			System.out.println("Se realizó la conexión");
			// TODO Poner etiqueta de mensaje
			myCon = cn;
		}
		else{
			// TODO Poner mensaje en etiqueta
			//String errorTipe = obj.getError();
			System.out.println("Falló la conexión");
		}						
	}
	
	/**
	 * Metodo que carga los datos en la tabla al iniciar la ventana
	 * @throws SQLException 
	 */
	public void cargarDatos(Connection c) throws SQLException{
		
		
		String sql = "SELECT*FROM contacto order by nombre";
		ResultSet rs = objcont.consulta(c, sql);
						
		modelo.addColumn("Nombre");
		tabla.setModel(modelo);
		
		while(rs.next()){
			
			datos[0] = String.format(" %s %s", rs.getString(2), rs.getString(3));
			modelo.addRow(datos);			
		}							
	}

	/**
	 * Metodo actionListener
	 * ejecuta las operaciones dependiendo de la seleccion de boton
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * if para el boton btnNuevo que lanza una nueva ventana para agregar un
		 * contacto nuevo
		 */
		if(e.getSource() == btnNuevo){
			Agregar obj = new Agregar(myCon);
			this.setVisible(false);
			obj.setVisible(true);					
		}			
	}
	
	/**
	 * Metodo que revisa los cambios en la ventana y los agrega a  la lista
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(! model.isSelectionEmpty()){
			// Get selected row
			// int selectedRow = model.getMinSelectionIndex();
			JOptionPane.showMessageDialog(null,tabla.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn()));
			String[] valor = String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn())).split(" ");
			String val = valor[1];
			
			System.out.println(valor);
			
			Mostrar objm = null;
			try {
				objm = new Mostrar(myCon, val);
			} catch (SQLException e1) {

				System.out.println(e1.getMessage());
			}
			objm.setVisible(true);
		}		
	}
		
}
