import javax.swing.JOptionPane;

public class AppDatos {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Alumno al = new Alumno("Alejandro", "Belmar", "Otañez", "28", "Ecatepec","belmale@hotmail.com","5543873834","2513360038","55067","Soltero","14 Noviembre");
		
		JOptionPane.showMessageDialog(null,
				String.format("Hola  %s %s %s \n Edad: %s\n Vives en: %s\n Correo: %s\n Telefono: %s \n Matricula: %s \n Codigo Postal: %s \n Estado Civil: %s \n Fecha de Nacimiento: %s  ",
						al.getNombre(), 
						al.getApp(), 
						al.getApm(), 
						al.getEdad(), 
						al.getDireccion(), 
						al.getCorreo(), 
						al.getTelefono(), 
						al.getMatricula(), 
						al.getCodPostal(), 
						al.getEstadoCivil(), 
						al.getFechaNac()
						)
				);

	}

}
