package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import exceptions.AñoInvalidoException;
import exceptions.ContraseñaIncorrectaException;
import exceptions.ContraseñaVaciaException;
import exceptions.EmailValidoException;
import exceptions.UsuarioNoExisteException;
import superclases.EntidadConNombre;
import utils.UtilsDB;
/**
 * 
 * @author gonzalo
 *
 */
public class Usuario extends EntidadConNombre implements Comparable {

	private ArrayList<Operacion> numeroAccionesCompradas;
	private int saldoInvertido;
	private int saldoLibre;
	private String apellidos;
	private String cuentaBanco;
	private String dni;
	private String telefono;
	private String email;
	private String contraseña;
	private LocalDate fechaNacimiento;

	/**
	 * Getter fechaNacimiento
	 * @return fechaNacimiento
	 */
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Setter de FechaNacimiento que conecta a la base de datos y la actualiza
	 * @param fechaNacimiento
	 * @throws SQLException
	 */
	public void setFechaNacimiento(LocalDate fechaNacimiento) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		// La consulta se debe de hacer modificando la variable especifica del setter y
		// haciendolo
		// solo donde la PK coincida.

		if (smt.executeUpdate(
				"update usuario set fechaNacimiento='" + fechaNacimiento + "' where dni='" + this.dni + "'") > 0) {
			this.fechaNacimiento = fechaNacimiento;

		}

