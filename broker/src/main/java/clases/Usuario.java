package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import exceptions.AñoInvalidoException;
import exceptions.ContraseñaVaciaException;
import exceptions.EmailValidoException;
import superclases.EntidadConNombre;
import utils.UtilsDB;

public class Usuario extends EntidadConNombre{

	private ArrayList<Operacion>numeroAccionesCompradas;
	private int saldoInvertido;
	private int saldoLibre;
	private String apellidos;
	private String cuentaBanco;
	private String dni;
	private String telefono;
	private String email;
	private String contraseña;
	private LocalDate fechaNacimiento;
	
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		//La consulta se debe de hacer modificando la variable especifica del setter y haciendolo
		//solo donde la PK coincida.
		
		if(smt.executeUpdate("update usuario set fechaNacimiento='"+fechaNacimiento+"' where dni='"+this.dni+"'")>0) {
			this.fechaNacimiento = fechaNacimiento;

		}
		
		UtilsDB.desconectarBD();
	}
	
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		//La consulta se debe de hacer modificando la variable especifica del setter y haciendolo
		//solo donde la PK coincida.
		
		if(smt.executeUpdate("update usuario set contraseña='"+contraseña+"' where dni='"+this.dni+"'")>0) {
			this.contraseña = contraseña;

		}
		
		UtilsDB.desconectarBD();
	}
	public ArrayList<Operacion> getNumeroAccionesCompradas() {
		return numeroAccionesCompradas;
	}
	public void setNumeroAccionesCompradas(ArrayList<Operacion> numeroAccionesCompradas) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		//La consulta se debe de hacer modificando la variable especifica del setter y haciendolo
		//solo donde la PK coincida.
		
		if(smt.executeUpdate("update usuario set numeroAccionesCompradas='"+numeroAccionesCompradas+"' where dni='"+this.dni+"'")>0) {
			this.numeroAccionesCompradas = numeroAccionesCompradas;

		}
		
		UtilsDB.desconectarBD();
	}
	public int getSaldoInvertido() {
		return saldoInvertido;
	}
	public void setSaldoInvertido(int saldoInvertido) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		//La consulta se debe de hacer modificando la variable especifica del setter y haciendolo
		//solo donde la PK coincida.
		
		if(smt.executeUpdate("update usuario set saldoInvertido='"+saldoInvertido+"' where dni='"+this.dni+"'")>0) {
			this.saldoInvertido = saldoInvertido;

		}
		
		UtilsDB.desconectarBD();
	}
	public int getSaldoLibre() {
		return saldoLibre;
	}
	public void setSaldoLibre(int saldoLibre) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		//La consulta se debe de hacer modificando la variable especifica del setter y haciendolo
		//solo donde la PK coincida.
		
		if(smt.executeUpdate("update usuario set saldoLibre='"+saldoLibre+"' where dni='"+this.dni+"'")>0) {
			this.saldoLibre = saldoLibre;
		}
		
		UtilsDB.desconectarBD();
		
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) throws SQLException {
		//Primero intentamos el update, si no funciona en BD no se hace en java.
				Statement smt = UtilsDB.conectarBD();
				//La consulta se debe de hacer modificando la variable especifica del setter y haciendolo
				//solo donde la PK coincida.
				
				if(smt.executeUpdate("update usuario set apellidos='"+apellidos+"' where dni='"+this.dni+"'")>0) {
					this.apellidos = apellidos;
				}
				
				UtilsDB.desconectarBD();
	}
	public String getCuentaBanco() {
		return cuentaBanco;
	}
	public void setCuentaBanco(String cuentaBanco) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		//La consulta se debe de hacer modificando la variable especifica del setter y haciendolo
		//solo donde la PK coincida.
		
		if(smt.executeUpdate("update usuario set cuentaBanco='"+cuentaBanco+"' where dni='"+this.dni+"'")>0) {
			this.cuentaBanco = cuentaBanco;
		}
		
		UtilsDB.desconectarBD();
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		//La consulta se debe de hacer modificando la variable especifica del setter y haciendolo
		//solo donde la PK coincida.
		
		if(smt.executeUpdate("update usuario set dni='"+dni+"' where dni='"+this.dni+"'")>0) {
			this.dni = dni;
		}
		
		UtilsDB.desconectarBD();
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		//La consulta se debe de hacer modificando la variable especifica del setter y haciendolo
		//solo donde la PK coincida.
		
		if(smt.executeUpdate("update usuario set telefono='"+telefono+"' where dni='"+this.dni+"'")>0) {
			this.telefono = telefono;
		}
		
		UtilsDB.desconectarBD();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) throws SQLException {
		Statement smt = UtilsDB.conectarBD();
		//La consulta se debe de hacer modificando la variable especifica del setter y haciendolo
		//solo donde la PK coincida.
		
		if(smt.executeUpdate("update usuario set email='"+email+"' where dni='"+this.dni+"'")>0) {
			this.email = email;
		}
		
		UtilsDB.desconectarBD();
	}
	
	
	
	public Usuario(String nombre, ArrayList<Operacion> numeroAccionesCompradas, int saldoInvertido, int saldoLibre,
			String apellidos, String cuentaBanco, String dni, String telefono, String email, String contraseña,
			LocalDate fechaNacimiento) throws SQLException, ContraseñaVaciaException, EmailValidoException {
		super(nombre);
		
		if(contraseña.isBlank()) {
			throw new ContraseñaVaciaException("La contraseña no puede estar vacia.");
		}
		
		if(!this.emailValido(email)) {
			throw new EmailValidoException("El email tiene que tener @.");
		}
		
		Statement query=UtilsDB.conectarBD();
		//Insertar
		
		
		if(query.executeUpdate("insert into usuario values(id,nombre,apellidos,email,contraseña,fechaNacimiento,numeroAcciones,saldoInvertido,saldoLibre,cuentaBanco)"
				+ "('"+nombre+"','"+apellidos+"','"+dni+"','"+telefono+"','"+email+"','"+
				contraseña+"',"+numeroAccionesCompradas+",'"+saldoInvertido+"','"+saldoLibre+"','"+cuentaBanco+"')")>0) {
			this.nombre = nombre;
			this.setEmail(email);
			this.setContraseña(contraseña);
			this.numeroAccionesCompradas = numeroAccionesCompradas;
			this.saldoInvertido = saldoInvertido;
			this.saldoLibre = saldoLibre;
			this.apellidos = apellidos;
			this.cuentaBanco = cuentaBanco;
			this.dni = dni;
			this.telefono = telefono;
			
		}else {
			throw new SQLException("No se ha podido insertar el usuario.");
		}
		UtilsDB.desconectarBD();
	}
		
		
	public boolean eliminar() {
		//El borrado lo hacemos con la PK para no equivocarnos y borrar lo que no es.
		
		Statement smt = UtilsDB.conectarBD();
		boolean ret;
		try {
			//Primero lo eliminamos de la base de datos.
			ret = smt.executeUpdate("delete from usuario where dni='"+this.dni+"'")>0;
			//Luego lo eliminamos de Java.
			this.nombre = null;
			this.email=null;
			this.contraseña=null;
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
	
	public ArrayList<Noticia> getNoticias(){
		Statement smt = UtilsDB.conectarBD();

		ArrayList<Noticia> ret = new ArrayList<Noticia>();
		
		try {
			ResultSet cursor=smt.executeQuery("select * from empresa where nombre ='"+this.nombre+"'");
			while(cursor.next()) {
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
	
	
	
	private boolean contraseñaValida(String pass) {
		return !pass.isBlank();
	}
	
	private boolean emailValido(String email) {
		return email.contains("@");
	}
	
	
	@Override
	public String toString() {
		return "Usuario [numeroAccionesCompradas=" + numeroAccionesCompradas + ", saldoInvertido=" + saldoInvertido
				+ ", saldoLibre=" + saldoLibre + ", apellidos=" + apellidos + ", cuentaBanco=" + cuentaBanco + ", dni="
				+ dni + ", telefono=" + telefono + ", email=" + email + "]";
	}
	@Override
	public int compareTo(Object o) {
		Usuario otro=(Usuario)o;
		return this.nombre.compareTo(otro.nombre);
	}

	@Override
	public boolean equals(Object obj) {
		Usuario otro=(Usuario)obj;
		return this.nombre.equals(otro.nombre);
	}
	
}
