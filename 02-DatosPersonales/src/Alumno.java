
/**
 * 
 * @author Heriberto Martinez
 */

public class Alumno {
	
	private String nombre;
	private String app;
	private String apm;
	private String edad;
	private String direccion;
	private String correo;
	private String telefono;
	private String matricula;
	private String codPostal;
	private String estadoCivil;
	private String fechaNac;
	
	/**
	 * Constructor sin parametros
	 */
		public Alumno(){}

		/**
		 * 
		 * @param nombre Nombre de la persona en formato String
		 * @param app Apellido paterno de la persona en formato String
		 * @param apm Apeliido materno de la persona en formato String
		 * @param edad Edad de la persona en formato String
		 * @param direccion Direccion de la persona en formato String
		 * @param correo Correo Electronico de la persona en formato String
		 * @param telefono Telefono de la persona en formato String
		 * @param matricula Matricula de la persona en formato String
		 * @param codPostal Codigo Postal de la persona en formato String
		 * @param estadoCivil Estado civil de la persona en formato String
		 * @param fechaNac Fecha de nacimiento de la persona en formato String
		 */
		public Alumno(String nombre, String app, String apm, String edad, String direccion, String correo,
				String telefono, String matricula, String codPostal, String estadoCivil, String fechaNac) {
			super();
			this.nombre = nombre;
			this.app = app;
			this.apm = apm;
			this.edad = edad;
			this.direccion = direccion;
			this.correo = correo;
			this.telefono = telefono;
			this.matricula = matricula;
			this.codPostal = codPostal;
			this.estadoCivil = estadoCivil;
			this.fechaNac = fechaNac;
		}
/**
 * 
 * @return Retorna el nombre de la persona
 */
		

		public String getNombre() {
			return nombre;
		}
	/**
	 * 
	 * @return Retorna el apellido paterno de la persona
	 */

		public String getApp() {
			return app;
		}

/**
 * 
 * @param app Introduce el apellido paterno en formato String
 */
		public void setApp(String app) {
			this.app = app;
		}

/**
 * 
 * @return Retorna el apellido materno en formato String
 */
		public String getApm() {
			return apm;
		}
/**
 * 
 * @param apm Introduce el apellido materno en formato String
 */

		public void setApm(String apm) {
			this.apm = apm;
		}

		/**
		 * 
		 * @return Retorna la direccion en fromato String 
		 */

		public String getDireccion() {
			return direccion;
		}

		/**
		 * 
		 * @param direccion Introduce la direccion en formato String
		 */

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		/**
		 * 
		 * @return Retorna el correo en formato String
		 */

		public String getCorreo() {
			return correo;
		}
/**
 * 
 * @param correo Introduce el correo en formato String
 */
		

		public void setCorreo(String correo) {
			this.correo = correo;
		}
/**
 * 
 * @return Retorna la matricula en formato String
 */

		public String getMatricula() {
			return matricula;
		}

/**
 * 
 * @param matricula Retorna la matricula en formato String
 */
		public void setMatricula(String matricula) {
			this.matricula = matricula;
		}

/**
 * 
 * @return  Retorna el codigo Postal en formato String
 */
		public String getCodPostal() {
			return codPostal;
		}

/**
 * 
 * @param codPostal InTRODUCE EL CODIGO Postal en formato String
 */
		public void setCodPostal(String codPostal) {
			this.codPostal = codPostal;
		}

/**
 * 
 * @return Retorna el Estado civil en formato String
 */
		public String getEstadoCivil() {
			return estadoCivil;
		}
/**
 * 
 * @param estadoCivil Introduce el estado civil en formato String 
 */

		public void setEstadoCivil(String estadoCivil) {
			this.estadoCivil = estadoCivil;
		}

/**
 * 
 * @return Retorna  Fecha de nacimiento en formato String
 */
		public String getFechaNac() {
			return fechaNac;
		}

/**
 * 
 * @param fechaNac Introduce la fecha de nacimiento en formato String
 */
		public void setFechaNac(String fechaNac) {
			this.fechaNac = fechaNac;
		}
/**
 * 
 * @param nombre Introduce el nombre en formato String
 */

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
/**
 * 
 * @return Retorna la edad en Formato String
 */
		public String getEdad() {
			return edad;
		}
/**
 * 
 * @param edad Introduce la edad en formato String
 */

		public void setEdad(String edad) {
			this.edad = edad;
		}
/**
 * 
 * @return Retorna el telefono en formato String
 */

		public String getTelefono() {
			return telefono;
		}
/**
 * 
 * @param telefono Introduce el telefono en formato String
 */

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		
		

}