		UtilsDB.desconectarBD();
	}

	/**
	 * Getter de contraseña
	 * @return contraseña
	 */
	public String getContraseña() {
		return contraseña;
	}

	/**
	 * Setter de contraseña que conecta a la base de datos y la actualiza
	 * @param contraseña
	 * @throws SQLException
	 */
	public void setContraseña(String contraseña) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		// La consulta se debe de hacer modificando la variable especifica del setter y
		// haciendolo
		// solo donde la PK coincida.

		if (smt.executeUpdate("update usuario set contrasena='" + contraseña + "' where dni='" + this.dni + "'") > 0) {
			this.contraseña = contraseña;

		}

		UtilsDB.desconectarBD();
	}

	/**
	 * Getter del arrayList de numeroAccionesCompradas
	 * @return numeroAccionesCompradas
	 */
	public ArrayList<Operacion> getNumeroAccionesCompradas() {
		return numeroAccionesCompradas;
	}

	/**
	 * Setter de numeroAccionesCompradas que conecta a la base de datos y la actualiza
	 * @param numeroAccionesCompradas
	 * @throws SQLException
	 */
	public void setNumeroAccionesCompradas(ArrayList<Operacion> numeroAccionesCompradas) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		// La consulta se debe de hacer modificando la variable especifica del setter y
		// haciendolo
		// solo donde la PK coincida.

		if (smt.executeUpdate("update usuario set numeroAccionesCompradas='" + numeroAccionesCompradas + "' where dni='"
				+ this.dni + "'") > 0) {
			this.numeroAccionesCompradas = numeroAccionesCompradas;

		}

		UtilsDB.desconectarBD();
	}

	/**
	 * Getter de saldoInvertido
	 * @return saldoInvertido
	 */
	public int getSaldoInvertido() {
		return saldoInvertido;
	}
	/**
	 * Setter saldoInvertido que conecta con base de datos y la actualiza
	 * @param saldoInvertido
	 * @throws SQLException
	 */
	public void setSaldoInvertido(int saldoInvertido) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		// La consulta se debe de hacer modificando la variable especifica del setter y
		// haciendolo
		// solo donde la PK coincida.

		if (smt.executeUpdate(
				"update usuario set saldoInvertido='" + saldoInvertido + "' where dni='" + this.dni + "'") > 0) {
			this.saldoInvertido = saldoInvertido;

		}

		UtilsDB.desconectarBD();
	}
	/**
	 * Getter saldoLibre
	 * @return saldoLibre
	 */
	public int getSaldoLibre() {
		return saldoLibre;
	}
	/**
	 * Setter saldoLibre que conecta con base de datos y la actualiza
	 * @param saldoLibre
	 * @throws SQLException
	 */
	public void setSaldoLibre(int saldoLibre) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		// La consulta se debe de hacer modificando la variable especifica del setter y
		// haciendolo
		// solo donde la PK coincida.

		if (smt.executeUpdate("update usuario set saldoLibre='" + saldoLibre + "' where dni='" + this.dni + "'") > 0) {
			this.saldoLibre = saldoLibre;
		}

		UtilsDB.desconectarBD();

	}
	/**
	 * Getter apellidos
	 * @return apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Setter apellidos que no conecta con base de datos y la actualiza
	 * @param apellidos
	 * @throws SQLException
	 */
	public void setApellidos(String apellidos) throws SQLException {
		// Primero intentamos el update, si no funciona en BD no se hace en java.
		Statement smt = UtilsDB.conectarBD();
		// La consulta se debe de hacer modificando la variable especifica del setter y
		// haciendolo
		// solo donde la PK coincida.

		if (smt.executeUpdate("update usuario set apellidos='" + apellidos + "' where dni='" + this.dni + "'") > 0) {
			this.apellidos = apellidos;
		}

		UtilsDB.desconectarBD();
	}

	/**
	 * Getter cuentaBanco
	 * @return cuentaBanco
	 */
	public String getCuentaBanco() {
		return cuentaBanco;
	}
	/**
	 * Setter cuentaBanco que no conecta con base de datos y la actualiza
	 * @param cuentaBanco
	 * @throws SQLException
	 */
	public void setCuentaBanco(String cuentaBanco) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		// La consulta se debe de hacer modificando la variable especifica del setter y
		// haciendolo
		// solo donde la PK coincida.

		if (smt.executeUpdate(
				"update usuario set cuentaBanco='" + cuentaBanco + "' where dni='" + this.dni + "'") > 0) {
			this.cuentaBanco = cuentaBanco;
		}

		UtilsDB.desconectarBD();
	}
	/**
	 * Getter Dni
	 * @return dni
	 */
	public String getDni() {
		return dni;
	}
	/**
	 * Setter dni que no conecta con base de datos y la actualiza
	 * @param dni
	 * @throws SQLException
	 */
	public void setDni(String dni) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		// La consulta se debe de hacer modificando la variable especifica del setter y
		// haciendolo
		// solo donde la PK coincida.

		if (smt.executeUpdate("update usuario set dni='" + dni + "' where dni='" + this.dni + "'") > 0) {
			this.dni = dni;
		}

		UtilsDB.desconectarBD();
	}

	/**
	 * Getter telefono
	 * @return telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * Setter telefono que no conecta con base de datos y la actualiza
	 * @param telefono
	 * @throws SQLException
	 */
	public void setTelefono(String telefono) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		// La consulta se debe de hacer modificando la variable especifica del setter y
		// haciendolo
		// solo donde la PK coincida.

		if (smt.executeUpdate("update usuario set telefono='" + telefono + "' where dni='" + this.dni + "'") > 0) {
			this.telefono = telefono;
		}

		UtilsDB.desconectarBD();
	}
	/**
	 * Getter email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter email que no conecta con base de datos y la actualiza
	 * @param email
	 * @throws SQLException
	 */
	public void setEmail(String email) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		// La consulta se debe de hacer modificando la variable especifica del setter y
		// haciendolo
		// solo donde la PK coincida.

		if (smt.executeUpdate("update usuario set email='" + email + "' where dni='" + this.dni + "'") > 0) {
			this.email = email;
		}

		UtilsDB.desconectarBD();
	}

	/**
	 * Constructor de la clase usuario que rellena y toma todos los datos qye tiene un usuario y además protege con excepciones las diferentes variables
	 * claves del login de usuario,además conecta con la base de datos e inserta los datos.
	 * @param nombre
	 * @param numeroAccionesCompradas
	 * @param saldoInvertido
	 * @param saldoLibre
	 * @param apellidos
	 * @param cuentaBanco
	 * @param dni
	 * @param telefono
	 * @param email
	 * @param contraseña
	 * @param fechaNacimiento
	 * @throws SQLException
	 * @throws ContraseñaVaciaException
	 * @throws EmailValidoException
	 */
	public Usuario(String nombre, ArrayList<Operacion> numeroAccionesCompradas, int saldoInvertido, int saldoLibre,
			String apellidos, String cuentaBanco, String dni, String telefono, String email, String contraseña,
			LocalDate fechaNacimiento) throws SQLException, ContraseñaVaciaException, EmailValidoException {
		super(nombre);

		if (contraseña.isBlank()) {
			throw new ContraseñaVaciaException("La contraseña no puede estar vacia.");
		}

		if (!this.emailValido(email)) {
			throw new EmailValidoException("El email tiene que tener @.");
		}

		Statement query = UtilsDB.conectarBD();
		// Insertar

		if (query.executeUpdate("insert into usuario VALUES ('" + nombre + "','" + apellidos + "','" + email + "','"
				+ contraseña + "','" + fechaNacimiento + "','" + numeroAccionesCompradas + "','" + saldoInvertido
				+ "','" + saldoLibre + "','" + cuentaBanco + "','" + dni + "','" + telefono + "')") > 0) {
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.setEmail(email);
			this.setContraseña(contraseña);
			this.fechaNacimiento = fechaNacimiento;
			this.numeroAccionesCompradas = numeroAccionesCompradas;
			this.saldoInvertido = saldoInvertido;
			this.saldoLibre = saldoLibre;
			this.cuentaBanco = cuentaBanco;
			this.dni = dni;
			this.telefono = telefono;

		} else {
			throw new SQLException("No se ha podido insertar el usuario.");
		}
		UtilsDB.desconectarBD();
	}

	/**
	 * Constructor vacio de clase usuario
	 */
	public Usuario() {
		super("nombre");
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor usuario que toma los datos de usuario y contraseña solamente para permitir el login en la interfaz
	 * @param nombre
	 * @param contraseña
	 * @throws SQLException
	 * @throws ContraseñaIncorrectaException
	 * @throws UsuarioNoExisteException
	 */
	public Usuario(String nombre, String contraseña) throws SQLException, ContraseñaIncorrectaException, UsuarioNoExisteException {
		super(nombre);
		Statement smt=UtilsDB.conectarBD();
        ResultSet cursor=smt.executeQuery("select * from usuario where nombre='"+nombre+"'");

        if(cursor.next()) {
        	this.contraseña = cursor.getString("contrasena");
        	
        	if(!this.contraseña.equals(contraseña)) {
        		UtilsDB.desconectarBD();
        		throw new ContraseñaIncorrectaException("La contraseña no es correcta.");
        	}
        	
        	this.nombre = cursor.getString("nombre");
        	this.apellidos = cursor.getString("apellidos");
        	this.dni = cursor.getString("dni");
        	this.cuentaBanco = cursor.getString("cuentaBanco");
        	this.saldoInvertido = cursor.getInt("saldoInvertido");
        	this.saldoLibre = cursor.getInt("saldoLibre");
        	this.contraseña = cursor.getString("contrasena");
        	this.email = cursor.getString("email");
        	this.fechaNacimiento=cursor.getDate("fechaNacimiento").toLocalDate();
        	this.telefono=cursor.getString("telefono");
            UtilsDB.desconectarBD();
            //
          /* Statement smt2=UtilsDB.conectarBD();
           smt2.executeQuery("select * from acciones where usuario='"+dni+"'");
            while(numeroAccionesCompradas!= null) {
          
            	ArrayList<Operacion>numeroAccionesCompradas =new ArrayList<Operacion>();
            	for(int i = 0;i<numeroAccionesCompradas.size();i++){
            		if(numeroAccionesCompradas.get(i).esComprada(getNumeroAccionesCompradas())){
                         numeroAccionesCompradas.add(numeroAccionesCompradas.get(i));
                         }
                         
                        }
            	}
           
            */
            	/*
             * 
             * 
             * arraylist todas ls acciones(las pilla d bbdd)
             * arraylist comprados(solo inicializarlo)
             * 
             * for(todasLasAcciones.size){
             * if(todasLasAcciones-get(i).isComprada(getter comprada(bool)){
             * comprados.add(todasLasAcciones-get(i));
             * }
             * 
             * }
             * 
             * 
             * */
       
            //Creas un bucle que te vaya relleneando acciones y metiendolo en el arraylist interno
           // smt2.executeQuery("select * from acciones where usuario='"+this.dni+"'");
            //Creas un bucle que te vaya relleneando acciones y metiendolo en el arraylist interno
           // smt2.executeQuery("select * from etf where usuario='"+this.dni+"'");
            //Creas un bucle que te vaya relleneando etf y metiendolo en el arraylist interno
           // UtilsDB.desconectarBD();
        }else{
		UtilsDB.desconectarBD();
		throw new UsuarioNoExisteException("No existe el usuario en la BD.");
	}
    UtilsDB.desconectarBD();
}
	/**
	 * Constructor de la clase usuario sin numeroAcciones compradas para el registro ya que el usuario comenzara con 0 acciones compradas o null
	 * @param nombre
	 * @param saldoInvertido
	 * @param saldoLibre
	 * @param apellidos
	 * @param cuentaBanco
	 * @param dni
	 * @param telefono
	 * @param email
	 * @param contraseña
	 * @param fechaNacimiento
	 * @throws EmailValidoException
	 * @throws ContraseñaVaciaException
	 * @throws SQLException
	 */
	public Usuario(String nombre, int saldoInvertido, int saldoLibre, String apellidos, String cuentaBanco, String dni,
			String telefono, String email, String contraseña, LocalDate fechaNacimiento)
			throws EmailValidoException, ContraseñaVaciaException, SQLException {
		super(nombre);

		if (contraseña.isBlank()) {
			throw new ContraseñaVaciaException("La contraseña no puede estar vacia.");
		}

		if (!this.emailValido(email)) {
			throw new EmailValidoException("El email tiene que tener @.");
		}

		Statement query = UtilsDB.conectarBD();
		// Insertar

		if (query.executeUpdate("insert into usuario VALUES ('" + nombre + "','" + apellidos + "','" + email + "','"
				+ contraseña + "','" + fechaNacimiento + "','" + saldoInvertido + "','" + saldoLibre + "','"
				+ cuentaBanco + "','" + dni + "','" + telefono + "')") > 0) {
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.setEmail(email);
			this.setContraseña(contraseña);
			this.fechaNacimiento = fechaNacimiento;
			this.numeroAccionesCompradas = numeroAccionesCompradas;
			this.saldoInvertido = saldoInvertido;
			this.saldoLibre = saldoLibre;
			this.cuentaBanco = cuentaBanco;
			this.dni = dni;
			this.telefono = telefono;

		} else {
			throw new SQLException("No se ha podido insertar el usuario.");
		}
		UtilsDB.desconectarBD();
	}
	/**
	 * DAo para eliminar  que conecta con la base de datos y su objetivo es eliminar un usuario
	 * @return
	 */
	public boolean eliminar() {
		// El borrado lo hacemos con la PK para no equivocarnos y borrar lo que no es.

		Statement smt = UtilsDB.conectarBD();
		boolean ret;
		try {
			// Primero lo eliminamos de la base de datos.
			ret = smt.executeUpdate("delete from usuario where dni='" + this.dni + "'") > 0;
			// Luego lo eliminamos de Java.
			this.nombre = null;
			this.email = null;
			this.contraseña = null;
			this.numeroAccionesCompradas = null;
			this.saldoInvertido = (Integer) null;
			this.saldoLibre = (Integer) null;
			this.apellidos = null;
			this.cuentaBanco = null;
			this.dni = null;
			this.telefono = null;
		} catch (SQLException e) {
			UtilsDB.desconectarBD();
			return false;
		}
		UtilsDB.desconectarBD();
		return ret;
	}

	/**
	 * DAO noticias que conecta con la base de datos y toma el nombre de la noticia y lo returnea añadiendolo al arrayList 
	 * @return ret
	 */
	public ArrayList<Noticia> getNoticias() {
		Statement smt = UtilsDB.conectarBD();

		ArrayList<Noticia> ret = new ArrayList<Noticia>();

		try {
			ResultSet cursor = smt.executeQuery("select * from empresa where nombre ='" + this.nombre + "'");
			while (cursor.next()) {
				Noticia actual = new Noticia(nombre);

				actual.fecha = cursor.getDate("fecha").toLocalDate();
				actual.cuerpo = cursor.getString("cuerpo");
				actual.nombre = cursor.getString("nombre");

				ret.add(actual);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		UtilsDB.desconectarBD();
		return ret;
	}
	/**
	 * DAO noticias que conecta con la base de datos y toma todos las variables del usuario y lo returnea añadiendolo al arrayList 
	 * @return ret
	 */
	public static ArrayList<Usuario> getTodos() {
		Statement smt = UtilsDB.conectarBD();
		// Inicializamos un ArrayList para devolver.
		ArrayList<Usuario> ret = new ArrayList<Usuario>();

		try {
			ResultSet cursor = smt.executeQuery("select * from usuario");
			while (cursor.next()) {
				Usuario actual = new Usuario();

				actual.nombre = cursor.getString("nombre");
				actual.apellidos = cursor.getString("apellidos");
				actual.dni = cursor.getString("dni");
				actual.cuentaBanco = cursor.getString("cuentaBanco");
				// actual.numeroAccionesCompradas = (ArrayList<Operacion>)
				// cursor.getArray("numeroAccionesCompradas");
				actual.saldoInvertido = cursor.getInt("saldoInvertido");
				actual.saldoLibre = cursor.getInt("saldoLibre");
				actual.contraseña = cursor.getString("contrasena");
				actual.email = cursor.getString("email");
				actual.fechaNacimiento = cursor.getDate("fechaNacimiento").toLocalDate();

				ret.add(actual);
			}
		} catch (SQLException e) {
			// Si la conuslta falla no hay nada que devolver.
			e.printStackTrace();
			return null;
		}
		// Si no hay usuarios en la tabla, va a devolver un arraylist vacio.
		// Si la consulta fue erronea se devuelve un arraylist null, que son cosas
		// distintas.
		UtilsDB.desconectarBD();
		return ret;
	}

	/**
	 * Funcion que protegue que la contraseña sea valida
	 * @param pass
	 * @return
	 */
	private boolean contraseñaValida(String pass) {
		return !pass.isBlank();
	}

	/**
	 * Funcion que protegue el email para que contenga un arroba como formato correcto
	 * @param email
	 * @return
	 */
	private boolean emailValido(String email) {
		return email.contains("@");
	}

	/**
	 * toString que imprime todas las variables de la clase
	 */
	@Override
	public String toString() {
		return "Usuario [numeroAccionesCompradas=" + numeroAccionesCompradas + ", saldoInvertido=" + saldoInvertido
				+ ", saldoLibre=" + saldoLibre + ", apellidos=" + apellidos + ", cuentaBanco=" + cuentaBanco + ", dni="
				+ dni + ", telefono=" + telefono + ", email=" + email + "]";
	}

	@Override
	public int compareTo(Object o) {
		Usuario otro = (Usuario) o;
		return this.nombre.compareTo(otro.nombre);
	}

	@Override
	public boolean equals(Object obj) {
		Usuario otro = (Usuario) obj;
		return this.nombre.equals(otro.nombre);
	}
	/**
	 * 
	 * @param numeroAccionesCompradas
	 * @return
	 */
	public static boolean esComprada(ArrayList<Operacion> numeroAccionesCompradas) {
		if (numeroAccionesCompradas != null) {
			return true;
		} else {
			return false;
		}
	}
}
